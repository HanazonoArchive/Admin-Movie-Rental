package com.schoolproject.movie_rentaldashboard;

import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;

public class display_dashboardController {

    @FXML
    private AnchorPane dashboard_screen;

    public void setHomeDisplay_Dashboard(AnchorPane homeDisplay) {
        homeDisplay.getChildren().setAll(dashboard_screen);
    }

}
