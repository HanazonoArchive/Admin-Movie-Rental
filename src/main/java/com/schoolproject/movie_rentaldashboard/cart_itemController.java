package com.schoolproject.movie_rentaldashboard;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

public class cart_itemController {

    @FXML
    private HBox movieInfoBox;

    @FXML
    private Label movieId;

    @FXML
    private Label movieTitle;

    @FXML
    private Label movieGenre;

    @FXML
    private Label movieRuntime;

    @FXML
    private Label movieAgeRating;

    @FXML
    private Label moviePrice;
    @FXML
    private HBox selectedHBox;

    boolean isSelected;
    // You can add methods or event handlers as needed for your application

    // For example, you can have a method to set movie details
    public void initialize(String id, String title, String genre, String runtime, String ageRating, String price) {
        movieId.setText(id);
        movieTitle.setText(title);
        movieGenre.setText(genre);
        movieRuntime.setText(runtime);
        movieAgeRating.setText(ageRating);
        moviePrice.setText(price);

    }


    public void handleHBoxClick(){
        if (isSelected){
            isSelected = false;
            movieInfoBox.setStyle("-fx-background-color: blue;");
        }else {
            isSelected = true;
            movieInfoBox.setStyle("-fx-background-color: red;");
        }

    }

    // Add more methods or event handlers as per your requirements
}
