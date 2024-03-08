package com.schoolproject.movie_rentaldashboard;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;



public class adminSystemController {

    private String log;

    @FXML
    private AnchorPane main_screen;

    @FXML
    private AnchorPane display_screen;

    @FXML
    private HBox logs_button;

    @FXML
    private HBox movie_button;

    @FXML
    private HBox user_button;

    @FXML
    private HBox database_button;

    @FXML
    private HBox logout_button;

    private void printLog(String log) {
        System.out.println(log);
    }

    public void HandleClicks(MouseEvent event) {
        if (event.getSource() == movie_button) {
            // Logger
            log = "Action: Button Clicked -> ID: movie_button -> Class: adminSystemController.java Type: Controller";
            printLog(log);

        } else if (event.getSource() == user_button) {
            // Logger
            log = "Action: Button Clicked -> ID: user_button -> Class: adminSystemController.java Type: Controller";
            printLog(log);


        } else if (event.getSource() == logs_button) {
            // Logger
            log = "Action: Button Clicked -> ID: logs_button -> Class: adminSystemController.java Type: Controller";
            printLog(log);


        } else if (event.getSource() == database_button) {
            // Logger
            log = "Action: Button Clicked -> ID: database_button -> Class: adminSystemController.java Type: Controller";
            printLog(log);


        } else if (event.getSource() == logout_button) {
            // Logger
            log = "Action: Button Clicked -> ID: logout_button -> Class: adminSystemController.java Type: Controller";
            printLog(log);

            // Functions
        } else {
            System.out.println("Invalid Options");
        }
    }

    @FXML
    public void initialize() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("adminSystemMovie.fxml"));
            AnchorPane homeScreenContent = fxmlLoader.load();

            // Replace display_navbar with loaded content
            main_screen.getChildren().remove(display_screen);
            main_screen.getChildren().add(homeScreenContent);

            // Update the reference to home_navbar
            display_screen = homeScreenContent;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}