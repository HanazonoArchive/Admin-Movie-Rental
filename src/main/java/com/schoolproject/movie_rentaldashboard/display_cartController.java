package com.schoolproject.movie_rentaldashboard;

import com.schoolproject.movie_rentaldashboard.dao.mysql.MySQLRentalDAO;
import com.schoolproject.movie_rentaldashboard.model.Movie;
import com.schoolproject.movie_rentaldashboard.model.Rental;
import com.schoolproject.movie_rentaldashboard.model.ShoppingCart;
import com.schoolproject.movie_rentaldashboard.model.UserLogged;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import javax.swing.*;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

public class display_cartController implements Initializable {
    public VBox cartContent;
    ShoppingCart shoppingCart = ShoppingCart.getInstance();
    UserLogged userLogged = UserLogged.getInstance();
    @FXML
    private Button btnCancel;
    @FXML
    private Button btnCheckout;
    @FXML
    private AnchorPane cart_screen;
    @FXML
    private RadioButton ewallet;
    @FXML
    private RadioButton mastercard;
    @FXML
    private RadioButton visa;
    @FXML
    private ToggleGroup paymentToggleGroup;
    //    List<Movie> cartItems = shoppingCart.getItems();
    @FXML
    private HBox selectedHBox = null;

    public void setHomeDisplay_Cart(AnchorPane homeDisplay) {
        homeDisplay.getChildren().setAll(cart_screen);
    }


    private void checkout(ActionEvent actionEvent) {
        LocalDate rentalDate = LocalDate.now();
        LocalDate returnDate = rentalDate.plusDays(3);
        Date sqlRentalDate = Date.valueOf(rentalDate);
        Date sqlReturnDate = Date.valueOf(returnDate);
        System.out.println("Rental Date: " + rentalDate);
        System.out.println("Return Date: " + returnDate);
        MySQLRentalDAO mySQLRentalDAO = new MySQLRentalDAO();

        List<Movie> shoppingCartItems  = shoppingCart.getItemsCopy();
        // Check if a payment method is selected
        if (paymentToggleGroup.getSelectedToggle() == null) {
            // Display an error message or prompt the user to select a payment method
            displayErrorMessage("Payment Method Error", "Please select a payment method before proceeding with checkout.");
            return;
        }


        for (Movie movie : shoppingCartItems) {
            if (shoppingCart.isMovieSelected(movie)) {
                Rental rental = new Rental(userLogged.getCustomer(), movie, sqlRentalDate, sqlReturnDate, movie.getPrice());
                mySQLRentalDAO.addRental(rental);
                shoppingCart.popItem(movie);
                System.out.println("selected");
            } else {
                System.out.println("not selected");
            }
        }
        System.out.println("executed checkout() ");

        cartContent.getChildren().clear();
        generateCartItems();
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        paymentToggleGroup = new ToggleGroup();
        ewallet.setToggleGroup(paymentToggleGroup);
        mastercard.setToggleGroup(paymentToggleGroup);
        visa.setToggleGroup(paymentToggleGroup);
        generateCartItems();
        btnCheckout.setOnAction(this::checkout);
    }

    private void generateCartItems() {
        for (Movie movie : shoppingCart.getItems()) {
            try {
                if (movie != null) {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("cart_item.fxml"));
                    HBox cartItem = loader.load();

                    cart_itemController cartItemController = loader.getController();
                    cartItemController.initialize(
                            movie.getMovieId(),
                            movie.getTitle(),
                            movie.getGenre(),
                            String.valueOf(movie.getDuration()),
                            movie.getAgeRating(),
                            String.valueOf(movie.getPrice()),
                            movie
                    );
                    cartItem.getProperties().put("controller", cartItemController);

                    cartContent.getChildren().add(cartItem);
                } else {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("cart_item.fxml"));
                    HBox cartItem = loader.load();

                    cart_itemController cartItemController = loader.getController();
                    cartItemController.initialize("", "empty", "", "", "", "", movie);

                    cartItem.getProperties().put("controller", cartItemController);

                    cartContent.getChildren().add(cartItem);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    // Method to display an error message
    private void displayErrorMessage(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
