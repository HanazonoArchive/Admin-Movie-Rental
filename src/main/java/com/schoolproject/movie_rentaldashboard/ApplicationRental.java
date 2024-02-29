package com.schoolproject.movie_rentaldashboard;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.scene.image.Image;

import java.io.IOException;

public class ApplicationRental {

    public ApplicationRental(String fxmlPath) {
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(fxmlPath));
        try {
            Parent root = fxmlLoader.load();
            Scene scene = new Scene(root, 1152, 819);
            stage.setTitle("Cinematique");
            stage.setScene(scene);
            stage.setResizable(false);

            ImageView logoicons = new ImageView(getClass().getResource("/com/schoolproject/movie_rentaldashboard/home_ui_navbar_icons/logo.png").toExternalForm());;
            stage.getIcons().add(logoicons.getImage());

            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
