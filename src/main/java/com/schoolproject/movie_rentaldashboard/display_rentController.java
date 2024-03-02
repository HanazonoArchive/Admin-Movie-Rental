package com.schoolproject.movie_rentaldashboard;

import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;

public class display_rentController {
    @FXML
    private AnchorPane rent_screen;

    public void setHomeDisplay_Rent(AnchorPane homeDisplay) {
        homeDisplay.getChildren().setAll(rent_screen);
    }
}
