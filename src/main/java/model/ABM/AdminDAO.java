package model.ABM;

import model.logica.Admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AdminDAO {

    public void modificar(Admin admin){
        String sql = "UPDATE admin SET usuario = ? , contrasenia = ? WHERE id = ?";
        try (Connection conn = Database.getInstance().getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)){
            pstmt.setString(1,admin.getNombre());
            pstmt.setString(2, admin.getContrasenia());
            pstmt.setInt(3, 1);
            int filasActualizadas = pstmt.executeUpdate();
            if (filasActualizadas > 0) {
                System.out.println("Admin modificado con éxito.");
            } else {
                System.out.println("No se encontró el Admin con ID: " );
            }

        } catch (SQLException e) {
            System.err.println("Error al modificar Admin: " + e.getMessage());
        }
    }
}
