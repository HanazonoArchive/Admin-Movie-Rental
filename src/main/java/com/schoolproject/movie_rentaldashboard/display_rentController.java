package com.schoolproject.movie_rentaldashboard;

import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;

public class display_rentController {
    public HBox fantasy_content;
    public HBox anime_content;
    public HBox action_content;
    @FXML
    private AnchorPane rent_screen;

    public void setHomeDisplay_Rent(AnchorPane homeDisplay) {
        homeDisplay.getChildren().setAll(rent_screen);
    }
}
