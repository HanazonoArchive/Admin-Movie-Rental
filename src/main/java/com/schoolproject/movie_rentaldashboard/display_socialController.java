package com.schoolproject.movie_rentaldashboard;

import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import java.awt.Desktop;
import java.net.URI;


public class display_socialController {

    @FXML
    private AnchorPane social_display;

    @FXML
    protected void VisitButtonClicked() {
        String url = "https://github.com/HanazonoArchive/Admin-Movie-Rental.git";
        try {
            Desktop.getDesktop().browse(new URI(url));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
   @FXML
    protected void PalmaClicked(){
        String url = "https://github.com/MatchanJJ";
        try {
            Desktop.getDesktop().browse(new URI(url));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @FXML
    protected void PomarClicked(){
        String url = "https://github.com/ayoungmanwithanoldsoul";
        try {
            Desktop.getDesktop().browse(new URI(url));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setHomeDisplay_Social(AnchorPane homeDisplay) {
        homeDisplay.getChildren().setAll(social_display);
    }
}
