package com.schoolproject.movie_rentaldashboard;

import com.schoolproject.movie_rentaldashboard.model.Movie;
import com.schoolproject.movie_rentaldashboard.model.ShoppingCart;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Cursor;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.util.List;

public class movie_cardController {
    @FXML
    public AnchorPane addToCartPane;
    @FXML
    public VBox detailsPaneVBox;
    @FXML
    public Button details;
    @FXML
    public Pane movieDetailsPane;
    @FXML
    public Label descriptionLabel;
    @FXML
    public FlowPane castContainer;
    @FXML
    public Label outOfStockLabel;
    @FXML
    public VBox titleLabelVBox;
    public ImageView addRatingIcon;
    public Label ratingLabel;
    public ImageView ratingIcon;
    Movie movie;
    ShoppingCart shoppingCart = ShoppingCart.getInstance();

    @FXML
    private AnchorPane movieCard;
    @FXML
    private ImageView movieImage;
    @FXML
    private VBox movieDetailsVBox;
    @FXML
    private Label yearLabel;
    @FXML
    private Label durationLabel;
    @FXML
    private Label priceLabel;
    @FXML
    private Button addToCart;
    @FXML
    private Label titleLabel;
    @FXML
    private HBox ageRatingBox;
    @FXML
    private Label ageRatingLabel;
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
            Label actorLabel = castContainerLabel(actor);
            actorLabel.setPrefHeight(17.0);
            actorLabel.setWrapText(true);

            // Apply styling directly to the label
            actorLabel.setStyle(
                    "-fx-background-color: #4285F4;" +
                            "-fx-text-fill: white;" +
                            "-fx-font-size: 12px;" +
                            "-fx-padding: 0px 2px;" +
                            "-fx-border-radius: 1px;"
            );

            // Optional: add a pointer cursor
            actorLabel.setCursor(Cursor.HAND);

