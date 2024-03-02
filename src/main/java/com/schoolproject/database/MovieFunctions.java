package com.schoolproject.database;

import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MovieFunctions {

    public MovieFunctions() {}

    public void addNewMovie(String Title, String Cast, String Genre, String Runtime, String Age_Restriction, String Description, String Image_Card, int Popularity_Vote_Count) {
        Functions f = new Functions();
        int movieIDCount = 1 + f.listLength(getMovieIDList());
        String Movie_ID = String.format("%06d", movieIDCount);
        try (Connection connection = DatabaseConnection.getConnection()) {
            String sql = "INSERT INTO movie_data (Movie_ID, Title, Cast, Genre, Runtime, Age_Restriction, Description, Image_Card, Popularity_Vote_Count) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

            try (PreparedStatement statement = connection.prepareStatement(sql)) {

                statement.setString(1, Movie_ID);
                statement.setString(2, Title);
                statement.setString(3, Cast);
                statement.setString(4, Genre);
                statement.setString(5, Runtime);
                statement.setString(6, Age_Restriction);
                statement.setString(7, Description);
                statement.setString(8, Image_Card);
                statement.setInt(9, Popularity_Vote_Count);

                statement.executeUpdate();

                System.out.println("New movie added successfully.");
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
    public void updateMovie(String Movie_ID, String Title, String Cast, String Genre, String Runtime, String Age_Restriction, String Description, String Image_Card) {
        try (Connection connection = DatabaseConnection.getConnection()) {
            String sql = "UPDATE movie_data SET Title=?, Cast=?, Genre=?, Runtime=?, Age_Restriction=?, Description=?, Image_Card=? WHERE Movie_ID=?";

            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, Title);
                statement.setString(2, Cast);
                statement.setString(3, Genre);
                statement.setString(4, Runtime);
                statement.setString(5, Age_Restriction);
                statement.setString(6, Description);
                statement.setString(7, Image_Card);
                statement.setString(8, Movie_ID);

                statement.executeUpdate();

                System.out.println("Movie updated successfully (excluding Popularity_Vote_Count).");
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
    public void updateMoviePVC(String Movie_ID, int Popularity_Vote_Count) {
        try (Connection connection = DatabaseConnection.getConnection()) {
            String sql = "UPDATE movie_data SET Popularity_Vote_Count=? WHERE Movie_ID=?";

            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setInt(1, Popularity_Vote_Count);
                statement.setString(2, Movie_ID);

                statement.executeUpdate();

                System.out.println("Popularity Vote Count updated successfully.");
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
    public void removeMovieData(String Movie_ID) {
        try (Connection connection = DatabaseConnection.getConnection()) {
            String deleteSql = "DELETE FROM movie_data WHERE Movie_ID=?";

            try (PreparedStatement deleteStatement = connection.prepareStatement(deleteSql)) {
                deleteStatement.setString(1, Movie_ID);
                deleteStatement.executeUpdate();
                System.out.println("Movie with Movie_ID " + Movie_ID + " removed successfully.");

                //Movie_ID update
                String updateSql = "UPDATE movie_data SET Movie_ID = ? WHERE Movie_ID > ?";
                try (PreparedStatement updateStatement = connection.prepareStatement(updateSql)) {

                    int numericMovieID = Integer.parseInt(Movie_ID);
                    numericMovieID--;
                    String updatedMovieID = String.format("%06d", numericMovieID);

                    updateStatement.setString(1, updatedMovieID);
                    updateStatement.setString(2, Movie_ID);
                    updateStatement.executeUpdate();
                    System.out.println("Movie_ID values updated successfully.");
                } catch (SQLException e) {
                    Logger.getLogger(ControlMain.class.getName()).log(Level.SEVERE, null, e);
                    System.out.println("SQLException: " + e.getMessage());
                    System.out.println("SQLState: " + e.getSQLState());
                    System.out.println("VendorError: " + e.getErrorCode());
                }
                //---
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
    public ArrayList<String> getMovieIDList() {
        ArrayList<String> movieIDList = new ArrayList<String>();
        try (Connection connection = DatabaseConnection.getConnection()) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT Movie_ID FROM movie_data");

            while (resultSet.next()) {
                String value = resultSet.getString("Movie_ID");
                movieIDList.add(value);
            }
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            Logger.getLogger(ControlMain.class.getName()).log(Level.SEVERE, null, e);
            System.out.println("SQLException: " + e.getMessage());
            System.out.println("SQLState: " + e.getSQLState());
            System.out.println("VendorError: " + e.getErrorCode());
        }
        return movieIDList;
    }
    public String movieData(String Movie_ID) {
        String movie_info = "";
        try (Connection connection = DatabaseConnection.getConnection()) {
            String sql = "SELECT * FROM movie_data WHERE Movie_ID=?";

            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, Movie_ID);
                ResultSet resultSet = statement.executeQuery();

                if (resultSet.next()) {
                    String Title = resultSet.getString("Title");
                    String Cast = resultSet.getString("Cast");
                    String Genre = resultSet.getString("Genre");
                    String Runtime = resultSet.getString("Runtime");
                    String Age_Restriction = resultSet.getString("Age_Restriction");
                    String Description = resultSet.getString("Description");
                    String Image_Card = resultSet.getString("Image_Card");
                    int Popularity_Vote_Count = resultSet.getInt("Popularity_Vote_Count");

                    movie_info += Title + ":" + Cast + ":" + Genre + ":" + Runtime + ":" + Age_Restriction + ":" + Description + ":" + Image_Card + ":" + Popularity_Vote_Count;
                } else {
                    movie_info = "Movie_ID doesn't exist";
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
        return movie_info;
    }
    public ArrayList<String> getMovieIDListByGenre(String genre) {
        ArrayList<String> movieIDList = new ArrayList<>();
        try (Connection connection = DatabaseConnection.getConnection()) {
            String sql = "SELECT Movie_ID FROM movie_data WHERE Genre=?";

            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, genre);
                ResultSet resultSet = statement.executeQuery();

                while (resultSet.next()) {
                    String value = resultSet.getString("Movie_ID");
                    movieIDList.add(value);
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
        return movieIDList;
    }
    public ArrayList<String> getMovieIDListByAgeRestriction(String agerestriction) {
        ArrayList<String> movieIDList = new ArrayList<>();
        try (Connection connection = DatabaseConnection.getConnection()) {
            String sql = "SELECT Movie_ID FROM movie_data WHERE Age_Restriction=?";

            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, agerestriction);
                ResultSet resultSet = statement.executeQuery();

                while (resultSet.next()) {
                    String value = resultSet.getString("Movie_ID");
                    movieIDList.add(value);
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
        return movieIDList;
    }
    public ArrayList<String> getMovieIDListSortedByTitle() {
        ArrayList<String> movieIDList = new ArrayList<>();
        try (Connection connection = DatabaseConnection.getConnection()) {
            String sql = "SELECT Movie_ID FROM movie_data ORDER BY Title";

            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                ResultSet resultSet = statement.executeQuery();

                while (resultSet.next()) {
                    String value = resultSet.getString("Movie_ID");
                    movieIDList.add(value);
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
        return movieIDList;
    }
    public ArrayList<String> getMovieIDListSortedByPopularity() {
        ArrayList<String> movieIDList = new ArrayList<>();
        try (Connection connection = DatabaseConnection.getConnection()) {
            String sql = "SELECT Movie_ID FROM movie_data ORDER BY Popularity_Vote_Count DESC";

            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                ResultSet resultSet = statement.executeQuery();

                while (resultSet.next()) {
                    String value = resultSet.getString("Movie_ID");
                    movieIDList.add(value);
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
        return movieIDList;
    }
}


