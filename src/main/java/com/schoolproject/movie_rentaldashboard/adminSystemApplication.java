package com.schoolproject.movie_rentaldashboard;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;

public class adminSystemApplication {

    public adminSystemApplication(String fxmlPath) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(fxmlPath));
            Parent root = fxmlLoader.load();
            Scene scene = new Scene(root, 1250, 650);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("Admin System");
            stage.setResizable(false);
            stage.show();

            ImageView logoicons = new ImageView(getClass().getResource("/com/schoolproject/movie_rentaldashboard/home_ui_navbar_icons/logo.png").toExternalForm());;
            stage.getIcons().add(logoicons.getImage());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
