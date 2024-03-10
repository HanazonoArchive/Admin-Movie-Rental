package com.schoolproject.movie_rentaldashboard.dao.mysql;

import com.schoolproject.movie_rentaldashboard.dao.LogsDAO;
import com.schoolproject.movie_rentaldashboard.model.Logs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MySQLLogsDAO implements LogsDAO {

    private static final String GET_LOG_BY_ID_QUERY = "SELECT * FROM Logs WHERE ActionID=?";
    private static final String GET_ALL_LOGS_QUERY = "SELECT * FROM Logs";
    private static final String ADD_LOG_QUERY = "INSERT INTO Logs (DateTime, UserType, UserName, Action, Details) VALUES (?, ?, ?, ?, ?)";

    @Override
    public Logs getLogbyId(int actionId) {
        try (Connection connection = MySQLDBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(GET_LOG_BY_ID_QUERY)) {

            preparedStatement.setInt(1, actionId);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    String dateTime = resultSet.getString("DateTime");
                    String userType = resultSet.getString("UserType");
                    String userName = resultSet.getString("UserName");
                    String action = resultSet.getString("Action");
                    String details = resultSet.getString("Details");

                    return new Logs(actionId, dateTime, userType, userName, action, details);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Logs> getAllLogs() {
        List<Logs> logs = new ArrayList<>();
        try (Connection connection = MySQLDBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL_LOGS_QUERY);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                int actionId = resultSet.getInt("ActionID");
                String dateTime = resultSet.getString("DateTime");
                String userType = resultSet.getString("UserType");
                String userName = resultSet.getString("UserName");
                String action = resultSet.getString("Action");
                String details = resultSet.getString("Details");

                logs.add(new Logs(actionId, dateTime, userType, userName, action, details));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return logs;
    }

    @Override
    public boolean addLog(Logs log) {
        try (Connection connection = MySQLDBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(ADD_LOG_QUERY)) {

            preparedStatement.setString(1, log.getDateTime());
            preparedStatement.setString(2, log.getUserType());
            preparedStatement.setString(3, log.getUserName());
            preparedStatement.setString(4, log.getAction());
            preparedStatement.setString(5, log.getDetails());

            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
