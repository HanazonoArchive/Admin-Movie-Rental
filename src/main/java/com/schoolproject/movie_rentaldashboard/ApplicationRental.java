package com.schoolproject.movie_rentaldashboard;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ApplicationRental extends javafx.application.Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(ApplicationRental.class.getResource("home_screen.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1152, 819);
        stage.setTitle("Cinematique");
        stage.setScene(scene);
        stage.show();

        stage.setResizable(false);
    }

    public static void main(String[] args) {
        launch();
    }
}