            castContainer.getChildren().add(actorLabel);
        }

        // Apply styles based on age rating
        switch (movie.getAgeRating()) {
            case "G":
                ageRatingBox.setBackground(new Background(new BackgroundFill(Color.valueOf("#05ff00"), CornerRadii.EMPTY, new Insets(0))));
                break;
            case "PG":
                ageRatingBox.setBackground(new Background(new BackgroundFill(Color.valueOf("#b5ff63"), CornerRadii.EMPTY, new Insets(0))));
                break;
            case "PG-13":
                ageRatingBox.setBackground(new Background(new BackgroundFill(Color.valueOf("#FFC107"), CornerRadii.EMPTY, new Insets(0))));
                break;
            case "R":
                ageRatingBox.setBackground(new Background(new BackgroundFill(Color.valueOf("#FF5252"), CornerRadii.EMPTY, new Insets(0))));
                break;
            default:
                // Handle other cases or set a default style
                break;
        }

        // Set the age rating text
        ageRatingLabel.setText(movie.getAgeRating());


        // Set up hover effect
        movieCard.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (movie.isAvailable()) {
                    movieCard.setStyle("-fx-background-color: #555555;"); // Adjust the color for the hover effect
                    addToCartPane.setVisible(true);

                } else {
                    addToCartPane.setStyle("-fx-background-color: #FF1A1A7F;"); // Adjust the color for the hover effect
                    outOfStockLabel.setVisible(true);
                    addToCartPane.setVisible(true);
                    addToCart.setDisable(true);
                }
            }
        });

        movieCard.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (movie.isAvailable()) {
                    movieCard.setStyle("-fx-background-color: #3B3B3B;");
                    addToCartPane.setVisible(false);
                } else {
                    addToCartPane.setStyle("-fx-background-color: #3B3B3B;"); // Adjust the color for the hover effect
                    outOfStockLabel.setVisible(false);
                    addToCartPane.setVisible(false);
                    addToCart.setDisable(false);
                }
            }
        });

        addToCart.setOnAction(this::handleAddToCart);
        details.setOnAction(this::handleShowDetails);
        initializeRating();

    }

    private Label castContainerLabel(String actor) {
        return new Label(actor);
    }

    private void animateDetails(boolean descriptionVisible,
                                double targetWidthTitleLabel,
                                double targetWidthTitleLabelVBox,
                                double translateTarget,
                                double targetWidth,
                                double targetMaxWidth,
                                double targetMinWidth,
                                double targetPanePrefWidth,
                                double targetCardMinWidth,
                                double targetDescriptionMinWidth,
                                double translateRatingBox) {

        KeyValue targetLabelWidthKeyValue = new KeyValue(titleLabel.minWidthProperty(), targetWidthTitleLabel);
        KeyValue titleLabelVBoxWidthKeyValue = new KeyValue(titleLabelVBox.minWidthProperty(), targetWidthTitleLabelVBox);
        KeyValue descriptionVisibleKeyValue = new KeyValue(detailsPaneVBox.visibleProperty(), descriptionVisible);
        KeyValue castContainterLabelKeyValue = new KeyValue(castContainer.visibleProperty(), descriptionVisible);
        KeyValue translateKeyValue = new KeyValue(detailsPaneVBox.translateXProperty(), translateTarget);
        KeyValue widthKeyValue = new KeyValue(detailsPaneVBox.prefWidthProperty(), targetWidth);
        KeyValue maxWidthKeyValue = new KeyValue(detailsPaneVBox.maxWidthProperty(), targetMaxWidth);
        KeyValue minWidthKeyValue = new KeyValue(detailsPaneVBox.minWidthProperty(), targetMinWidth);
        KeyValue panePrefWidthKeyValue = new KeyValue(movieDetailsPane.prefWidthProperty(), targetPanePrefWidth);
        KeyValue cardMinWidthKeyValue = new KeyValue(movieCard.minWidthProperty(), targetCardMinWidth);
        KeyValue descriptionMinWidthKeyValue = new KeyValue(descriptionLabel.minWidthProperty(), targetDescriptionMinWidth);



        KeyFrame keyFrame = new KeyFrame(Duration.seconds(0.2), targetLabelWidthKeyValue, titleLabelVBoxWidthKeyValue, descriptionVisibleKeyValue, castContainterLabelKeyValue, translateKeyValue, widthKeyValue, maxWidthKeyValue, minWidthKeyValue, panePrefWidthKeyValue, cardMinWidthKeyValue, descriptionMinWidthKeyValue);
        Timeline timeline = new Timeline(keyFrame);
        timeline.play();
    }


    private void handleShowDetails(ActionEvent actionEvent) {
        double targetWidthTitleLabel;
        double targetWidthTitleLabelVBox;
        double targetWidth;
        double targetMaxWidth;
        double targetMinWidth;
        double targetPanePrefWidth;
        double targetCardMinWidth;
        double targetDescriptionMinWidth;
        double translateTarget;
        boolean descriptionVisible;
        double translateRatingBox;
        ;

        if (!isDetailsExpanded) {
            // Expand details sideways
            targetWidthTitleLabel = 315;
            targetWidthTitleLabelVBox = 320;
            translateTarget = 125;
            targetWidth = 200.0; // Set your desired expanded width
            targetMaxWidth = 195.0;
            targetMinWidth = 195.0;
            targetPanePrefWidth = 200.0;
            targetCardMinWidth = 320.0;
            targetDescriptionMinWidth = 195.0;
            descriptionVisible = true;
            translateRatingBox = 0;
            isDetailsExpanded = true;
        } else {
            // Collapse details
            targetWidthTitleLabel = 112;
            targetWidthTitleLabelVBox = 120;
            translateTarget = 0.0;
            targetWidth = 120.0; // Set your original width
            targetMaxWidth = 120.0;
            targetMinWidth = 120.0;
            targetPanePrefWidth = 115.0;
            targetCardMinWidth = 120.0;
            targetDescriptionMinWidth = 120.0;
            descriptionVisible = false;
            translateRatingBox = 0;
            isDetailsExpanded = false;
        }


        animateDetails(descriptionVisible,
                targetWidthTitleLabel,
                targetWidthTitleLabelVBox,
                translateTarget,
                targetWidth,
                targetMaxWidth,
                targetMinWidth,
                targetPanePrefWidth,
                targetCardMinWidth,
                targetDescriptionMinWidth,
                translateRatingBox);
    }


    private void handleAddToCart(ActionEvent actionEvent) {
        System.out.println("Added to cart, details:");
        movie.displayInfo();
        shoppingCart.addItem(movie);

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
        durationLabel.setText(String.format("%smin", duration));
    }

    private void setPriceLabel(String price) {
        priceLabel.setText(String.format("Php %s", price));
    }

    private void initializeRating() {
        if (movie.getTotalRatings() > 0) {
            Image image = new Image(getClass().getResource("star-yellow.png").toExternalForm());
            ratingIcon.setImage(image);
            ratingLabel.setText(String.format(" %.1f", movie.getAverageRating()));
        } else if (movie.getTotalRatings() == 0 || movie.getTotalRatings() < 0){
            Image image = new Image(getClass().getResource("star-bleach.png").toExternalForm());
            ratingIcon.setImage(image);
            ratingLabel.setText("0.0");
        }
        Image image = new Image(getClass().getResource("add-yellow.png").toExternalForm());
        addRatingIcon.setImage(image);
    }

    @FXML
    private void handleOpenPopup(MouseEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("rate_popup.fxml"));
            Parent root = loader.load();

            ReviewComponentController controller = loader.getController();
            controller.setMovie(movie); // Pass the selected movie to the review component

            Stage reviewStage = new Stage();
            reviewStage.setTitle("Review Movie");
            reviewStage.setScene(new Scene(root));
            reviewStage.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
