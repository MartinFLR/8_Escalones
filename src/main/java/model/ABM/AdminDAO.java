package model.ABM;

import model.Admin;
import java.sql.*;


public class AdminDAO {

    public void modificar(Admin admin) {
        String sql = "UPDATE admin SET usuario = ? , contrasenia = ? WHERE id = ?";
        try (Connection conn = Database.getInstance().getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, admin.getNombre());
            pstmt.setString(2, admin.getContrasenia());
            pstmt.setInt(3, 1);
            int filasActualizadas = pstmt.executeUpdate();
            if (filasActualizadas > 0) {
                System.out.println("Admin modificado con éxito.");
            } else {
                System.out.println("No se encontró el Admin con ID: ");
            }

        } catch (SQLException e) {
            System.err.println("Error al modificar Admin: " + e.getMessage());
        }
    }

    public Admin buscarAdmin() {
        String query = "SELECT * from admin";
        Admin admin1 = null;
        try (Connection connection = Database.getInstance().getConnection();
             Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            if (rs.next()) {
                String usuario = rs.getString("usuario");
                String contrasenia = rs.getString("contrasenia");

                admin1 = new Admin(usuario, contrasenia);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return admin1;
    }

    public boolean Login(String cuenta, String contrasenia) {
        boolean loginValido = false;
        String query = "SELECT * FROM admin WHERE usuario = ? AND contrasenia = ?";
        
        try (Connection conn = Database.getInstance().getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
             
            stmt.setString(1, cuenta);
            stmt.setString(2, contrasenia);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    loginValido = true;
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return loginValido;
    }

}
