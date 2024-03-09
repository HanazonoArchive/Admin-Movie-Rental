package com.schoolproject.movie_rentaldashboard;

import com.schoolproject.movie_rentaldashboard.model.Movie;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.util.Duration;

import java.util.List;

public class movie_cardController {
    @FXML
    public AnchorPane addToCartPane;
    public VBox DetailsPane;
    public Button details;
    public Pane pane;
    public Label descriptionLabel;
    public FlowPane castContainer;
    public AnchorPane outOfStockPane;
    Movie movie;
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
    private boolean isDetailsExpanded = false;

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
        descriptionLabel.setText(movie.getDescription());
        List<String> cast = movie.getCast();

        for (String actor : cast) {
            Label actorLabel = new Label(actor);
            actorLabel.setPrefHeight(17.0);
            actorLabel.setWrapText(true);
            castContainer.getChildren().add(actorLabel);
        }
        // Set up hover effect
        movieCard.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (movie.isAvailable()) {
                    movieCard.setStyle("-fx-background-color: #555555;"); // Adjust the color for the hover effect
                    addToCartPane.setVisible(true);
                } else {
                    outOfStockPane.setVisible(true);
                }
            }
        });

        movieCard.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if(movie.isAvailable()){
                movieCard.setStyle("-fx-background-color: #3B3B3B;");
                addToCartPane.setVisible(false);
                } else {
                    outOfStockPane.setVisible(false);
                }
            }
        });

        addToCart.setOnAction(this::handleAddToCart);
        details.setOnAction(this::handleShowDetails);
    }

    private void animateDetails(boolean descriptionVisible, double translateTarget, double targetWidth, double targetMaxWidth, double targetMinWidth, double targetPanePrefWidth, double targetCardMinWidth, double targetDescriptionMinWidth) {

        KeyValue descriptionVisibleKeyValue = new KeyValue(descriptionLabel.visibleProperty(), descriptionVisible);
        KeyValue translateKeyValue = new KeyValue(DetailsPane.translateXProperty(), translateTarget);
        KeyValue widthKeyValue = new KeyValue(DetailsPane.prefWidthProperty(), targetWidth);
        KeyValue maxWidthKeyValue = new KeyValue(DetailsPane.maxWidthProperty(), targetMaxWidth);
        KeyValue minWidthKeyValue = new KeyValue(DetailsPane.minWidthProperty(), targetMinWidth);
        KeyValue panePrefWidthKeyValue = new KeyValue(pane.prefWidthProperty(), targetPanePrefWidth);
        KeyValue cardMinWidthKeyValue = new KeyValue(movieCard.minWidthProperty(), targetCardMinWidth);
        KeyValue descriptionMinWidthKeyValue = new KeyValue(descriptionLabel.minWidthProperty(), targetDescriptionMinWidth);


        KeyFrame keyFrame = new KeyFrame(Duration.seconds(0.3), descriptionVisibleKeyValue, translateKeyValue, widthKeyValue, maxWidthKeyValue, minWidthKeyValue, panePrefWidthKeyValue, cardMinWidthKeyValue, descriptionMinWidthKeyValue);
        Timeline timeline = new Timeline(keyFrame);
//        timeline.setOnFinished(event -> transition.play()); // Start translation after width animation
        timeline.play();
    }


    private void handleShowDetails(ActionEvent actionEvent) {
        double targetWidth;
        double targetMaxWidth;
        double targetMinWidth;
        double targetPanePrefWidth;
        double targetCardMinWidth;
        double targetDescriptionMinWidth;
        double translateTarget;
        boolean descriptionVisible;

        if (!isDetailsExpanded) {
            // Expand details sideways
            translateTarget = 120.0;
            targetWidth = 200.0; // Set your desired expanded width
            targetMaxWidth = 195.0;
            targetMinWidth = 195.0;
            targetPanePrefWidth = 200.0;
            targetCardMinWidth = 320.0;
            targetDescriptionMinWidth = 195.0;
            descriptionVisible = true;
            isDetailsExpanded = true;
        } else {
            // Collapse details
            translateTarget = 0.0;
            targetWidth = 120.0; // Set your original width
            targetMaxWidth = 120.0;
            targetMinWidth = 120.0;
            targetPanePrefWidth = 115.0;
            targetCardMinWidth = 120.0;
            targetDescriptionMinWidth = 121.0;
            descriptionVisible = false;
            isDetailsExpanded = false;
        }


        animateDetails(descriptionVisible, translateTarget, targetWidth, targetMaxWidth, targetMinWidth, targetPanePrefWidth, targetCardMinWidth, targetDescriptionMinWidth);
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
