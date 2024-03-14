package com.schoolproject.movie_rentaldashboard;
import com.schoolproject.movie_rentaldashboard.model.Movie;
import com.schoolproject.movie_rentaldashboard.model.ShoppingCart;
import com.schoolproject.movie_rentaldashboard.model.UserLogged;
import eu.hansolo.tilesfx.Test;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

public class display_cartController implements Initializable {
    public VBox cartContent;
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
    @FXML
    private HBox selectedHBox = null;


    ShoppingCart shoppingCart = ShoppingCart.getInstance();
//    List<Movie> cartItems = shoppingCart.getItems();

    UserLogged userLogged = UserLogged.getInstance();


    public void setHomeDisplay_Cart(AnchorPane homeDisplay) {
        homeDisplay.getChildren().setAll(cart_screen);
    }


    @FXML
    public void checkout() {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        paymentToggleGroup = new ToggleGroup();
        ewallet.setToggleGroup(paymentToggleGroup);
        mastercard.setToggleGroup(paymentToggleGroup);
        visa.setToggleGroup(paymentToggleGroup);
        generateCartItems();
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
                    String.valueOf(movie.getPrice())
                    );
                    cartItem.getProperties().put("controller", cartItemController);

                    cartContent.getChildren().add(cartItem);
                } else {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("cart_item.fxml"));
                    HBox cartItem = loader.load();

                    cart_itemController cartItemController = loader.getController();
                    cartItemController.initialize("", "empty", "" ,"", "","");

                    cartItem.getProperties().put("controller", cartItemController);

                    cartContent.getChildren().add(cartItem);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        }
}
