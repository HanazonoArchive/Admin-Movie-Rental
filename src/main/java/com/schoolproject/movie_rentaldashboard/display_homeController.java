package com.schoolproject.movie_rentaldashboard;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class display_homeController {
    @FXML
    private AnchorPane home_display;

    public void setHomeDisplay(AnchorPane homeDisplay) {
        homeDisplay.getChildren().setAll(home_display);
    }



}



