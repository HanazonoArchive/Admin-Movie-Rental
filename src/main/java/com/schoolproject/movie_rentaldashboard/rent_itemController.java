package com.schoolproject.movie_rentaldashboard;

import com.schoolproject.movie_rentaldashboard.model.Rental;
import com.schoolproject.movie_rentaldashboard.model.UserRentals;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

import java.sql.Date;
import java.time.LocalDate;

public class rent_itemController {

    public Label returnedCol;
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

    boolean returned;



    boolean isSelected;

    UserRentals userRentals = UserRentals.getInstance();

    private Rental rental;


    public void initialize(String title, String genre, int duration, String ageRating, double rentalFee, Date rentalDate, Date returnDate, boolean returned, Rental rental) {
        rentTitle.setText(title);
        rentGenre.setText(genre);
        rentDuration.setText(String.valueOf(duration));
        rentAgeRating.setText(ageRating);
        rentPrice.setText(String.valueOf(rentalFee));
        rentRentalDate.setText(String.valueOf(rentalDate));
        rentReturnDate.setText(String.valueOf(returnDate));
        this.returned = returned;
        this.rental = rental;
        handleReturnedStatusCol(returned);
    }

    public void handleHBoxClick(){
        if (isSelected){
            isSelected = false;

            rentInfoBox.setStyle("-fx-background-color: white;");
            userRentals.setRentalSelected(rental, false);
            userRentals.popItem(rental);

            System.out.println("if");
        }else {
            isSelected = true;

            rentInfoBox.setStyle("-fx-background-color: lightgray;");
            userRentals.setRentalSelected(rental, true);
            userRentals.addItem(rental);
            System.out.println("else");
        }

    }

    private void handleReturnedStatusCol (boolean returned) {
        if(returned){
            returnedCol.setStyle("-fx-background-color: green;");
            returnedCol.setText("Returned");
            rentInfoBox.setDisable(true);
        } else {
            returnedCol.setStyle("-fx-background-color: red;");
            returnedCol.setText("Not Returned");
        }
    }

}
