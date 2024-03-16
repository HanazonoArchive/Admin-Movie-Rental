package com.schoolproject.movie_rentaldashboard;

import com.schoolproject.movie_rentaldashboard.model.Rental;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

import java.sql.Date;
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
    boolean isSelected;



    public void initialize(int rentalId, String title, String genre, int duration, String ageRating, double rentalFee, Date rentalDate, Date returnDate) {
        rentID.setText(String.valueOf(rentalId));
        rentTitle.setText(title);
        rentGenre.setText(genre);
        rentDuration.setText(String.valueOf(duration));
        rentAgeRating.setText(ageRating);
        rentPrice.setText(String.valueOf(rentalFee));
        rentRentalDate.setText(String.valueOf(rentalDate));
        rentReturnDate.setText(String.valueOf(returnDate));
    }
    @FXML
    public void handleHBoxClick(){
        if (isSelected){
            isSelected = false;
            rentInfoBox.setStyle("-fx-background-color: #ffffff;");
        }else {
            isSelected = true;
            rentInfoBox.setStyle("-fx-background-color: lightgray;");
        }

    }
}
