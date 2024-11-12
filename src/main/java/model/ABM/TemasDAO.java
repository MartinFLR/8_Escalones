package model.ABM;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import model.Tema;

public class TemasDAO implements DAO<Tema> {


    public void insertar(Tema tema) {
        String sql = "INSERT INTO tema (id_tema, nombre_tema) VALUES (?, ?)";

        try (Connection connection = Database.getInstance().getConnection();
                PreparedStatement pstmt = connection.prepareStatement(sql)) {

            pstmt.setInt(1, tema.getId());
            pstmt.setString(2, tema.getNombre());
            pstmt.executeUpdate();
            System.out.println("Tema agregado con éxito.");
        } catch (SQLException e) {
            System.err.println("Error al agregar tema: " + e.getMessage());
        }
    }

    public List<Tema> buscarTodos() {
        List<Tema> temas = new ArrayList<>();
        String query = "SELECT * FROM tema";

        try (Connection connection = Database.getInstance().getConnection();
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                Tema tema = new Tema(
                        resultSet.getInt("id_tema"),
                        resultSet.getString("nombre_tema"));
                temas.add(tema);
            }
        } catch (SQLException e) {
            System.err.println("Error al listar temas: " + e.getMessage());

        }

        return temas;
    }

    public void eliminar(int id) {
        String sql = "DELETE FROM tema WHERE id = ?";

        try (Connection connection = Database.getInstance().getConnection();
                PreparedStatement pstmt = connection.prepareStatement(sql)) {

            pstmt.setInt(1, id);
            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Tema eliminado con éxito.");
            } else {
                System.out.println("Tema no encontrado.");
            }
        } catch (SQLException e) {
            System.err.println("Error al eliminar tema: " + e.getMessage());
        }
    }

    public void modificar(int id, Tema nuevoTema) {
        String sql = "UPDATE tema SET nombre = ? WHERE id = ?";

        try (Connection connection = Database.getInstance().getConnection();
                PreparedStatement pstmt = connection.prepareStatement(sql)) {

            pstmt.setString(1, nuevoTema.getNombre());
            pstmt.setInt(2, id);

            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Tema modificado con éxito.");
            } else {
                System.out.println("Tema no encontrado para modificar.");
            }
        } catch (SQLException e) {
            System.err.println("Error al modificar tema: " + e.getMessage());
        }
    }

    public List<Tema> obtenerTemasConCantidadPreguntas() {
        List<Tema> temas = new ArrayList<>();

        String query = "SELECT t.id_tema AS ID, t.nombre_tema AS Tema, " +
                       "COUNT(p.id_pregunta) AS \"Cantidad de preguntas\" " +
                       "FROM Tema t " +
                       "LEFT JOIN preguntas p ON t.id_tema = p.id_tema " +
                       "GROUP BY t.id_tema, t.nombre_tema";

        try (Connection conn = Database.getInstance().getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                Tema tema = new Tema();
                tema.setId(rs.getInt("ID"));
                tema.setNombre(rs.getString("Tema"));
                tema.setCantidadPreguntas(rs.getInt("Cantidad de preguntas"));

                temas.add(tema);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return temas;
    }

    
}
