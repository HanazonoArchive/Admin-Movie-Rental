package com.schoolproject.movie_rentaldashboard;


import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import java.io.IOException;


public class home_navbar_uiController {

    private AnchorPane home_display;

    @FXML
    private Button home_button;

    @FXML
    private Button movies_button;

    @FXML
    private Button cart_button;

    @FXML
    private Button aboutus_button;

    @FXML
    private Button profile_button;
    
    @FXML
    private Button social_button;

    @FXML
    private Button logout_button;

    public void setHomeDisplay(AnchorPane home_display) {
        this.home_display = home_display;
    }


    @FXML
    public void HandleClicks(javafx.event.ActionEvent event) {
        if (event.getSource() == home_button){
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("display_dashboard.fxml"));
                AnchorPane dashboardPanel = loader.load();

                display_dashboardController controller = loader.getController();
                controller.setHomeDisplay_Dashboard(home_display);// Set the home_display variable

                home_display.getChildren().setAll(dashboardPanel);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if (event.getSource() == movies_button) {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("display_rent.fxml"));
                AnchorPane rentPanel = loader.load();
                display_rentController controller = loader.getController();

                controller.setHomeDisplay_Rent(home_display); // Set the home_display variable

                home_display.getChildren().setAll(rentPanel);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if (event.getSource() == cart_button) {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("display_cart.fxml"));
                AnchorPane cartPanel = loader.load();

                display_cartController controller = loader.getController();
                controller.setHomeDisplay_Cart(home_display);// Set the home_display variable

                home_display.getChildren().setAll(cartPanel);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if (event.getSource() == aboutus_button) {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("display_aboutus.fxml"));
                AnchorPane aboutUsPanel = loader.load();
                display_aboutusController controller = loader.getController();

                controller.setHomeDisplay_AboutUs(home_display); // Set the home_display variable

                home_display.getChildren().setAll(aboutUsPanel);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if (event.getSource() == profile_button) {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("display_profile.fxml"));
                AnchorPane SocialPanel = loader.load();
                display_profileController controller = loader.getController();

                controller.setHomeDisplay_Profile(home_display); // Set the home_display variable

                home_display.getChildren().setAll(SocialPanel);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if (event.getSource() == social_button) {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("display_social.fxml"));
                AnchorPane SocialPanel = loader.load();
                display_socialController controller = loader.getController();

                controller.setHomeDisplay_Social(home_display); // Set the home_display variable

                home_display.getChildren().setAll(SocialPanel);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if (event.getSource() == logout_button) {
            Stage stage = (Stage) home_display.getScene().getWindow();
            stage.close();
            new LoginDemo(stage);
        } else {
            System.err.println("Uknown Options!");
        }
    }
}
