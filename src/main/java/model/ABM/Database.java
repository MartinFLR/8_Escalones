package model.ABM;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    // Datos de conexión
    private static final String URL = "jdbc:postgresql://localhost:5432/8_escalones";
    private static final String USER = "postgres";
    private static final String PASSWORD = "123123";

    private static Database instance; // Instancia singleton
    private Connection conexion;

    public static synchronized Database getInstance() {
        if (instance == null) {
            instance = new Database();
        }
        return instance;
    }

    public Connection getConnection() {
        try {
            if (conexion == null || conexion.isClosed()) {
                synchronized (this) {
                    if (conexion == null || conexion.isClosed()) {
                        conexion = DriverManager.getConnection(URL, USER, PASSWORD);
                        System.out.println("Conexión establecida.");
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conexion;
    }

    public void cerrarConexion() {
        if (conexion != null) {
            try {
                conexion.close();
                conexion = null;
                System.out.println("Conexión cerrada.");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
