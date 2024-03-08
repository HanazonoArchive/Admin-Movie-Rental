package com.schoolproject.movie_rentaldashboard;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class adminSystemApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(adminSystemApplication.class.getResource("adminSystem.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1000, 650);
        stage.setTitle("Admin System");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
