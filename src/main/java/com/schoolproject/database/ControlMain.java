package com.schoolproject.database;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ControlMain {
    //for Debugging functions through IDE terminal

    public ControlMain() {}

    public static void main(String[] args) throws SQLException {
        try (Connection connection = DatabaseConnection.getConnection()) {
            MovieFunctions mf = new MovieFunctions();
            System.out.println("Connected to database.");
            mf.removeMovieData("000002");
        } catch (SQLException e) {
            Logger.getLogger(ControlMain.class.getName()).log(Level.SEVERE, null, e);
            System.out.println("SQLException: " + e.getMessage());
            System.out.println("SQLState: " + e.getSQLState());
            System.out.println("VendorError: " + e.getErrorCode());
        }
    }
    public void establishConnection() {
        Connection conn = null;
        String user = "paolo";
        String password = "paolo";
        String database = "cceprojectdatabase";
        int port = 3306;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getConstructor().newInstance();
            conn = DriverManager.getConnection("jdbc:mysql://localhost:" + port + "/" + database, user, password);
            System.out.print("Connection Established");
        } catch (SQLException ex) {
            Logger.getLogger(ControlMain.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        } catch (ClassNotFoundException e) {
            Logger.getLogger(ControlMain.class.getName()).log(Level.SEVERE, null, e);} catch (
                InvocationTargetException | InstantiationException | IllegalAccessException | NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }
}
