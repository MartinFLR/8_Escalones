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

    private static PreguntaOpcionDAO instance;

    public static synchronized PreguntaOpcionDAO getInstance() {
        if (instance == null) {
            instance = new PreguntaOpcionDAO();
        }
        return instance;
    }

    @Override
    public void insertar(PreguntaOpcion pregunta) {
        String sql = "INSERT INTO preguntas (pregunta, id_tema, id_tipopregunta) VALUES (?, ?, ?)";

        try (Connection connection = Database.getInstance().getConnection();
                PreparedStatement pstmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            pstmt.setString(1, pregunta.getPregunta());
            pstmt.setInt(2, pregunta.getIdTema());
            pstmt.setInt(3, 1); // Suponiendo que el id_tipopregunta es 1 para preguntas de opción, ajusta esto
                                // según sea necesario

            pstmt.executeUpdate();
            
            
            System.out.println("Pregunta agregada exitosamente.");

        } catch (SQLException e) {
            System.out.println("Error al agregar la pregunta: " + e.getMessage());
        }
    }

    private void insertarOpciones(int idPregunta, PreguntaOpcion pregunta) {
        String sql = "INSERT INTO respuestas (id_pregunta, respuesta, respuesta_correcta) VALUES (?, ?, ?)";

        try (Connection connection = Database.getInstance().getConnection();
                PreparedStatement pstmt = connection.prepareStatement(sql)) {

            pstmt.setInt(1, idPregunta);
            pstmt.setString(2, pregunta.getOpcionA());
            pstmt.setBoolean(3, pregunta.getRespuestaCorrecta().equals(pregunta.getOpcionA())); // Ajusta esto según sea
                                                                                                // necesario

            pstmt.executeUpdate();
            // Repite para las otras opciones B, C y D
            // Aquí también puedes marcar la respuesta correcta, dependiendo de cómo quieras
            // almacenar esta información.
        } catch (SQLException e) {
            System.err.println("Error al insertar las respuestas: " + e.getMessage());
        }
    }

    @Override
    public List<PreguntaOpcion> buscarTodos() {
        List<PreguntaOpcion> preguntas = new ArrayList<>();
        String query = "SELECT p.id_pregunta, p.pregunta, p.id_tema, r.respuesta, r.respuesta_correcta " +
                "FROM preguntas p " +
                "LEFT JOIN respuestas r ON p.id_pregunta = r.id_pregunta " +
                "WHERE p.id_tipopregunta = 1";

        try (Connection connection = Database.getInstance().getConnection();
                PreparedStatement pstmt = connection.prepareStatement(query);
                ResultSet resultSet = pstmt.executeQuery()) {

            Map<Integer, PreguntaOpcion> preguntaMap = new HashMap<>();

            while (resultSet.next()) {
                int idPregunta = resultSet.getInt("id_pregunta");
                String preguntaTexto = resultSet.getString("pregunta");
                int idTema = resultSet.getInt("id_tema");

                // Crear o recuperar la pregunta del mapa
                PreguntaOpcion pregunta = preguntaMap.getOrDefault(idPregunta,
                        new PreguntaOpcion(idPregunta, preguntaTexto, "", "", "", "", "", idTema));

                // Obtener la respuesta y ver si es la correcta
                String respuesta = resultSet.getString("respuesta");
                boolean respuestaCorrecta = resultSet.getBoolean("respuesta_correcta");

                // Si la respuesta es correcta, la agregamos a la pregunta
                if (respuestaCorrecta) {
                    // Almacenamos la respuesta correcta en la pregunta
                    pregunta.setRespuestaCorrecta(respuesta); // Implementa este método en la clase PreguntaOpcion
                }

                // Almacenar la pregunta en el mapa
                preguntaMap.put(idPregunta, pregunta);
            }

            // Agregar todas las preguntas al listado
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