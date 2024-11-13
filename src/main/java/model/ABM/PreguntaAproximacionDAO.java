package model.ABM;

import model.PreguntaAproximacion;
import model.Preguntas;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PreguntaAproximacionDAO extends PreguntasDAO {


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
                generatedKeys.getInt(1);
                // Aquí puedes guardar la respuesta correcta en la tabla de respuestas
                insertarRespuesta(pregunta);
            }
            System.out.println("Pregunta de aproximación agregada exitosamente.");

        } catch (SQLException e) {
            System.out.println("Error al agregar la pregunta de aproximación: " + e.getMessage());
        }
    }

    //verifica si la pregunta ya tiene respuesta
    protected Boolean preguntaYaTieneOpciones(Preguntas pregunta){
        Boolean lleno = false;
        String sql = "SELECT respuesta_correcta FROM respuestas r JOIN preguntas p ON r.id_pregunta=p.id_pregunta WHERE p.id_pregunta= ?";
        try(Connection conn = Database.getInstance().getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)){
                pstmt.setInt(1, pregunta.getId_pregunta());
                try(ResultSet rs = pstmt.executeQuery()){
                    if(rs.next()){
                        lleno = true;
                    }
                }
            } catch (SQLException e) {
               System.out.println(e.getMessage());
             }
             return lleno;
    }

    private void modificarRespuesta(PreguntaAproximacion pregunta){
        String sql = "UPDATE respuestas SET respuesta_correcta = ? WHERE preguntas.id_pregunta = ?";
        try (Connection conn = Database.getInstance().getConnection();
        PreparedStatement pstmt = conn.prepareStatement(sql)){
            pstmt.setString(1, pregunta.getRespuestaCorrecta());
            pstmt.setInt(2, pregunta.getId_pregunta());
            try(ResultSet rs = pstmt.executeQuery()){
                if(rs.rowUpdated()){
                    System.out.println("Respuesta modificada");
                }else{
                    System.out.println("No se pudo modificar la respuesta");
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    private void insertarRespuesta(PreguntaAproximacion pregunta) {
        String sql = "INSERT INTO respuestas (id_pregunta, respuesta_correcta) VALUES ( ?)";
        
        try (Connection connection = Database.getInstance().getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql)) {
                if(!preguntaYaTieneOpciones(pregunta)){
                    pstmt.setInt(1,pregunta.getId_pregunta());
                    pstmt.setString(2, pregunta.getRespuestaCorrecta());
                } else{
                    System.out.println("Pregunta " + pregunta.getPregunta() + " ya tiene respuesta, pruebe a modificarla");
                }

            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error al agregar la respuesta: " + e.getMessage());
        }
    }

    public List buscarTodos() {
        List<PreguntaAproximacion> preguntas = new ArrayList<>();
        String query = "SELECT p.id_pregunta, p.pregunta,tp.tipo_pregunta AS tipoPregunta, r.respuesta AS respuesta_correcta, t.id_tema AS tema_id "
                     + "FROM preguntas p "
                     + "JOIN tipo_pregunta as tp ON tp.id_tipo = p.id_tipopregunta "
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
                int temaId = rs.getInt("tema_id");  // Aquí aseguramos que tema_id sea int
    
                PreguntaAproximacion preguntaAprox = new PreguntaAproximacion(idPregunta, pregunta,tipoPregunta, respuestaCorrecta, temaId);
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
    
    //si se modifica la pregunta por ley deben modificarse las respuesta(depende si cambia el contexto)
    public void modificar(int id, PreguntaAproximacion nuevaPregunta) {
        String query = "UPDATE preguntas SET pregunta = ?, id_tema = ? WHERE id_pregunta = ?";

        try (Connection connection = Database.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, nuevaPregunta.getPregunta());
            statement.setInt(2, nuevaPregunta.getIdTema());
            statement.setInt(3, id);
            modificarRespuesta(nuevaPregunta);
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
}

