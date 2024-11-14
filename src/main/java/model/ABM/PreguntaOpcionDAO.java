package model.ABM;

import model.PreguntaAproximacion;
import model.PreguntaOpcion;
import model.Respuesta;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

<<<<<<< HEAD
public class PreguntaOpcionDAO extends PreguntasDAO {
=======


public class PreguntaOpcionDAO implements DAO<PreguntaOpcion> {
>>>>>>> 4139275b255ea57a5f455b048fca28030fbb90f2

    public void insertar(PreguntaOpcion entidad) {
        String sql = "INSERT INTO preguntas (pregunta, id_tema, id_tipopregunta) VALUES (?, ?, ?)";

        try (Connection connection = Database.getInstance().getConnection();
                PreparedStatement pstmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            pstmt.setString(1, entidad.getPregunta());
            pstmt.setInt(2, entidad.getIdTema());
            pstmt.setInt(3, 1); // Suponiendo que el id_tipopregunta es 1 para preguntas de opción, ajusta esto
                                // según sea necesario

            pstmt.executeUpdate();

            System.out.println("Pregunta agregada exitosamente.");

        } catch (SQLException e) {
            System.out.println("Error al agregar la pregunta: " + e.getMessage());
        }
    }

<<<<<<< HEAD
    protected Boolean preguntaYaTieneOpciones(Preguntas pregunta) {
        int cantidad_opciones = 0;
        String query = " SELECT COUNT(id_respuesta) as Opciones FROM respuestas r JOIN preguntas p ON r.id_respuesta=p.id_respuesta WHERE p.id_pregunta = ?";
        try (Connection conn = Database.getInstance().getConnection();
                PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, pregunta.getId_pregunta());
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    cantidad_opciones = rs.getInt("Opciones");
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        if (cantidad_opciones >= 4) {
            return true;
        } else {
            return false;
        }
    }

