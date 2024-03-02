package com.schoolproject.database;

import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class UserFunctions {
    public void UserFunctions() {}

     public ArrayList<String> getUserIDList() {
         ArrayList<String> userIDList = new ArrayList<String>();
         try (Connection connection = DatabaseConnection.getConnection()) {
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT userID FROM user_data");

             while (resultSet.next()) {
                 String value = resultSet.getString("userID");
                 userIDList.add(value);
             }
             resultSet.close();
             statement.close();
         } catch (SQLException e) {
             Logger.getLogger(ControlMain.class.getName()).log(Level.SEVERE, null, e);
             System.out.println("SQLException: " + e.getMessage());
             System.out.println("SQLState: " + e.getSQLState());
             System.out.println("VendorError: " + e.getErrorCode());
         }
         return userIDList;
     }
    public String userData(String userID) {
        String user_info = "";
        try (Connection connection = DatabaseConnection.getConnection()) {
            String sql = "SELECT * FROM user_data WHERE userID=?";

            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, userID);
                ResultSet resultSet = statement.executeQuery();

                if (resultSet.next()) {
                    String firstName = resultSet.getString("First_Name");
                    String lastName = resultSet.getString("Last_Name");
                    String contactNumber = resultSet.getString("Contact_Number");
                    String email = resultSet.getString("Email");
                    String Address = resultSet.getString("Address");
                    String MRR = resultSet.getString("MovieID_RentDate_ReturnDate");
                    user_info += userID + ":" + firstName + ":" + lastName + ":" + contactNumber + ":" + email + ":" + Address + ":" + MRR;
                } else {
                    user_info = "User doesn't exist";
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
        return user_info;
    }
    public String hashPassword(String passwordStr) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(passwordStr.getBytes());
            return Base64.getEncoder().encodeToString(hash);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }
    public boolean verifyPassword(String userID, String password) {
        String hashedInput = hashPassword(password);
        String storedhashedPassword = getUserStoredPassword(userID);
        return hashedInput.equals(storedhashedPassword);
    }
    public String getUserStoredPassword(String userID) {
        String storedhashedPassword = "";
        try (Connection connection = DatabaseConnection.getConnection()) {
            String sql = "SELECT * FROM user_data WHERE userID=?";

            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, userID);
                ResultSet resultSet = statement.executeQuery();
                if (resultSet.next()) {
                    storedhashedPassword = resultSet.getString("userPasskey");
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
        return storedhashedPassword;
    }
    public void addNewUser(String userID, String userPasskey, String First_Name, String Last_Name, String Contact_Number, String Email, String Address, String MRR) {
        String hashedUserPassKey = hashPassword(userPasskey);
        try (Connection connection = DatabaseConnection.getConnection()) {
            String sql = "INSERT INTO user_data (userID, userPassKey, First_Name, Last_Name, Contact_Number, Email, Address, MovieID_RentDate_ReturnDate) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

            try (PreparedStatement statement = connection.prepareStatement(sql)) {

                statement.setString(1, userID);
                statement.setString(2, hashedUserPassKey);
                statement.setString(3, First_Name);
                statement.setString(4, Last_Name);
                statement.setString(5, Contact_Number);
                statement.setString(6, Email);
                statement.setString(7, Address);
                statement.setString(8, MRR);
                statement.executeUpdate();

                System.out.println("New user added successfully.");
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
    public void updateUserDataNoMMR(String userID, String First_Name, String Last_Name, String Contact_Number, String Email, String Address) {
        try (Connection connection = DatabaseConnection.getConnection()) {
            String sql = "UPDATE movie_data SET First_Name=?, Last_Name=?, Contact_Number=?, Email=?, Address=? WHERE userID=?";

            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, First_Name);
                statement.setString(2, Last_Name);
                statement.setString(3, Contact_Number);
                statement.setString(4, Email);
                statement.setString(5, Address);
                statement.setString(6, userID);

                statement.executeUpdate();

                System.out.println("User updated successfully (excluding MRR).");
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
    public void updateUserDataMME(String userID, String MRR) {
        try (Connection connection = DatabaseConnection.getConnection()) {
            String sql = "UPDATE movie_data SET MovieID_RentDate_ReturnDate=? WHERE userID=?";

            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, MRR);
                statement.setString(2, userID);

                statement.executeUpdate();

                System.out.println("User MMR updated.");
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
    public void updateUserPasskey(String userID, String currentPasskey, String newPasskey) {
        String newHashedPasskey = hashPassword(newPasskey);
        if (verifyPassword(userID, currentPasskey)) {
            try (Connection connection = DatabaseConnection.getConnection()) {
                String sql = "UPDATE movie_data SET userPasskey=? WHERE userID=?";

                try (PreparedStatement statement = connection.prepareStatement(sql)) {
                    statement.setString(1, newHashedPasskey);
                    statement.setString(2, userID);

                    statement.executeUpdate();

                    System.out.println("User password updated.");
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
        } else {
            System.out.println("Unauthorized password change.");
        }
    }
    public void removeUserData(String userID) {
        try (Connection connection = DatabaseConnection.getConnection()) {
            String deleteSql = "DELETE FROM user_data WHERE userID=?";

            try (PreparedStatement deleteStatement = connection.prepareStatement(deleteSql)) {
                deleteStatement.setString(1, userID);
                deleteStatement.executeUpdate();
                System.out.println("User with username " + userID + " removed successfully.");

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
    public ArrayList<String> getUserIDListSortedbyFirstName() {
        ArrayList<String> sortedUserIDList = new ArrayList<>();
        try (Connection connection = DatabaseConnection.getConnection()) {
            String sql = "SELECT userID FROM user_data ORDER BY First_Name";

            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                ResultSet resultSet = statement.executeQuery();

                while (resultSet.next()) {
                    String value = resultSet.getString("userID");
                    sortedUserIDList.add(value);
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
        return sortedUserIDList;
    }
    public ArrayList<String> getUserIDListSortedbyLastName() {
        ArrayList<String> sortedUserIDList = new ArrayList<>();
        try (Connection connection = DatabaseConnection.getConnection()) {
            String sql = "SELECT userID FROM user_data ORDER BY Last_Name";

            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                ResultSet resultSet = statement.executeQuery();

                while (resultSet.next()) {
                    String value = resultSet.getString("userID");
                    sortedUserIDList.add(value);
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
        return sortedUserIDList;
    }
}
