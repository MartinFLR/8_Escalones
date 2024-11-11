package model.ABM;


import model.PreguntaAproximacion;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PreguntaAproximacionDAO implements DAO<PreguntaAproximacion> {

    private static PreguntaAproximacionDAO instance;

    public static synchronized PreguntaAproximacionDAO getInstance() {
        if (instance == null) {
            instance = new PreguntaAproximacionDAO();
        }
        return instance;
    }

    public void insertar(PreguntaAproximacion pregunta) {
        String sql = "INSERT INTO preguntas (pregunta, id_tema, id_tipopregunta) VALUES (?, ?, ?)";

        try (Connection connection = Database.getInstance().getConnection();
                PreparedStatement pstmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            pstmt.setString(1, pregunta.getPregunta());
            pstmt.setInt(2, pregunta.getIdTema());
            pstmt.setInt(3, 2); // Suponiendo que el id_tipopregunta es 2 para preguntas de aproximación, ajusta
                                // esto según sea necesario

            pstmt.executeUpdate();
            ResultSet generatedKeys = pstmt.getGeneratedKeys();
            if (generatedKeys.next()) {
                int idPregunta = generatedKeys.getInt(1);
                // Aquí puedes guardar la respuesta correcta en la tabla de respuestas
                insertarRespuesta(idPregunta, pregunta);
            }
            System.out.println("Pregunta de aproximación agregada exitosamente.");

        } catch (SQLException e) {
            System.out.println("Error al agregar la pregunta de aproximación: " + e.getMessage());
        }
    }

    private void insertarRespuesta(int idPregunta, PreguntaAproximacion pregunta) {
        String sql = "INSERT INTO respuestas (id_pregunta, respuesta_correcta) VALUES (?, ?)";

        try (Connection connection = Database.getInstance().getConnection();
                PreparedStatement pstmt = connection.prepareStatement(sql)) {

            pstmt.setInt(1, idPregunta);
            pstmt.setString(2, pregunta.getRespuestaCorrecta());

            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error al agregar la respuesta: " + e.getMessage());
        }
    }

    public List<PreguntaAproximacion> buscarTodos() {
        List<PreguntaAproximacion> preguntas = new ArrayList<>();
        String query = "SELECT p.id_pregunta, p.pregunta, r.respuesta AS respuesta_correcta, t.id_tema AS tema_id "
                + "FROM preguntas p "
                + "LEFT JOIN respuestas r ON p.id_pregunta = r.id_pregunta AND r.respuesta_correcta = TRUE "
                + "LEFT JOIN tema t ON p.id_tema = t.id_tema "
                + "WHERE p.id_tipopregunta = 2";

        try (Connection connection = Database.getInstance().getConnection();
                Statement stmt = connection.createStatement();
                ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                int idPregunta = rs.getInt("id_pregunta");
                String pregunta = rs.getString("pregunta");
                String tipoPregunta = rs.getString("tipoPregunta");
                String respuestaCorrecta = rs.getString("respuesta_correcta");
                int temaId = rs.getInt("tema_id"); // Aquí aseguramos que tema_id sea int

                PreguntaAproximacion preguntaAprox = new PreguntaAproximacion(idPregunta, pregunta, tipoPregunta,
                        respuestaCorrecta, temaId);
                preguntas.add(preguntaAprox);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return preguntas;
    }

    public void eliminar(int id) {
        String query = "DELETE FROM respuestas WHERE id_pregunta = ?; DELETE FROM preguntas WHERE id_pregunta = ?";

        try (Connection connection = Database.getInstance().getConnection();
                PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            statement.setInt(2, id);
            int rowsAffected = statement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Pregunta de aproximación eliminada con éxito.");
            } else {
                System.out.println("Pregunta no encontrada.");
            }
        } catch (SQLException e) {
            System.err.println("Error al eliminar la pregunta de aproximación: " + e.getMessage());
        }
    }

    public void modificar(int id, PreguntaAproximacion nuevaPregunta) {
        String query = "UPDATE preguntas SET pregunta = ?, id_tema = ? WHERE id_pregunta = ?";

        try (Connection connection = Database.getInstance().getConnection();
                PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, nuevaPregunta.getPregunta());
            statement.setInt(2, nuevaPregunta.getIdTema());
            statement.setInt(3, id);

            int rowsAffected = statement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Pregunta de aproximación modificada con éxito.");
            } else {
                System.out.println("Pregunta no encontrada para modificar.");
            }
        } catch (SQLException e) {
            System.err.println("Error al modificar la pregunta de aproximación: " + e.getMessage());
        }
    }

    @Override
    public List<PreguntaAproximacion> buscarObjeto(Object palabra) throws SQLException {
        List<PreguntaAproximacion> preguntasAprox = new ArrayList<>();
        try (Connection conn = Database.getInstance().getConnection()) {
            // columnas guardael nombre de las columnas de la base de datos de nombreTabla
            List<String> columnas = DAO.obtenerNombresColumnas(conn, "preguntas");
            StringBuilder sqlb = new StringBuilder("SELECT * FROM preguntas WHERE ");
            // append para ir agregando mas columnas en el condicional where
            for (int i = 0; i < columnas.size(); i++) {
                sqlb.append(columnas.get(i)).append(" = ?");
                if (i < columnas.size() - 1) {
                    sqlb.append(" OR ");
                }
            }
            String sql = sqlb.toString();
            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                for (int i = 1; i <= columnas.size(); i++) {
                    pstmt.setObject(i, palabra);
                }
                try (ResultSet rs = pstmt.executeQuery()) {
                    while (rs.next()) {
                        PreguntaAproximacion pregAprox = new PreguntaAproximacion(
                                rs.getInt("id_pregunta"),
                                rs.getString("pregunta"),
                                rs.getString("tipoPregunta"),
                                rs.getString("respuesta_correcta"),
                                rs.getInt("tema_id")); // Aquí aseguramos que tema_id sea int
                        preguntasAprox.add(pregAprox);
                    }
                }
            } catch (SQLException e) {
                System.out.println("Error al buscar en la base de datos: " + e.getMessage());
            }
            return preguntasAprox;
        }
    }
}
