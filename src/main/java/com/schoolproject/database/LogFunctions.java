package com.schoolproject.database;

import java.sql.*;
import java.util.*;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.text.SimpleDateFormat;

public class LogFunctions {
    public void LogFunctions() {}

    public void log(Date Date_Time, String Action_Log, String LogIN_OUT, String RENT_RETURN) {
        Functions f = new Functions();
        int ActionIDCount = 1 + f.listLength(getActionIDList());
        String Action_ID = String.format("%09d", ActionIDCount);
        try (Connection connection = DatabaseConnection.getConnection()) {
            String sql = "INSERT INTO log (Action_ID, Date_Time, Action_Log, LogIN_OUT, RENT_RETURN) VALUES (?, ?, ?, ?, ?)";

            try (PreparedStatement statement = connection.prepareStatement(sql)) {

                Timestamp timestamp = new Timestamp(Date_Time.getTime());

                statement.setString(1, Action_ID);
                statement.setTimestamp(2, timestamp);
                statement.setString(3, Action_Log);
                statement.setString(4, LogIN_OUT);
                statement.setString(5, RENT_RETURN);

                statement.executeUpdate();

                System.out.println("Logged action successfully.");
            } catch (SQLException e) {
                Logger.getLogger(ControlMain.class.getName()).log(Level.SEVERE, null, e);
                System.out.println("SQLException: " + e.getMessage());
                System.out.println("SQLState: " + e.getSQLState());
                System.out.println("VendorError: " + e.getErrorCode());
            }
        } catch (SQLException e) {
            Logger.getLogger(ControlMain.class.getName()).log(Level.SEVERE, null, e);
            System.out.println("SQLException: " + e.getMessage());
            System.out.println("SQLState: " + e.getSQLState());
            System.out.println("VendorError: " + e.getErrorCode());
        }
    }
    public ArrayList<String> getActionIDList() {
        ArrayList<String> ActionIDList = new ArrayList<String>();
        try (Connection connection = DatabaseConnection.getConnection()) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT Action_ID FROM log");

            while (resultSet.next()) {
                String value = resultSet.getString("Action_ID");
                ActionIDList.add(value);
            }
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            Logger.getLogger(ControlMain.class.getName()).log(Level.SEVERE, null, e);
            System.out.println("SQLException: " + e.getMessage());
            System.out.println("SQLState: " + e.getSQLState());
            System.out.println("VendorError: " + e.getErrorCode());
        }
        return ActionIDList;
    }
    public ArrayList<String> getActionIDListByLogInorOut(String loginorout) {
        ArrayList<String> ActionIDList = new ArrayList<>();
        try (Connection connection = DatabaseConnection.getConnection()) {
            String sql = "SELECT Action_ID FROM log WHERE LogIN_OUT=?";

            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, loginorout);
                ResultSet resultSet = statement.executeQuery();

                while (resultSet.next()) {
                    String value = resultSet.getString("Action_ID");
                    getActionIDList().add(value);
                }
            } catch (SQLException e) {
                Logger.getLogger(ControlMain.class.getName()).log(Level.SEVERE, null, e);
                System.out.println("SQLException: " + e.getMessage());
                System.out.println("SQLState: " + e.getSQLState());
                System.out.println("VendorError: " + e.getErrorCode());
            }
        } catch (SQLException e) {
            Logger.getLogger(ControlMain.class.getName()).log(Level.SEVERE, null, e);
            System.out.println("SQLException: " + e.getMessage());
            System.out.println("SQLState: " + e.getSQLState());
            System.out.println("VendorError: " + e.getErrorCode());
        }
        return ActionIDList;
    }
    public ArrayList<String> getActionIDListByRentorReturn(String rentorreturn) {
        ArrayList<String> ActionIDList = new ArrayList<>();
        try (Connection connection = DatabaseConnection.getConnection()) {
            String sql = "SELECT Action_ID FROM log WHERE RENT_RETURN=?";

            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, rentorreturn);
                ResultSet resultSet = statement.executeQuery();

                while (resultSet.next()) {
                    String value = resultSet.getString("Action_ID");
                    getActionIDList().add(value);
                }
            } catch (SQLException e) {
                Logger.getLogger(ControlMain.class.getName()).log(Level.SEVERE, null, e);
                System.out.println("SQLException: " + e.getMessage());
                System.out.println("SQLState: " + e.getSQLState());
                System.out.println("VendorError: " + e.getErrorCode());
            }
        } catch (SQLException e) {
            Logger.getLogger(ControlMain.class.getName()).log(Level.SEVERE, null, e);
            System.out.println("SQLException: " + e.getMessage());
            System.out.println("SQLState: " + e.getSQLState());
            System.out.println("VendorError: " + e.getErrorCode());
        }
        return ActionIDList;
    }
    public String actionLogData(String Action_ID) {
        String action_info = "";
        try (Connection connection = DatabaseConnection.getConnection()) {
            String sql = "SELECT * FROM log WHERE Action_ID=?";

            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, Action_ID);
                ResultSet resultSet = statement.executeQuery();

                if (resultSet.next()) {
                    Date datetime = resultSet.getTimestamp("Date_Time");
                    String Action_log = resultSet.getString("Action_Log");
                    String LogIN_OUT = resultSet.getString("LogIN_OUT");
                    String RENT_RETURN = resultSet.getString("RENT_RETURN");
                    //date and time format
                    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    String formattedDateTime = dateFormat.format(datetime);
                    action_info += formattedDateTime + ":" + Action_log + ":" + LogIN_OUT + ":" + RENT_RETURN;
                } else {
                    action_info = "Action_ID doesn't exist";
                }

            } catch (SQLException e) {
                Logger.getLogger(ControlMain.class.getName()).log(Level.SEVERE, null, e);
                System.out.println("SQLException: " + e.getMessage());
                System.out.println("SQLState: " + e.getSQLState());
                System.out.println("VendorError: " + e.getErrorCode());
            }
        } catch (SQLException e) {
            Logger.getLogger(ControlMain.class.getName()).log(Level.SEVERE, null, e);
            System.out.println("SQLException: " + e.getMessage());
            System.out.println("SQLState: " + e.getSQLState());
            System.out.println("VendorError: " + e.getErrorCode());
        }
        return action_info;
    }
}