    public void crearRespuesta(String respuesta, Boolean vf, PreguntaOpcion pregunta) {
        String query = "INSERT INTO respuestas (respuesta, id_pregunta, respuesta_correcta) VALUES (?, ?, ?)";

        try (Connection connection = Database.getInstance().getConnection();
                PreparedStatement pstmt = connection.prepareStatement(query)) {
            if (!preguntaYaTieneOpciones(pregunta)) {
                pstmt.setString(1, respuesta);
                pstmt.setInt(2, pregunta.getId_pregunta());
                pstmt.setBoolean(3, vf);

                int rowsAffected = pstmt.executeUpdate();

                if (rowsAffected > 0) {
                    System.out.println("Respuesta creada exitosamente.");
                } else {
                    System.out.println("No se pudo crear la respuesta.");
                }
            }else{
                System.out.println("La pregunta: " + pregunta.getPregunta() + " ya tiene las opciones llenas, pruebe a modificarlas");
            }

=======
    public void crearPregunta(PreguntaOpcion nuevaPregunta, List<Respuesta> respuestas) {
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
            stmtPregunta.setInt(2, 1);  // id_tipopregunta debe ser válido
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
>>>>>>> 4139275b255ea57a5f455b048fca28030fbb90f2
        } catch (SQLException e) {
            e.printStackTrace();

        }

    }

    public List<PreguntaOpcion> buscarTodos() {
        List<PreguntaOpcion> preguntas = new ArrayList<>();
<<<<<<< HEAD
        String query = "SELECT p.id_pregunta, p.pregunta, p.id_tema, r.respuesta, r.respuesta_correcta " +
                "FROM preguntas p " +
                "JOIN respuestas r ON p.id_pregunta = r.id_pregunta " +
                "WHERE p.id_tipopregunta = 1 " +
                "ORDER BY p.id_pregunta, r.id_respuesta"; // Ordenamos por pregunta y respuesta para agrupar
                                                          // correctamente

=======
        String query = """
                SELECT *
                FROM (
                    SELECT DISTINCT p.id_pregunta, p.pregunta, p.id_tema, r.respuesta, r.respuesta_correcta
                    FROM preguntas p
                    JOIN respuestas r ON p.id_pregunta = r.id_pregunta
                    WHERE p.id_tipopregunta = 1
                ) subquery
                ORDER BY subquery.id_pregunta, subquery.respuesta;
                """; // Ordenamos por pregunta y respuesta para agrupar correctamente
        
>>>>>>> 4139275b255ea57a5f455b048fca28030fbb90f2
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

                // Obtener o crear la pregunta en el mapa
<<<<<<< HEAD
                PreguntaOpcion pregunta = preguntaMap.getOrDefault(idPregunta,
                        new PreguntaOpcion(idPregunta, preguntaTexto, "", "", "", "", "", null, idTema));

=======
                PreguntaOpcion pregunta = preguntaMap.getOrDefault(idPregunta, 
                    new PreguntaOpcion(idPregunta, preguntaTexto, "", "", "","", null, idTema));
    
>>>>>>> 4139275b255ea57a5f455b048fca28030fbb90f2
                // Asignar cada respuesta a una de las opciones A, B, C o D
                if (pregunta.getOpcionA().isEmpty()) {
                    pregunta.setOpcionA(respuesta);
                } else if (pregunta.getOpcionB().isEmpty()) {
                    pregunta.setOpcionB(respuesta);
                } else if (pregunta.getOpcionC().isEmpty()) {
                    pregunta.setOpcionC(respuesta);
                } else if (pregunta.getOpcionD().isEmpty()) {
                    pregunta.setOpcionD(respuesta);
                }

                // Si es la respuesta correcta, almacenarla
                if (esCorrecta) {
                    pregunta.setRespuestaCorrecta(respuesta);
                }

                // Guardar o actualizar en el mapa
                preguntaMap.put(idPregunta, pregunta);
            }

            // Convertir el mapa en una lista
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

    public void modificar(int id, PreguntaOpcion nuevaPregunta) {
        String query = "UPDATE preguntas SET pregunta = ?, id_tema = ? WHERE id_pregunta = ?";

        try (Connection connection = Database.getInstance().getConnection();
                PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, nuevaPregunta.getPregunta());
            statement.setInt(2, nuevaPregunta.getIdTema());
            statement.setInt(3, id);

            int rowsAffected = statement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Pregunta modificada con éxito.");
            } else {
                System.out.println("Pregunta no encontrada para modificar.");
            }
        } catch (SQLException e) {
            System.err.println("Error al modificar la pregunta: " + e.getMessage());
        }
    }

<<<<<<< HEAD
    public static void crearPregunta(String pregunta, int idTema, int idTipoPregunta) {
        String query = "INSERT INTO preguntas (pregunta, id_tema, id_tipopregunta) VALUES (?, ?, ?)";

        try (Connection connection = Database.getInstance().getConnection();
                PreparedStatement pstmt = connection.prepareStatement(query)) {

            pstmt.setString(1, pregunta);
            pstmt.setInt(2, idTema);
            pstmt.setInt(3, idTipoPregunta);

            int rowsAffected = pstmt.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Pregunta creada exitosamente.");
            } else {
                System.out.println("No se pudo crear la pregunta.");
            }

        } catch (SQLException e) {
            System.err.println("Error al crear la pregunta: " + e.getMessage());
        }
    }

=======
//    public static void crearPregunta(String pregunta, int idTema, int idTipoPregunta) {
//        String query = "INSERT INTO preguntas (pregunta, id_tema, id_tipopregunta) VALUES (?, ?, ?)";
//
//        try (Connection connection = Database.getInstance().getConnection();
//             PreparedStatement pstmt = connection.prepareStatement(query)) {
//
//            pstmt.setString(1, pregunta);
//            pstmt.setInt(2, idTema);
//            pstmt.setInt(3, idTipoPregunta);
//
//            int rowsAffected = pstmt.executeUpdate();
//
//            if (rowsAffected > 0) {
//                System.out.println("Pregunta creada exitosamente.");
//            } else {
//                System.out.println("No se pudo crear la pregunta.");
//            }
//
//        } catch (SQLException e) {
//            System.err.println("Error al crear la pregunta: " + e.getMessage());
//        }
//    }
>>>>>>> 4139275b255ea57a5f455b048fca28030fbb90f2
}