package com.schoolproject.movie_rentaldashboard;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import java.awt.Desktop;
import java.net.URI;


public class display_socialController {

    @FXML
    private AnchorPane social_display;

    @FXML
    private Button visit_cuandot;

    @FXML
    private Button visit_hanazono;

    @FXML
    private Button visit_palma;

    @FXML
    private Button visit_pechayco;

    @FXML
    private Button visit_pomar;

    @FXML
    protected void HandleClicks(javafx.event.ActionEvent event) {
        if (event.getSource() == visit_hanazono) {
            String url = "https://github.com/HanazonoArchive/Admin-Movie-Rental.git";
            try {
                Desktop.getDesktop().browse(new URI(url));
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (event.getSource() == visit_palma) {
            String url = "https://github.com/MatchanJJ";
            try {
                Desktop.getDesktop().browse(new URI(url));
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (event.getSource() == visit_pomar) {
            String url = "https://github.com/ayoungmanwithanoldsoul";
            try {
                Desktop.getDesktop().browse(new URI(url));
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (event.getSource() == visit_pechayco) {
            String url = "https://github.com/chicocaine?fbclid=IwAR2CvI2ATlcD2GcjGSyesWhFeqfPSqjJHQBod2qkxRLN29iBeDfsoflDhnc";
            try {
                Desktop.getDesktop().browse(new URI(url));
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (event.getSource() == visit_cuandot) {
            String url = "https://github.com/Darell26?fbclid=IwAR2hbeV9Ir5XldzYfBVY6ok8rqUyPh-ShjQ7HC_Qbx2Cq-MdGh7XlZTrq-Y";
            try {
                Desktop.getDesktop().browse(new URI(url));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else {
            System.err.println("Invalid Options!");
        }
    }

    public void setHomeDisplay_Social(AnchorPane homeDisplay) {
        homeDisplay.getChildren().setAll(social_display);
    }
}
