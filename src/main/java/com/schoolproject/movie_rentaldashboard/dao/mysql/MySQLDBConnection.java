package com.schoolproject.movie_rentaldashboard.dao.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Utility class to obtain a connection to the MySQL database.
 */
public class MySQLDBConnection {

    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/cinematique?useSSL=false";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";

    /**
     * Private constructor to prevent instantiation.
     */
    private MySQLDBConnection() {
        // Private constructor to prevent instantiation
    }

    /**
     * Gets a connection to the MySQL database.
     *
     * @return A Connection object if the connection is successful, null otherwise.
     */
    public static Connection getConnection() {
        try {
//            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
