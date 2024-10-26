package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    //Aca traten de que coincida con su db en postgre
    private static final String URL = "jdbc:postgresql://localhost:5432/8_escalones";
    private static final String USER = "postgres";
    private static final String PASSWORD = "123123";

    private static Connection conexion;

    public static Connection getConnection() {
        if (conexion == null) {
            synchronized (Database.class) {
                if (conexion == null) { // Verificación doble para hilos
                    try {
                        conexion = DriverManager.getConnection(URL, USER, PASSWORD);
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return conexion;
    }

    //private ConexionBD() {}

    public static void cerrarConexion() {
        if (conexion != null) {
            try {
                conexion.close();
                conexion = null; // Permite reiniciar la conexión cuando se llame a getConnection nuevamente
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}