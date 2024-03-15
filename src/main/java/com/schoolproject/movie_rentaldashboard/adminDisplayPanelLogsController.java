package com.schoolproject.movie_rentaldashboard;

import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;

import com.schoolproject.movie_rentaldashboard.model.Logs;
import com.schoolproject.movie_rentaldashboard.dao.mysql.MySQLLogsDAO;

import java.util.List;

public class adminDisplayPanelLogsController {

    @FXML
    private AnchorPane display_panel;

    @FXML
    private ListView<String> logs_output;

    public void setScreenDisplay(AnchorPane homeDisplay) {
        homeDisplay.getChildren().setAll(display_panel);
    }

    // Method to add log messages to the ListView
    public void addLogMessage(String message) {
        logs_output.getItems().add(message);
    }

    // Method to clear all log messages from the ListView
    public void clearLogs() {
        logs_output.getItems().clear();
    }

    public void logMessages() {
        MySQLLogsDAO e = new MySQLLogsDAO();
        List<Logs> logs = e.getAllLogs();
        for (Logs log : logs) {
            String actionId = String.valueOf(log.getActionId());
            String dateTime = String.valueOf(log.getDateTime());
            String userType = log.getUserType();
            String userName = log.getUserName();
            String details = log.getDetails();

            String logString = actionId + "|" + dateTime + "|" + userType + "|" + userName + "|" + details;
            addLogMessage(logString);
        }
    }
}
