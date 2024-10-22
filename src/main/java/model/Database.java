package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    //Aca traten de que coincida con su db en postgre
    private static final String URL = "jdbc:postgresql://localhost:5432/8_escalones";
    private static final String USER = "postgres";
    private static final String PASSWORD = "123123";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}