package model.ABM;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.PreguntaOpcion;


public class PreguntaOpcionDAO implements DAO<PreguntaOpcion> {

    @Override
    public void insertar(PreguntaOpcion pregunta) {
        String sql = "INSERT INTO preguntas (pregunta, id_tema, id_tipopregunta) VALUES (?, ?, ?)";

        try (Connection connection = Database.getInstance().getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            pstmt.setString(1, pregunta.getPregunta());
            pstmt.setInt(2, pregunta.getIdTema());
            pstmt.setInt(3, 1); // Suponiendo que el id_tipopregunta es 1 para preguntas de opción, ajusta esto según sea necesario

            pstmt.executeUpdate();
            
            
            System.out.println("Pregunta agregada exitosamente.");

        } catch (SQLException e) {
            System.out.println("Error al agregar la pregunta: " + e.getMessage());
        }
    }

    public void insertarRespuestas(int idPregunta, String opcionA, String opcionB, String opcionC, String opcionD, String respuestaCorrecta) {
        String query = "INSERT INTO respuestas (respuesta, id_pregunta, respuesta_correcta) VALUES (?, ?, ?)";
    
        try (Connection connection = Database.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
    
            // Insertar cada opción de respuesta
            insertarOpcion(statement, opcionA, idPregunta, opcionA.equals(respuestaCorrecta));
            insertarOpcion(statement, opcionB, idPregunta, opcionB.equals(respuestaCorrecta));
            insertarOpcion(statement, opcionC, idPregunta, opcionC.equals(respuestaCorrecta));
            insertarOpcion(statement, opcionD, idPregunta, opcionD.equals(respuestaCorrecta));
    
            System.out.println("Opciones de respuesta insertadas correctamente.");
    
        } catch (SQLException e) {
            System.err.println("Error al insertar las respuestas: " + e.getMessage());
        }
    }
    
    // Método auxiliar para insertar una opción de respuesta
    private void insertarOpcion(PreparedStatement statement, String opcion, int idPregunta, boolean esCorrecta) throws SQLException {
        statement.setString(1, opcion);
        statement.setInt(2, idPregunta);
        statement.setBoolean(3, esCorrecta);
        statement.executeUpdate();
    }
    

    @Override
    public List<PreguntaOpcion> buscarTodos() {
        List<PreguntaOpcion> preguntas = new ArrayList<>();
        String query = "SELECT p.id_pregunta, p.pregunta, p.id_tema, r.respuesta, r.respuesta_correcta " +
                       "FROM preguntas p " +
                       "JOIN respuestas r ON p.id_pregunta = r.id_pregunta " +
                       "WHERE p.id_tipopregunta = 1 " +
                       "ORDER BY p.id_pregunta, r.id_respuesta";  // Ordenamos por pregunta y respuesta para agrupar correctamente
        
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
                    new PreguntaOpcion(idPregunta, preguntaTexto, "", "", "", "","", null, idTema));
    
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
    
    
    
    
    
    
    @Override
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
}