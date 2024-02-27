package com.schoolproject.movie_rentaldashboard;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;

import java.io.IOException;

public class home_screenController {

    @FXML
    private AnchorPane home_display;

    @FXML
    private FlowPane home_navbar;

    @FXML
    private AnchorPane main_screen;

    public void setHomeDisplay(AnchorPane home_display) {
        this.home_display = home_display;
    }

    @FXML
    public void initialize() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("home_ui_navbar.fxml"));
            FlowPane navbarContent = fxmlLoader.load();

            // Replace display_navbar with loaded content
            main_screen.getChildren().remove(home_navbar);
            main_screen.getChildren().add(navbarContent);

            // Update the reference to home_navbar
            home_navbar = navbarContent;

            // Set the home_display variable in home_navbar_uiController
            home_navbar_uiController controller = fxmlLoader.getController();
            controller.setHomeDisplay(home_display);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
