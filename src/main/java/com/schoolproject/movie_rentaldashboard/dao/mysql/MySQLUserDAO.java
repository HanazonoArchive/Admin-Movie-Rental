package com.schoolproject.movie_rentaldashboard.dao.mysql;

import com.schoolproject.movie_rentaldashboard.authentication.PasswordHasher;
import com.schoolproject.movie_rentaldashboard.dao.UserDAO;
import com.schoolproject.movie_rentaldashboard.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MySQLUserDAO implements UserDAO {

    private static final String GET_USER_BY_USERNAME_QUERY = "SELECT * FROM Users WHERE username=?";
    private static final String GET_USER_BY_USERID_QUERY = "SELECT * FROM Users WHERE userId=?";
    private static final String ADD_USER_QUERY = "INSERT INTO Users (username, password) VALUES (?, ?)";
    private static final String UPDATE_USER_PASSWORD_QUERY = "UPDATE Users SET password=? WHERE username=?";

    @Override
    public User getUserByUsername(String username) {
        try (Connection connection = MySQLDBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(GET_USER_BY_USERNAME_QUERY)) {

            preparedStatement.setString(1, username);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
//                    int userId = resultSet.getInt("userId");
                    String password = resultSet.getString("password");

                    return new User(username, password);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public User getUserByUserId(int userId){
        try (Connection connection = MySQLDBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(GET_USER_BY_USERID_QUERY)) {

            preparedStatement.setInt(1, userId);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    String username =  resultSet.getString("username");
                    String password = resultSet.getString("password");

                    return new User(username, password);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean addUser(User user) {
        try (Connection connection = MySQLDBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(ADD_USER_QUERY)) {

            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, PasswordHasher.hashPassword(user.getPassword()));

            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean updateUserPassword(String username, String newPassword) {
        try (Connection connection = MySQLDBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_USER_PASSWORD_QUERY)) {

            preparedStatement.setString(1, PasswordHasher.hashPassword(newPassword));
            preparedStatement.setString(2, username);

            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
