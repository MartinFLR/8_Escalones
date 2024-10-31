package model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PreguntasABM implements DAO <Pregunta>{

    // Singleton
    private static PreguntasABM instance;

    public static synchronized PreguntasABM getInstance() {
        if (instance == null) {
            instance = new PreguntasABM();
        }
        return instance;
    }

    public void insertar(Pregunta pregunta) {
        String sql = "INSERT INTO pregunta (pregunta, opcion_a, opcion_b, opcion_c, opcion_d, resp_correcta, id_tema) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (Connection connection = Database.getInstance().getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql)) {

            pstmt.setString(1, pregunta.getPregunta());
            pstmt.setString(2, pregunta.getOpcionA());
            pstmt.setString(3, pregunta.getOpcionB());
            pstmt.setString(4, pregunta.getOpcionC());
            pstmt.setString(5, pregunta.getOpcionD());
            pstmt.setString(6, pregunta.getRespuestaCorrecta());
            pstmt.setInt(7, pregunta.getIdTema());

            pstmt.executeUpdate();
            System.out.println("Pregunta agregada exitosamente.");

        } catch (SQLException e) {
            System.out.println("Error al agregar la pregunta: " + e.getMessage());
        }
    }


    public List<Pregunta> buscarObjeto(Integer numero) {
        List<Pregunta> preguntas = new ArrayList<>();
        String query = "SELECT * FROM pregunta WHERE id_tema=numero";

        try (Connection connection = Database.getInstance().getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                Pregunta pregunta = new Pregunta(
                        resultSet.getInt("id_pregunta"),
                        resultSet.getString("pregunta"),
                        resultSet.getString("opcion_a"),
                        resultSet.getString("opcion_b"),
                        resultSet.getString("opcion_c"),
                        resultSet.getString("opcion_d"),
                        resultSet.getString("resp_correcta"),
                        resultSet.getInt("id_tema")
                );
                preguntas.add(pregunta);
            }
        } catch (SQLException e) {
            System.err.println("Error al listar las preguntas: " + e.getMessage());
        }
        return preguntas;
    }

    // Método para listar todas las preguntas de la base de datos// falta buscar por id_tema
    public List<Pregunta> buscarTodos() {
        List<Pregunta> preguntas = new ArrayList<>();
        String query = "SELECT * FROM pregunta";

        try (Connection connection = Database.getInstance().getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                Pregunta pregunta = new Pregunta(
                        resultSet.getInt("id_pregunta"),
                        resultSet.getString("pregunta"),
                        resultSet.getString("opcion_a"),
                        resultSet.getString("opcion_b"),
                        resultSet.getString("opcion_c"),
                        resultSet.getString("opcion_d"),
                        resultSet.getString("resp_correcta"),
                        resultSet.getInt("id_tema")
                );
                preguntas.add(pregunta);
            }
        } catch (SQLException e) {
            System.err.println("Error al listar las preguntas: " + e.getMessage());
        }
        return preguntas;
    }

    public void eliminar(int id) {
        String query = "DELETE FROM pregunta WHERE id_pregunta = ?";

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

    
    
    public void modificar(int id, Pregunta nuevaPregunta) {
        String query = "UPDATE pregunta SET pregunta = ?, opcion_a = ?, opcion_b = ?, opcion_c = ?, opcion_d = ?, resp_correcta = ?, id_tema = ? WHERE id_pregunta = ?";

        try (Connection connection = Database.getInstance().getConnection(); // Usa el método de la clase Database
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, nuevaPregunta.getPregunta());
            statement.setString(2, nuevaPregunta.getOpcionA());
            statement.setString(3, nuevaPregunta.getOpcionB());
            statement.setString(4, nuevaPregunta.getOpcionC());
            statement.setString(5, nuevaPregunta.getOpcionD());
            statement.setString(6, nuevaPregunta.getRespuestaCorrecta());
            statement.setInt(7, nuevaPregunta.getIdTema());
            statement.setInt(8, id); // Establece el ID de la pregunta a modificar

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
