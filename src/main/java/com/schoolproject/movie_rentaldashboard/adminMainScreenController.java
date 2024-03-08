package com.schoolproject.movie_rentaldashboard;


import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

public class adminMainScreenController {
    @FXML
    private AnchorPane display_panel;

    @FXML
    private AnchorPane main_screen;

    @FXML
    private AnchorPane navigation_panel;

    public void setHomeDisplay(AnchorPane display_panel) {
        this.display_panel = display_panel;
    }

    @FXML
    public void initialize(){
        try {
            // Navigation Bar
            FXMLLoader fxmlLoader= new FXMLLoader(getClass().getResource("adminNavigationPanel.fxml"));
            AnchorPane setNavigationPanel = fxmlLoader.load();

            main_screen.getChildren().remove(navigation_panel);
            main_screen.getChildren().add(setNavigationPanel);

            navigation_panel = setNavigationPanel;

            adminNavigationPanelController controller = fxmlLoader.getController(); // FUCK THIS LINE IS ISSUE #FIXED
            controller.setHomeDisplay(display_panel);

            //=========================================
            // Display Screen
            FXMLLoader loader1 = new FXMLLoader(getClass().getResource("adminDisplayPanelMovie.fxml"));
            AnchorPane setDisplayPanelMovie = loader1.load();

            adminDisplayPanelMovieController DisplayPanelMovieController = loader1.getController();
            DisplayPanelMovieController.setScreenDisplay(display_panel);// Set the home_display variable

            display_panel.getChildren().setAll(setDisplayPanelMovie);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
