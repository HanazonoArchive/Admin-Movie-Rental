package com.schoolproject.movie_rentaldashboard;

import com.schoolproject.movie_rentaldashboard.model.Movie;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

public class movie_cardController {
    @FXML
    public AnchorPane addToCartPane;

    @FXML
    private AnchorPane movieCard;

    @FXML
    private ImageView movieImage;

    @FXML
    private VBox movieDetailsVBox;

    @FXML
    private Label titleLabel;

    @FXML
    private Label yearLabel;

    @FXML
    private Label durationLabel;

    @FXML
    private Label priceLabel;

    @FXML
    private Button addToCart;

    Movie movie;

    public void initialize(String title, String imagePath, String year, String duration, String price, Movie movie) {
        this.movie = movie;
        // Set movie title
        titleLabel.setText(title);

        // Set movie image
        setImage(imagePath);

        // Set movie details
        yearLabel.setText(year);
        setDurationLabel(duration);
        setPriceLabel(price);
        // Set up hover effect
        movieCard.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                movieCard.setStyle("-fx-background-color: #555555;"); // Adjust the color for the hover effect
                addToCartPane.setVisible(true);
            }
        });

        movieCard.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                movieCard.setStyle("-fx-background-color: #3B3B3B;");
                addToCartPane.setVisible(false);
            }
        });

        addToCart.setOnAction(this::handleAddToCart);
    }

    private void handleAddToCart(ActionEvent actionEvent) {
        System.out.println("Added to cart, details:");
        movie.displayInfo();

        }

    private void setImage(String imagePath) {
        try {
            if (imagePath != null) {
                Image image = new Image(getClass().getResource(imagePath).toExternalForm());
                movieImage.setImage(image);
            } else {
                System.out.println("File Not Found: " + imagePath);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void setDurationLabel(String duration) {
        durationLabel.setText(String.format("%sm", duration));
    }

    private void setPriceLabel(String price) {
        priceLabel.setText(String.format("Php%s", price));
    }
}
