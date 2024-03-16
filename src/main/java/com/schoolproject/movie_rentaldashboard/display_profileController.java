package com.schoolproject.movie_rentaldashboard;

import com.schoolproject.movie_rentaldashboard.dao.CustomerDAO;
import com.schoolproject.movie_rentaldashboard.dao.RentalDAO;
import com.schoolproject.movie_rentaldashboard.dao.mysql.MySQLCustomerDAO;
import com.schoolproject.movie_rentaldashboard.dao.mysql.MySQLRentalDAO;
import com.schoolproject.movie_rentaldashboard.model.Customer;
import com.schoolproject.movie_rentaldashboard.model.Rental;
import com.schoolproject.movie_rentaldashboard.model.User;
import com.schoolproject.movie_rentaldashboard.model.UserLogged;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class display_profileController implements Initializable{
    @FXML
    private TextArea basicTextField;

    @FXML
    private TextArea contactTextField;

    @FXML
    private AnchorPane profile_display;
    @FXML
    private Button btnReturn;
    @FXML
    private ScrollPane rentScroll;


    private MySQLCustomerDAO mySQLCustomerDAO = new MySQLCustomerDAO();

    public void setHomeDisplay_Profile(AnchorPane homeDisplay) {
        homeDisplay.getChildren().setAll(profile_display);
    }

    @FXML
    public void displayBasicInfo(String username) {
        Customer customer = mySQLCustomerDAO.getCustomerByusername(username);
        if (customer != null) {
            basicTextField.setText("First Name: " + customer.getFirstName() + "\n"
                    + "Last Name: " + customer.getLastName() );
        } else {
            basicTextField.setText("No customer found with the provided user ID.");
        }
    }

    @FXML
    public void displayBasicInfo(int customerId) {
        Customer customer = mySQLCustomerDAO.getCustomerById(customerId);
        if (customer != null) {
            basicTextField.setText("First Name: " + customer.getFirstName() + "\n"
                    + "Last Name: " + customer.getLastName() );
        } else {
            basicTextField.setText("No customer found with the provided user ID.");
        }
    }

    @FXML
    public void displayContactInfo(String username) {
        Customer customer = mySQLCustomerDAO.getCustomerByusername(username);
        if (customer != null) {
            contactTextField.setText("Contact Number: " + customer.getContactNumber() + "\n"
                    + "Email: " + customer.getEmail() + "\n"
                    + "Address: " + customer.getAddress());
        } else {
            contactTextField.setText("No customer found with the provided user ID.");
        }
    }

    public void displayContactInfo(int customerId) {
        Customer customer = mySQLCustomerDAO.getCustomerById(customerId);
        if (customer != null) {
            contactTextField.setText("Contact Number: " + customer.getContactNumber() + "\n"
                    + "Email: " + customer.getEmail() + "\n"
                    + "Address: " + customer.getAddress());
        } else {
            contactTextField.setText("No customer found with the provided user ID.");
        }
    }

    public void returnMovie(){

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        UserLogged userLogged = UserLogged.getInstance();
        displayRentalsByCustomer(userLogged.getUser());
    }

    @FXML
    public void displayRentals() {
        MySQLRentalDAO getAll = new MySQLRentalDAO();
        List<Rental> rentals = getAll.getAllRentals();

        VBox rentalContainer = new VBox();
        rentalContainer.setSpacing(10); // Adjust spacing as needed

        for (Rental rental : rentals) {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("rent_Item.fxml"));
                HBox rentalItem = loader.load();

                rent_itemController itemController = loader.getController();
                itemController.initialize(
                        rental.getRentalId(),
                        rental.getMovie().getTitle(),
                        rental.getMovie().getGenre(),
                        rental.getMovie().getDuration(),
                        rental.getMovie().getAgeRating(),
                        rental.getRentalFee(),
                        rental.getRentalDate(),
                        rental.getReturnDate()
                );

                rentalContainer.getChildren().add(rentalItem);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        // Set the VBox as the content of the ScrollPane
        rentScroll.setContent(rentalContainer);
    }
    @FXML
    public void displayRentalsByCustomer(User username) {
        MySQLRentalDAO getAll = new MySQLRentalDAO();
        List<Rental> rentals = getAll.getRentalByCustomer(username);

        VBox rentalContainer = new VBox();
        rentalContainer.setSpacing(10); // Adjust spacing as needed

        for (Rental rental : rentals) {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("rent_Item.fxml"));
                HBox rentalItem = loader.load();

                rent_itemController itemController = loader.getController();
                itemController.initialize(
                        rental.getRentalId(),
                        rental.getMovie().getTitle(),
                        rental.getMovie().getGenre(),
                        rental.getMovie().getDuration(),
                        rental.getMovie().getAgeRating(),
                        rental.getRentalFee(),
                        rental.getRentalDate(),
                        rental.getReturnDate()
                );

                rentalContainer.getChildren().add(rentalItem);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        // Set the VBox as the content of the ScrollPane
        rentScroll.setContent(rentalContainer);
    }
}
