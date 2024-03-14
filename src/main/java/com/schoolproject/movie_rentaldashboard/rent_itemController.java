package com.schoolproject.movie_rentaldashboard;

import com.schoolproject.movie_rentaldashboard.model.Rental;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

import java.time.LocalDate;

public class rent_itemController {

    @FXML
    private Label rentAgeRating;

    @FXML
    private Label rentDuration;

    @FXML
    private Label rentGenre;

    @FXML
    private Label rentID;

    @FXML
    private HBox rentInfoBox;

    @FXML
    private Label rentPrice;

    @FXML
    private Label rentRentalDate;

    @FXML
    private Label rentReturnDate;

    @FXML
    private Label rentTitle;


    public void initialize(Rental rental) {
        rentID.setText(String.valueOf(rental.getRentalId()));
        rentTitle.setText(rental.getMovie().getTitle());
        rentGenre.setText(rental.getMovie().getGenre());
        rentDuration.setText(String.valueOf(rental.getMovie().getDuration()));
        rentAgeRating.setText(rental.getMovie().getAgeRating());
        rentPrice.setText(String.valueOf(rental.getRentalFee()));
        rentRentalDate.setText(String.valueOf(rental.getRentalDate()));
        rentReturnDate.setText(String.valueOf(rental.getReturnDate()));
    }
}
