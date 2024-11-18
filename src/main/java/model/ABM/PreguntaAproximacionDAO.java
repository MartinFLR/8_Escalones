package model.ABM;

import model.PreguntaAproximacion;
import model.PreguntaOpcion;
import model.Preguntas;
import model.Respuesta;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PreguntaAproximacionDAO implements DAO<PreguntaAproximacion> {


    public void insertar(PreguntaAproximacion pregunta) {
        String sql = "INSERT INTO preguntas (pregunta, id_tema, id_tipopregunta) VALUES (?, ?, ?)";

        try (Connection connection = Database.getInstance().getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            pstmt.setString(1, pregunta.getPregunta());
            pstmt.setInt(2, pregunta.getIdTema());
            pstmt.setInt(3, 2); // Suponiendo que el id_tipopregunta es 2 para preguntas de aproximación, ajusta esto según sea necesario

            pstmt.executeUpdate();
            ResultSet generatedKeys = pstmt.getGeneratedKeys();
            if (generatedKeys.next()) {
                // Aquí puedes guardar la respuesta correcta en la tabla de respuestas
                insertarRespuesta(generatedKeys.getInt(1), pregunta);
            }
            System.out.println("Pregunta de aproximación agregada exitosamente.");

        } catch (SQLException e) {
            System.out.println("Error al agregar la pregunta de aproximación: " + e.getMessage());
        }
    }

    @Override
    public void modificar(int id, PreguntaAproximacion entidad) {

    }

    public void crearPregunta(PreguntaAproximacion nuevaPregunta, List<Respuesta> respuestas) {
        String queryPregunta = "INSERT INTO preguntas (pregunta, id_tipopregunta, id_tema) "
                + "VALUES (?, ?, ?)";

        String queryRespuesta = "INSERT INTO respuestas (id_pregunta, respuesta, respuesta_correcta) "
                + "VALUES (?, ?, ?)"; // No incluimos id_respuesta

        try (Connection connection = Database.getInstance().getConnection();
             PreparedStatement stmtPregunta = connection.prepareStatement(queryPregunta, Statement.RETURN_GENERATED_KEYS);
             PreparedStatement stmtRespuesta = connection.prepareStatement(queryRespuesta)) {

            connection.setAutoCommit(false);

            // Insertar la nueva pregunta
            stmtPregunta.setString(1, nuevaPregunta.getPregunta());
            stmtPregunta.setInt(2, 2);  // id_tipopregunta debe ser válido
            stmtPregunta.setInt(3, nuevaPregunta.getIdTema());  // id_tema debe ser válido
            stmtPregunta.executeUpdate();

            // Obtener el ID de la pregunta recién insertada
            try (ResultSet rs = stmtPregunta.getGeneratedKeys()) {
                if (rs.next()) {
                    int idPregunta = rs.getInt(1);  // Obtener el ID de la nueva pregunta

                    // Insertar las respuestas asociadas
                    for (Respuesta respuesta : respuestas) {
                        stmtRespuesta.setInt(1, idPregunta);  // Establecer el ID de la pregunta
                        stmtRespuesta.setString(2, respuesta.getRespuesta());
                        stmtRespuesta.setBoolean(3, respuesta.isRespuestaCorrecta());
                        stmtRespuesta.addBatch();  // Usamos batch para insertar varias respuestas
                    }

                    // Ejecutar el batch para insertar todas las respuestas
                    stmtRespuesta.executeBatch();

                    // Commit de la transacción
                    connection.commit();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();

        }
    }

    private void insertarRespuesta(int idPregunta, PreguntaAproximacion pregunta) {
        String sql = "INSERT INTO respuestas (id_pregunta, respuesta_correcta) VALUES (?, ?)";

        try (Connection connection = Database.getInstance().getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql)) {

            pstmt.setInt(1, pregunta.getId_pregunta());
            pstmt.setString(2, pregunta.getRespuestaCorrecta());

            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error al agregar la respuesta: " + e.getMessage());
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

    public void modificarPregunta(int id, PreguntaAproximacion entidad, List<Respuesta> respuestas) {
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
    public List<PreguntaAproximacion> busqueda(String palabra) {
        List<PreguntaAproximacion>palabras = new ArrayList<>();
        String sql = "SELECT id_pregunta, pregunta, id_Tema FROM preguntas WHERE pregunta LIKE ?";
        try(Connection conn = Database.getInstance().getConnection();
        PreparedStatement pstmt = conn.prepareStatement(sql)){
        pstmt.setString(1, "%"+palabra+"%");
            try(ResultSet rs = pstmt.executeQuery()){
                while(rs.next()){
                    palabras.add(new PreguntaAproximacion(rs.getInt("id_pregunta"), rs.getString("pregunta"), rs.getInt("id_tema") ));
                    System.out.println("Busqueda exitosa");
                }
            }

        } catch (SQLException e) {
                  System.out.println("Error al buscar " + e.getMessage());
        }
        return palabras;
    }
}