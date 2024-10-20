package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    private static final String URL = "jdbc:postgresql://localhost:5432/8_escalones"; // Cambia el nombre de la base de datos
    private static final String USER = "postgres"; // Cambia tu usuario
    private static final String PASSWORD = "123123"; // Cambia tu contraseña

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}