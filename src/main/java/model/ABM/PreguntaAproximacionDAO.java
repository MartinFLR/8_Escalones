package model.ABM;

import model.PreguntaAproximacion;
import model.PreguntaOpcion;
import model.Preguntas;
import model.Respuesta;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PreguntaAproximacionDAO implements DAOPreguntas<PreguntaAproximacion> {

    //este es la posta
    public void insertar(PreguntaAproximacion nuevaPregunta, List<Respuesta> respuestas) {
        String queryPregunta = "INSERT INTO preguntas (pregunta, id_tipopregunta, id_tema) "
                + "VALUES (?, ?, ?)";

        String queryRespuesta = "INSERT INTO respuestas (id_pregunta, respuesta, respuesta_correcta) "
                + "VALUES (?, ?, ?)";

        try (Connection connection = Database.getInstance().getConnection();
             PreparedStatement stmtPregunta = connection.prepareStatement(queryPregunta, Statement.RETURN_GENERATED_KEYS);
             PreparedStatement stmtRespuesta = connection.prepareStatement(queryRespuesta)) {

            connection.setAutoCommit(false);

            stmtPregunta.setString(1, nuevaPregunta.getPregunta());
            stmtPregunta.setInt(2, 2);
            stmtPregunta.setInt(3, nuevaPregunta.getIdTema());
            stmtPregunta.executeUpdate();


            try (ResultSet rs = stmtPregunta.getGeneratedKeys()) {
                if (rs.next()) {
                    int idPregunta = rs.getInt(1);

                    for (Respuesta respuesta : respuestas) {
                        stmtRespuesta.setInt(1, idPregunta);
                        stmtRespuesta.setString(2, respuesta.getRespuesta());
                        stmtRespuesta.setBoolean(3, respuesta.isRespuestaCorrecta());
                        stmtRespuesta.addBatch();
                    }

                    stmtRespuesta.executeBatch();

                    connection.commit();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();

        }
    }

    public List<PreguntaAproximacion> buscarTodos() {
        List<PreguntaAproximacion> preguntas = new ArrayList<>();
        String query = "SELECT p.id_pregunta, p.pregunta, tp.tipo_pregunta AS tipoPregunta, "
                + "(SELECT r.respuesta "
                + " FROM respuestas r "
                + " WHERE r.id_pregunta = p.id_pregunta AND r.respuesta_correcta = TRUE LIMIT 1) AS respuesta_correcta, "
                + " t.id_tema AS tema_id "
                + "FROM preguntas p "
                + "JOIN tipo_pregunta as tp ON tp.id_tipo = p.id_tipopregunta "
                + "LEFT JOIN tema t ON p.id_tema = t.id_tema "
                + "WHERE p.id_tipopregunta = 2";

        try (Connection connection = Database.getInstance().getConnection();
             Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                int idPregunta = rs.getInt("id_pregunta");
                String pregunta = rs.getString("pregunta");
                String tipoPregunta = rs.getString("tipoPregunta");

                // Obtener la respuesta correcta, si es NULL, se asigna un valor predeterminado
                String respuestaCorrecta = rs.getString("respuesta_correcta");
                if (respuestaCorrecta == null) {
                    respuestaCorrecta = "No tiene respuesta correcta";  // O un valor predeterminado adecuado
                }

                int temaId = rs.getInt("tema_id");

                PreguntaAproximacion preguntaAprox = new PreguntaAproximacion(idPregunta, pregunta, respuestaCorrecta, temaId);
                preguntas.add(preguntaAprox);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return preguntas;
    }

    public void eliminar(int id) {
        String query = "DELETE FROM preguntas WHERE id_pregunta = ?";

        try (Connection connection = Database.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            int rowsAffected = statement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Pregunta eliminada con éxito.");
            } else {
                System.out.println("Pregunta no encontrada.");
            }
        } catch (SQLException e) {
            System.err.println("Error al eliminar la pregunta: " + e.getMessage());
        }

    }

    @Override
    public void modificar(int id, PreguntaAproximacion entidad, List<Respuesta> respuestas) {
        String queryPregunta = "UPDATE preguntas SET pregunta = ?, id_tema = ?, id_tipopregunta = ? WHERE id_pregunta = ?";
        String deleteRespuestas = "DELETE FROM respuestas WHERE id_pregunta = ?";
        String insertRespuesta = "INSERT INTO respuestas (id_pregunta, respuesta, respuesta_correcta) VALUES (?, ?, ?)";

        try (Connection connection = Database.getInstance().getConnection();
             PreparedStatement stmtPregunta = connection.prepareStatement(queryPregunta);
             PreparedStatement stmtDeleteRespuestas = connection.prepareStatement(deleteRespuestas);
             PreparedStatement stmtInsertRespuesta = connection.prepareStatement(insertRespuesta)) {

            connection.setAutoCommit(false);

            // Actualizar la pregunta
            stmtPregunta.setString(1, entidad.getPregunta());
            stmtPregunta.setInt(2, entidad.getIdTema());
            stmtPregunta.setInt(3, 2);
            stmtPregunta.setInt(4, id);

            stmtPregunta.executeUpdate();

            // Eliminar respuestas antiguas
            stmtDeleteRespuestas.setInt(1, id);
            stmtDeleteRespuestas.executeUpdate();

            // Insertar las nuevas respuestas
            for (Respuesta respuesta : respuestas) {
                stmtInsertRespuesta.setInt(1, id);
                stmtInsertRespuesta.setString(2, respuesta.getRespuesta());
                stmtInsertRespuesta.setBoolean(3, respuesta.isRespuestaCorrecta());
                stmtInsertRespuesta.addBatch();
            }
            stmtInsertRespuesta.executeBatch();

            // Confirmar la transacción
            connection.commit();

            System.out.println("Pregunta y respuestas actualizadas exitosamente.");
        } catch (SQLException e) {
            try (Connection connection = Database.getInstance().getConnection()) {
                connection.rollback();  // Revertir cambios en caso de error
            } catch (SQLException ex) {
                System.out.println("Error al revertir la transacción: " + ex.getMessage());
            }
            System.out.println("Error al modificar la pregunta: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    @Override
    public List<PreguntaAproximacion> busqueda(String palabra, int id_tema) {
        List<PreguntaAproximacion> palabras = new ArrayList<>();
        String sql = "SELECT id_pregunta, pregunta, id_tema FROM preguntas "+
                "WHERE TRANSLATE(LOWER(pregunta), 'áéíóúÁÉÍÓÚñÑ', 'aeiouAEIOUnN') "+"" +
                "LIKE TRANSLATE(LOWER(?), 'áéíóúÁÉÍÓÚñÑ', 'aeiouAEIOUnN') AND id_tema = ? AND id_tipopregunta = 2";
        try (Connection conn = Database.getInstance().getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // Verifica si la palabra no es nula
            if (palabra == null) {
                palabra = ""; // Evita problemas con null
            }
            pstmt.setString(1, "%" + palabra + "%");
            pstmt.setInt(2, id_tema);

            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    palabras.add(new PreguntaAproximacion(
                            rs.getInt("id_pregunta"),
                            rs.getString("pregunta"),
                            rs.getInt("id_tema")
                    ));
                    System.out.println("Búsqueda exitosa");
                }
            }

        } catch (SQLException e) {
            System.out.println("Error al buscar: " + e.getMessage());
        }
        return palabras;
    }
}