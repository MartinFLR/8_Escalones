package model.ABM;

import model.PreguntaAproximacion;
import model.PreguntaOpcion;
import model.Respuesta;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



public class PreguntaOpcionDAO implements DAO<PreguntaOpcion> {

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

    @Override
    public void modificar(int id, PreguntaOpcion entidad) {

    }

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
                """; // Ordenamos por pregunta y respuesta para agrupar correctamente
        
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
                PreguntaOpcion pregunta = preguntaMap.getOrDefault(idPregunta, 
                    new PreguntaOpcion(idPregunta, preguntaTexto, "", "", "","", null, idTema));
    
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


    //busca respuestas para el id_pregunta, se usa para modificar las respuestas de id_pregunta
    private List<Integer> buscaIdRespuestas(int id_pregunta){

        List<Integer> respuestas = new ArrayList<>();
        String sql = "SELECT r.id_respuesta FROM respuestas r JOIN preguntas p ON p.id_pregunta=r.id_pregunta WHERE p.id_pregunta = ? ";
        try(Connection conn = Database.getInstance().getConnection();
        PreparedStatement pstmt = conn.prepareStatement(sql)){
            pstmt.setInt(1, id_pregunta);
            try(ResultSet rs = pstmt.executeQuery()){
                while(rs.next()){
                    respuestas.add(rs.getInt("id_respuesta"));
                }
            }
        } catch (SQLException e) {
            System.out.println("No se pudo encontrar respuestas para id_pregunta: " + id_pregunta + e.getMessage() );
        }
        return respuestas;

    }

//    //aca Respuesta(objeto) se utiliza el constructor sin id_respuesta, que contiene la respuesta y si es correcta
//    private void modificarOpciones(int id_respuesta, Respuesta nuevaRespuesta, int idpregunta){
//        String sql = "UPDATE respuestas SET respuesta = ?, respuesta_correcta = ? WHERE id_respuesta = ? AND id_pregunta = ? ";
//        try(Connection conn = Database.getInstance().getConnection();
//        PreparedStatement pstmt = conn.prepareStatement(sql)){
//            pstmt.setString(1, nuevaRespuesta.getRespuesta());
//            pstmt.setBoolean(2, nuevaRespuesta.isRespuestaCorrecta());
//            pstmt.setInt(3, id_respuesta);
//            pstmt.setInt(4, idpregunta);
//
//            int rowsAffected = pstmt.executeUpdate();
//            if(rowsAffected>0){
//                System.out.println("Se modificaron las respuestas de id_pregunta: " + idpregunta + " con exito" );
//            } else{
//                System.out.println("No se modificaron respuestas para id_pregunta: " + idpregunta);
//            }
//        } catch (SQLException e) {
//            System.out.println("Error al intentar modificar respuestas de id_pregunta: " + idpregunta + e.getMessage());
//        }
//    }

    //aca nuevaPregunta deberia tener ya el arreglo de respuestas usando el constructor con arraylist de respuestas
    public void modificarPregunta(int id,PreguntaOpcion entidad, List<Respuesta> respuestas) {
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


}