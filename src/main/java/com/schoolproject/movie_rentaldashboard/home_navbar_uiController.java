package com.schoolproject.movie_rentaldashboard;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.time.temporal.TemporalQueries;

public class home_navbar_uiController {

    private AnchorPane home_display;

    public void setHomeDisplay(AnchorPane home_display) {
        this.home_display = home_display;
    }

    @FXML
    protected void HomeButtonClicked() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("display_dashboard.fxml"));
            AnchorPane dashboardPanel = loader.load();

            display_dashboardController controller = loader.getController();
            controller.setHomeDisplay_Dashboard(home_display);// Set the home_display variable

            home_display.getChildren().setAll(dashboardPanel);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    protected void CartButtonClicked(){
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("display_cart.fxml"));
                AnchorPane cartPanel = loader.load();

                display_cartController controller = loader.getController();
                controller.setHomeDisplay_Cart(home_display);// Set the home_display variable

                home_display.getChildren().setAll(cartPanel);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    @FXML
    protected void RentsButtonClicked(){

    }

    @FXML
    protected void AboutUsButtonClicked(){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("display_aboutus.fxml"));
            AnchorPane aboutUsPanel = loader.load();
            display_aboutusController controller = loader.getController();

            controller.setHomeDisplay_AboutUs(home_display); // Set the home_display variable

            home_display.getChildren().setAll(aboutUsPanel);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    protected void ProfileButtonClicked(){

    }

    @FXML
    protected void SocialButtonClicked(){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("display_social.fxml"));
            AnchorPane SocialPanel = loader.load();
            display_socialController controller = loader.getController();

            controller.setHomeDisplay_Social(home_display); // Set the home_display variable

            home_display.getChildren().setAll(SocialPanel);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    protected void LogOutButtonClicked(){

    }

}
