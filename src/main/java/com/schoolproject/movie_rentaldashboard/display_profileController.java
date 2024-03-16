package com.schoolproject.movie_rentaldashboard;

import com.schoolproject.movie_rentaldashboard.dao.CustomerDAO;
import com.schoolproject.movie_rentaldashboard.dao.RentalDAO;
import com.schoolproject.movie_rentaldashboard.dao.mysql.MySQLCustomerDAO;
import com.schoolproject.movie_rentaldashboard.dao.mysql.MySQLRentalDAO;

import com.schoolproject.movie_rentaldashboard.model.*;
import javafx.event.ActionEvent;

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
    public VBox rentContent;
    @FXML
    private TextArea basicTextField;

    @FXML
    private TextArea contactTextField;

    @FXML
    private AnchorPane profile_display;
    @FXML
    private Button returnButton;
    @FXML
    private ScrollPane rentScroll;

    UserLogged userLogged = UserLogged.getInstance();

    UserRentals userRentals = UserRentals.getInstance();


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


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        displayRentals();
        returnButton.setOnAction(this::returnMovie);
    }

    private void returnMovie(ActionEvent actionEvent) {


        List<Rental> selectedRentals = userRentals.getInstance().getItemsCopy();

        for (Rental rental : selectedRentals) {
            System.out.println("inside looop");
            if (userRentals.isRentalSelected(rental)) {
                System.out.println("inside true loop");
                MySQLRentalDAO mySQLRentalDAO = new MySQLRentalDAO();
                mySQLRentalDAO.updateRentalReturnStatus(rental,true);

                userRentals.popItem(rental);
                System.out.println("selected popepd");
            } else {
                System.out.println("not selected");
            }
        }

        System.out.println("executed return() ");

        rentContent.getChildren().clear();
        displayRentals();
    }

    @FXML
    public void displayRentals() {
        MySQLRentalDAO getAll = new MySQLRentalDAO();
        List<Rental> rentals = getAll.getAllRentalsbyCustomerId(userLogged.getCustomer().getCustomerId());


        rentContent.setSpacing(10); // Adjust spacing as needed

        for (Rental rental : rentals) {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("rent_Item.fxml"));
                HBox rentalItem = loader.load();

                rent_itemController itemController = loader.getController();
                itemController.initialize(

                        rental.getMovie().getTitle(),
                        rental.getMovie().getGenre(),
                        rental.getMovie().getDuration(),
                        rental.getMovie().getAgeRating(),
                        rental.getRentalFee(),
                        rental.getRentalDate(),
                        rental.getReturnDate(),
                        rental.isReturned(),
                        rental
                );

                rentContent.getChildren().add(rentalItem);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

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
