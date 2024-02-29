package com.schoolproject.movie_rentaldashboard;

import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;

public class display_profileController {

    @FXML
    private AnchorPane profile_display;

    public void setHomeDisplay_Profile(AnchorPane homeDisplay) {
        homeDisplay.getChildren().setAll(profile_display);
    }
}
