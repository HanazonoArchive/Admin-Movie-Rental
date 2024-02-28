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
            //Navigation Bar ==============================
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("home_ui_navbar.fxml"));
            FlowPane navbarContent = fxmlLoader.load();

            // Replace display_navbar with loaded content
            main_screen.getChildren().remove(home_navbar);
            main_screen.getChildren().add(navbarContent);

            // Update the reference to home_navbar
            home_navbar = navbarContent;

            // Set the home_display variable in home_navbar_uiController
            home_navbar_uiController navbar_controller = fxmlLoader.getController();
            navbar_controller.setHomeDisplay(home_display);

            //Dashboard Display ===========================
            FXMLLoader loader = new FXMLLoader(getClass().getResource("display_dashboard.fxml"));
            AnchorPane dashboardPanel = loader.load();

            display_dashboardController dashboard_controller = loader.getController();
            dashboard_controller.setHomeDisplay_Dashboard(home_display);// Set the home_display variable

            home_display.getChildren().setAll(dashboardPanel);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
