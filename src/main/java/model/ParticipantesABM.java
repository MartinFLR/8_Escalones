package model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ParticipantesABM implements DAO<Participante> {
    private static ParticipantesABM instance;

    public static synchronized ParticipantesABM getInstance() {
        if (instance == null) {
            instance = new ParticipantesABM();
        }
        return instance;
    }

    //-----------------------------------------------------------------------------------------

    public void insertar(Participante participante) {
        String sql = "INSERT INTO participante (nombre_participante, edad_participante) VALUES (?, ?)";
        try (Connection conn = Database.getInstance().getConnection();

                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, participante.getNombre());
            pstmt.setInt(2, participante.getEdad());
            pstmt.executeUpdate();
            System.out.println("Participante agregado con éxito.");
        } catch (SQLException e) {
            System.err.println("Error al agregar participante: " + e.getMessage());
        }
    }

     //-----------------------------------------------------------------------------------------

    public List<Participante> buscarObjeto(String nombreColumna, Object tipo) {

        List<Participante> participantes = new ArrayList<>();
        String sql = DAO.setQuery(nombreColumna, tipo);

        try (Connection conn = Database.getInstance().getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            if (tipo instanceof String) {
                pstmt.setString(1, "%" +  tipo + "%");
            } else if (tipo instanceof Integer) {
                pstmt.setInt(1, (Integer) tipo);
            } else {
                throw new IllegalArgumentException("Tipo de dato no soportado: " + tipo.getClass());
            }

            System.out.println("Consulta ejecutada: " + sql);
            try (ResultSet resultSet = pstmt.executeQuery()) {

                while (resultSet.next()) {
                    int id = resultSet.getInt("id_participante"); // Obtener el id
                    String nombre = resultSet.getString("nombre_participante");
                    int edad = resultSet.getInt("edad_participante");
                    participantes.add(new Participante(id, nombre, edad));
                }
            }

        } catch (SQLException e) {
            System.err.println("Error al listar participantes: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        return participantes;
    }

    //-----------------------------------------------------------------------------------------

    public List<Participante> buscarTodos() {

        List<Participante> participantes = new ArrayList<>();
        String sql = "SELECT * FROM participante";

        try (Connection conn = Database.getInstance().getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql);
                ResultSet resultSet = pstmt.executeQuery()) {

            while (resultSet.next()) {
                int id = resultSet.getInt("id_participante"); // Obtener el id
                String nombre = resultSet.getString("nombre_participante");
                int edad = resultSet.getInt("edad_participante");
                participantes.add(new Participante(id, nombre, edad));
            }

        } catch (SQLException e) {
            System.err.println("Error al listar participantes: " + e.getMessage());
        }

        return participantes;

    }

    //-----------------------------------------------------------------------------------------

    public void eliminar(int id) {

        String sql = "DELETE FROM participante WHERE id_participante = ?";

        try (Connection conn = Database.getInstance().getConnection();
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

    //-----------------------------------------------------------------------------------------

    public void modificar(int id, Participante nuevoParticipante) {

        String sql = "UPDATE participante SET nombre_participante = ?, edad_participante = ? WHERE id_participante = ?";

        try (Connection conn = Database.getInstance().getConnection();
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
