package model.ABM;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Participante;

public class ParticipantesDAO implements DAO <Participante>{
    
    private static ParticipantesDAO instance;

    public static synchronized ParticipantesDAO getInstance() {
        if (instance == null) {
            instance = new ParticipantesDAO();
        }
        return instance;
    }
    @Override
    public void insertar(Participante participante) {
        String sql = "INSERT INTO participantes (nombre, edad) VALUES (?, ?)";
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
                int edad = resultSet.getInt("edad");
                participantes.add(new Participante(id, nombre, edad));
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
        String sql = "UPDATE participantes SET nombre = ?, edad = ? WHERE id = ?";
        try (Connection conn = Database.getInstance().getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, nuevoParticipante.getNombre());
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
    @Override
    public List<Participante> buscarObjeto(Object palabra) throws SQLException {
        List<Participante> participantes = new ArrayList<>();
        try (Connection conn = Database.getInstance().getConnection()){
            //columnas guardael nombre de las columnas de la base de datos de nombreTabla
            List<String> columnas = DAO.obtenerNombresColumnas(conn, "participantes");
            StringBuilder sqlb = new StringBuilder("SELECT * FROM participantes WHERE ");
            //append para ir agregando mas columnas en el condicional where
            for (int i = 0; i < columnas.size(); i++) {
                sqlb.append(columnas.get(i)).append(" = ?");
                if (i < columnas.size() - 1) {
                    sqlb.append(" OR ");
                }
            }
            String sql = sqlb.toString();
            try(PreparedStatement pstmt = conn.prepareStatement(sql)){
                for (int i = 1; i <= columnas.size(); i++) {
                    pstmt.setObject(i,  palabra );
                }
                try(ResultSet rs = pstmt.executeQuery()){
                    while (rs.next()) {
                    Participante participante = new Participante(
                    rs.getInt("id"),
                    rs.getString("nombre"),
                    rs.getInt("edad"));
                    participantes.add(participante);
                }  
            }
        } catch (SQLException e) {
            System.out.println("Error al buscar en la base de datos: " + e.getMessage());
        }
        return participantes;
    }
}
}
