package model.ABM;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Participante;

public class ParticipantesDAO implements DAO<Participante> {

    @Override
    public void insertar(Participante participante) {
        String sql = "INSERT INTO participantes (nombre, veces_ganadas) VALUES (?, 0)";
        try (Connection conn = Database.getInstance().getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, participante.getNombre());

            pstmt.executeUpdate();
            System.out.println("Participante agregado con éxito.");
        } catch (SQLException e) {
            System.err.println("Error al agregar participante: " + e.getMessage());
        }
    }

    @Override
    public List<Participante> buscarTodos() {
        List<Participante> participantes = new ArrayList<>();
        String sql = "SELECT * FROM participantes";
        try (Connection conn = Database.getInstance().getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql);
                ResultSet resultSet = pstmt.executeQuery()) {
            while (resultSet.next()) {
                int id = resultSet.getInt("id"); // Obtener el id
                String nombre = resultSet.getString("nombre");
                int veces_ganadas = resultSet.getInt("veces_ganadas");
                participantes.add(new Participante(id, nombre, veces_ganadas));
            }
        } catch (SQLException e) {
            System.err.println("Error al listar participantes: " + e.getMessage());
        }
        return participantes;
    }

    @Override
    public void eliminar(int id) {
        String sql = "DELETE FROM participantes WHERE id = ?";
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

    @Override
    public void modificar(int id, Participante nuevoParticipante) {
        String sql = "UPDATE participantes SET nombre = ? WHERE id = ?";
        try (Connection conn = Database.getInstance().getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, nuevoParticipante.getNombre());
            pstmt.setInt(2, id);

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

    public void modificarVecesGanadas(String nombreParticipante, Integer cantidad) {

        String sql = "UPDATE participantes SET veces_ganadas = veces_ganadas + ? WHERE nombre = ? ";
        try (Connection conn = Database.getInstance().getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, cantidad);
            pstmt.setString(2, nombreParticipante);

            pstmt.executeUpdate();
            System.out.println("Veces ganadas modificada con exito");
        } catch (SQLException e) {
            System.err.println("Error al modificar veces ganadas: " + e.getMessage());
        }
    }

    public static List<Participante> Ranking(){
        List<Participante> top10participantes = new ArrayList<>();
        String sql = "SELECT p.nombre, p.veces_ganadas FROM participantes p GROUP BY p.nombre, p.veces_ganadas ORDER BY p.veces_ganadas DESC LIMIT 10;";
        {
        try (Connection conn = Database.getInstance().getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery()){

            while(rs.next()){
                top10participantes.add(new Participante(rs.getString("nombre"), rs.getInt("veces_ganadas")));
            }
            
        } catch (SQLException e) {
           System.out.println("Error al formar ranking: " + e.getMessage());
        }

    }
    return top10participantes;
    }

}
