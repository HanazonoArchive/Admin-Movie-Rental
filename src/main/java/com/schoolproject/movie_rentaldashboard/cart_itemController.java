package com.schoolproject.movie_rentaldashboard;

import com.schoolproject.movie_rentaldashboard.model.Movie;
import com.schoolproject.movie_rentaldashboard.model.ShoppingCart;
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

    ShoppingCart shoppingCart = ShoppingCart.getInstance();

    boolean isSelected;

    Movie movie;
    // You can add methods or event handlers as needed for your application

    // For example, you can have a method to set movie details
    public void initialize(String id, String title, String genre, String runtime, String ageRating, String price, Movie movie) {
        movieId.setText(id);
        movieTitle.setText(title);
        movieGenre.setText(genre);
        movieRuntime.setText(runtime);
        movieAgeRating.setText(ageRating);
        moviePrice.setText(price);
        this.movie =  movie;
    }


    public void handleHBoxClick(){
        if (isSelected){
            isSelected = false;
            movieInfoBox.setStyle("-fx-background-color: blue;");
            shoppingCart.setMovieSelected(movie, false);
        }else {
            isSelected = true;
            movieInfoBox.setStyle("-fx-background-color: red;");
            shoppingCart.setMovieSelected(movie, true);
        }

    }

    // Add more methods or event handlers as per your requirements
}
