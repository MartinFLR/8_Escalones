package model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ParticipantesABM {
    private static ParticipantesABM instance;

    public static synchronized ParticipantesABM getInstance() {
        if (instance == null) {
            instance = new ParticipantesABM();
        }
        return instance;
    }

    public void agregarParticipante(Participante participante) {
        String sql = "INSERT INTO participantes (nombre, edad) VALUES (?, ?)";
        try (Connection conn = Database.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, participante.getNombre());
            pstmt.setInt(2, participante.getEdad());
            pstmt.executeUpdate();
            System.out.println("Participante agregado con éxito.");
        } catch (SQLException e) {
            System.err.println("Error al agregar participante: " + e.getMessage());
        }
    }

    public List<Participante> listarParticipantes() {
        List<Participante> participantes = new ArrayList<>();
        String sql = "SELECT * FROM participantes";
        try (Connection conn = Database.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                int id = rs.getInt("id"); // Obtener el id
                String nombre = rs.getString("nombre");
                int edad = rs.getInt("edad");
                participantes.add(new Participante(id, nombre, edad)); // Asegúrate de que el constructor acepte id
            }
        } catch (SQLException e) {
            System.err.println("Error al listar participantes: " + e.getMessage());
        }
        return participantes;
    }

    public void eliminarParticipante(int id) {
        String sql = "DELETE FROM participantes WHERE id = ?";
        try (Connection conn = Database.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);
            int filasEliminadas = pstmt.executeUpdate();
            if (filasEliminadas > 0) {
                System.out.println("Participante eliminado con éxito.");
            } else {
                System.out.println("No se encontró el participante con ID: " + id);
            }
        } catch (SQLException e) {
            System.err.println("Error al eliminar participante: " + e.getMessage());
        }
    }

    public void modificarParticipante(int id, Participante nuevoParticipante) {
        String sql = "UPDATE participantes SET nombre = ?, edad = ? WHERE id = ?";
        try (Connection conn = Database.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, nuevoParticipante.getNombre());
            pstmt.setInt(2, nuevoParticipante.getEdad());
            pstmt.setInt(3, id);
            int filasActualizadas = pstmt.executeUpdate();
            if (filasActualizadas > 0) {
                System.out.println("Participante modificado con éxito.");
            } else {
                System.out.println("No se encontró el participante con ID: " + id);
            }
        } catch (SQLException e) {
            System.err.println("Error al modificar participante: " + e.getMessage());
        }
    }
}
