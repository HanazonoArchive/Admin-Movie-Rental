package com.schoolproject.movie_rentaldashboard;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

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
            stage.show();
            stage.setResizable(false);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
