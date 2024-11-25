package model.ABM;

import model.PreguntaOpcion;
import model.Respuesta;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



public class PreguntaOpcionDAO implements DAOPreguntas<PreguntaOpcion> {

    public void insertar(PreguntaOpcion nuevaPregunta, List<Respuesta> respuestas) {
        String queryPregunta = "INSERT INTO preguntas (pregunta, id_tipopregunta, id_tema) "
                + "VALUES (?, ?, ?)";

        String queryRespuesta = "INSERT INTO respuestas (id_pregunta, respuesta, respuesta_correcta) "
                + "VALUES (?, ?, ?)";

        try (Connection connection = Database.getInstance().getConnection();
             PreparedStatement stmtPregunta = connection.prepareStatement(queryPregunta, Statement.RETURN_GENERATED_KEYS);
             PreparedStatement stmtRespuesta = connection.prepareStatement(queryRespuesta)) {

            connection.setAutoCommit(false);

            stmtPregunta.setString(1, nuevaPregunta.getPregunta());
            stmtPregunta.setInt(2, 1);  //
            stmtPregunta.setInt(3, nuevaPregunta.getIdTema());  //
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

    public List<PreguntaOpcion> buscarTodos() {
        List<PreguntaOpcion> preguntas = new ArrayList<>();
        String query = """
                SELECT *
                FROM (
                    SELECT DISTINCT p.id_pregunta, p.pregunta, p.id_tema, r.respuesta, r.respuesta_correcta
                    FROM preguntas p
                    JOIN respuestas r ON p.id_pregunta = r.id_pregunta
                    WHERE p.id_tipopregunta = 1
                ) subquery
                ORDER BY subquery.id_pregunta, subquery.respuesta;
                """;
        
        try (Connection connection = Database.getInstance().getConnection();
                PreparedStatement pstmt = connection.prepareStatement(query);
                ResultSet resultSet = pstmt.executeQuery()) {

            Map<Integer, PreguntaOpcion> preguntaMap = new HashMap<>();

            while (resultSet.next()) {
                int idPregunta = resultSet.getInt("id_pregunta");
                String preguntaTexto = resultSet.getString("pregunta");
                int idTema = resultSet.getInt("id_tema");
                String respuesta = resultSet.getString("respuesta");
                boolean esCorrecta = resultSet.getBoolean("respuesta_correcta");


                PreguntaOpcion pregunta = preguntaMap.getOrDefault(idPregunta, 
                    new PreguntaOpcion(idPregunta, preguntaTexto, "", "", "","", null, idTema));

                if (pregunta.getOpcionA().isEmpty()) {
                    pregunta.setOpcionA(respuesta);
                } else if (pregunta.getOpcionB().isEmpty()) {
                    pregunta.setOpcionB(respuesta);
                } else if (pregunta.getOpcionC().isEmpty()) {
                    pregunta.setOpcionC(respuesta);
                } else if (pregunta.getOpcionD().isEmpty()) {
                    pregunta.setOpcionD(respuesta);
                }

                if (esCorrecta) {
                    pregunta.setRespuestaCorrecta(respuesta);
                }

                preguntaMap.put(idPregunta, pregunta);
            }

            preguntas.addAll(preguntaMap.values());

        } catch (SQLException e) {
            System.err.println("Error al listar las preguntas: " + e.getMessage());
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

    //aca nuevaPregunta deberia tener ya el arreglo de respuestas usando el constructor con arraylist de respuestas
    public void modificar(int id,PreguntaOpcion entidad, List<Respuesta> respuestas) {
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
            stmtPregunta.setInt(3, 1);
            stmtPregunta.setInt(4, id);
            stmtPregunta.executeUpdate();

            stmtDeleteRespuestas.setInt(1, id);
            stmtDeleteRespuestas.executeUpdate();

            for (Respuesta respuesta : respuestas) {
                stmtInsertRespuesta.setInt(1, id);
                stmtInsertRespuesta.setString(2, respuesta.getRespuesta());
                stmtInsertRespuesta.setBoolean(3, respuesta.isRespuestaCorrecta());
                stmtInsertRespuesta.addBatch();
            }
            stmtInsertRespuesta.executeBatch();

            connection.commit();

            System.out.println("Pregunta y respuestas actualizadas exitosamente.");
        } catch (SQLException e) {
            try (Connection connection = Database.getInstance().getConnection()) {
                connection.rollback();
            } catch (SQLException ex) {
                System.out.println("Error al revertir la transacción: " + ex.getMessage());
            }
            System.out.println("Error al modificar la pregunta: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    @Override
    public List<PreguntaOpcion> busqueda(String palabra, int id_tema) {
        List<PreguntaOpcion> palabras = new ArrayList<>();
        //aca basicamente digo que no importa si tiene acento
        String sql = "SELECT id_pregunta, pregunta, id_tema FROM preguntas "+
                "WHERE TRANSLATE(LOWER(pregunta), 'áéíóúÁÉÍÓÚñÑ', 'aeiouAEIOUnN') "+"" +
                "LIKE TRANSLATE(LOWER(?), 'áéíóúÁÉÍÓÚñÑ', 'aeiouAEIOUnN') AND id_tema = ?";

        try (Connection conn = Database.getInstance().getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // Verifica si la palabra no es nula
            if (palabra == null) {
                palabra = "";
            }
            pstmt.setString(1, "%" + palabra + "%");
            pstmt.setInt(2, id_tema);

            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    palabras.add(new PreguntaOpcion(
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
