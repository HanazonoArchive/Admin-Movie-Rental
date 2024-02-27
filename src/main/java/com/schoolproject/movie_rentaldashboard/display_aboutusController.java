package com.schoolproject.movie_rentaldashboard;

import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;

public class display_aboutusController {

    @FXML
    private AnchorPane aboutus_display;

    public void setHomeDisplay_AboutUs(AnchorPane homeDisplay) {
        homeDisplay.getChildren().setAll(aboutus_display);
    }

}
