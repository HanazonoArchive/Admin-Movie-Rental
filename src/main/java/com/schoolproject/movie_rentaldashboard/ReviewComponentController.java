package com.schoolproject.movie_rentaldashboard;

import com.schoolproject.movie_rentaldashboard.dao.mysql.MySQLReviewDAO;
import com.schoolproject.movie_rentaldashboard.model.Movie;
import com.schoolproject.movie_rentaldashboard.model.Review;
import com.schoolproject.movie_rentaldashboard.model.UserLogged;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.sql.Date;
import java.time.LocalDate;

public class ReviewComponentController {

    @FXML
    private ImageView star1;

    @FXML
    private ImageView star2;

    @FXML
    private ImageView star3;

    @FXML
    private ImageView star4;

    @FXML
    private ImageView star5;

    @FXML
    private TextArea commentTextArea;

    @FXML
    private Button submitButton;

    @FXML
    private Label movieTitle;

    private Movie movie;


    private int rating = 0; // Initially no star is selected

    @FXML
    void initialize() {
        // Initialize star icons
        setStarEvents(star1, 1);
        setStarEvents(star2, 2);
        setStarEvents(star3, 3);
        setStarEvents(star4, 4);
        setStarEvents(star5, 5);

        // Disable submit button initially
        submitButton.setDisable(true);

        // Add listener to comment text area to enable submit button when text is entered
        commentTextArea.textProperty().addListener((observable, oldValue, newValue) -> {
            submitButton.setDisable(newValue.trim().isEmpty());
        });
    }

    // Method to handle clicking on a star
    private void setStarEvents(ImageView star, int value) {
        star.setOnMouseClicked(event -> {
            rating = value;
            updateStars();
        });
    }

    // Method to update star colors based on the rating
    private void updateStars() {
        switch (rating) {
            case 1:
                fillStar(star1);
                clearStars(star2, star3, star4, star5);
                break;
            case 2:
                fillStar(star1, star2);
                clearStars(star3, star4, star5);
                break;
            case 3:
                fillStar(star1, star2, star3);
                clearStars(star4, star5);
                break;
            case 4:
                fillStar(star1, star2, star3, star4);
                clearStars(star5);
                break;
            case 5:
                fillStar(star1, star2, star3, star4, star5);
                break;
            default:
                clearStars(star1, star2, star3, star4, star5);
        }
    }

    // Method to fill a star
    private void fillStar(ImageView... stars) {
        for (ImageView star : stars) {
            star.setImage(new Image(getClass().getResource("star-yellow.png").toExternalForm()));
        }
    }

    // Method to clear a star
    private void clearStars(ImageView... stars) {
        for (ImageView star : stars) {
            star.setImage(new Image(getClass().getResource("star-bleach.png").toExternalForm()));
        }
    }

    // Method to handle submitting the review
    @FXML
    void handleSubmit(ActionEvent event) {
        LocalDate todayDate = LocalDate.now();
        Date sqlTodayDate = Date.valueOf(todayDate);
        String comment = commentTextArea.getText();
        MySQLReviewDAO mySQLReviewDAO = new MySQLReviewDAO();
        UserLogged userLogged = UserLogged.getInstance();
        mySQLReviewDAO.addReview(new Review(userLogged.getCustomer().getCustomerId(), Integer.parseInt(movie.getMovieId(), 10), rating, comment, sqlTodayDate));
        Stage stage = (Stage) submitButton.getScene().getWindow();
        stage.close();
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
        movieTitle.setText(movie.getTitle());
    }
}
