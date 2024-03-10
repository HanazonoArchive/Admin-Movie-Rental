package com.schoolproject.movie_rentaldashboard;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

import java.io.IOException;

public class adminNavigationPanelController {

    public static String log;

    @FXML
    private AnchorPane display_screen;

    @FXML
    private HBox Database_button;

    @FXML
    private Text Logout_button;

    @FXML
    private HBox Logs_button;

    @FXML
    private HBox Movie_button;

    @FXML
    private HBox User_button;

    private AnchorPane home_display;

    public void setHomeDisplay(AnchorPane home_display) {
        this.home_display = home_display;
    }



    @FXML
    void HandlesClicked(MouseEvent event) {
        if(event.getSource() == Movie_button) {
            //Logger
            log = "Action: Clicked -> ID: Movie_button -> Class: adminNavigationPanelController -> Status: Success";
            PrintLog(log);

            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("adminDisplayPanelMovie.fxml"));
                AnchorPane setDisplayScreen = loader.load();

                adminDisplayPanelMovieController controller = loader.getController();
                controller.setScreenDisplay(home_display);

                home_display.getChildren().setAll(setDisplayScreen);
            } catch (Exception e){
                e.printStackTrace();
            }

        } else if (event.getSource() == User_button) {
            //Logger
            log = "Action: Clicked -> ID: User_button -> Class: adminNavigationPanelController -> Status: Success";
            PrintLog(log);

            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("adminDisplayPanelUser.fxml"));
                AnchorPane setDisplayScreen = loader.load();

                adminDisplayPanelUserController controller = loader.getController();
                controller.setScreenDisplay(home_display);

                home_display.getChildren().setAll(setDisplayScreen);
            }catch (Exception e){
                e.printStackTrace();
            }


        } else if (event.getSource() == Logs_button) {
            //Logger
            log = "Action: Clicked -> ID: Logs_button -> Class: adminNavigationPanelController -> Status: Success";
            PrintLog(log);


        } else if (event.getSource() == Database_button) {
            //Logger
            log = "Action: Clicked -> ID: Database_button -> Class: adminNavigationPanelController -> Status: Success";
            PrintLog(log);


        } else if (event.getSource() == Logout_button) {
            //Logger
            log = "Action: Clicked -> ID: Logout_button -> Class: adminNavigationPanelController -> Status: Success";
            PrintLog(log);

            // Palma Palihog ko diri

        }
    }

    private static void PrintLog(String log){
        System.out.println(log);
    }

}