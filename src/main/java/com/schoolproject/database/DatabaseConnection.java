package com.schoolproject.database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    // JDBC URL, username, and
    // Establish Connection with database
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/cceprojectdatabase";
    private static final String USERNAME = "paolo";
    private static final String PASSWORD = "paolo";

    public static Connection getConnection() throws SQLException {
        //Return the Connection -- acts like a pooler
        return DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
    }
}

