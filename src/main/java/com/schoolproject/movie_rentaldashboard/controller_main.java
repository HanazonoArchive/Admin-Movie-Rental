package com.schoolproject.movie_rentaldashboard;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;

import java.io.IOException;

public class controller_main {

    @FXML
    private FlowPane display_navbar;

    @FXML
    private AnchorPane display_output;

    @FXML
    private AnchorPane main_frame;

    @FXML
    public void initialize() {
        try {
            // Load navbar.fxml
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("navbar.fxml"));
            FlowPane navbarContent = fxmlLoader.load();

            // Replace display_navbar with loaded content
            main_frame.getChildren().remove(display_navbar);
            main_frame.getChildren().add(navbarContent);
            display_navbar = navbarContent;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
