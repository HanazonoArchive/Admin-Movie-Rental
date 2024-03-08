package com.schoolproject.movie_rentaldashboard;
import com.schoolproject.movie_rentaldashboard.model.Movie;
import eu.hansolo.tilesfx.Test;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class display_cartController implements Initializable {
    @FXML
    private TableColumn<TestCart, Integer> CartRuntime;

    @FXML
    private Button btnCancel;

    @FXML
    private Button btnCheckout;

    @FXML
    private TableColumn<TestCart, String> cartAgeRating;

    @FXML
    private TableColumn<TestCart, String> cartGenre;

    @FXML
    private TableColumn<TestCart, Integer> cartMovieID;

    @FXML
    private TableColumn<TestCart, Double> cartPrice;

    @FXML
    private TableColumn<TestCart, String> cartTitle;

    @FXML
    private AnchorPane cart_screen;


    @FXML
    private RadioButton ewallet;

    @FXML
    private RadioButton mastercard;

    @FXML
    private RadioButton visa;

    @FXML
    private TableView<TestCart> orderTable;
    @FXML
    private ToggleGroup paymentToggleGroup;


    public void setHomeDisplay_Cart(AnchorPane homeDisplay) {
        homeDisplay.getChildren().setAll(cart_screen);
    }


    @FXML
    public void checkout(){
        int selectedID = orderTable.getSelectionModel().getSelectedIndex();
        orderTable.getItems().remove(selectedID);
    }
    public void initializeMOP() {
        paymentToggleGroup = new ToggleGroup();
        ewallet.setToggleGroup(paymentToggleGroup);
        mastercard.setToggleGroup(paymentToggleGroup);
        visa.setToggleGroup(paymentToggleGroup);
    }


    //make action event that if the user click add to cart the info on the cart will be added to the list
    ObservableList<TestCart> list = FXCollections.observableArrayList(
            new TestCart(1,"Title ni","Genre ni",145,"rating ni",75.00)
    );
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        cartMovieID.setCellValueFactory(new PropertyValueFactory<TestCart,Integer>("movieID"));
        cartTitle.setCellValueFactory(new PropertyValueFactory<TestCart,String>("title"));
        cartGenre.setCellValueFactory(new PropertyValueFactory<TestCart,String>("genre"));
        CartRuntime.setCellValueFactory(new PropertyValueFactory<TestCart,Integer>("duration"));
        cartAgeRating.setCellValueFactory(new PropertyValueFactory<TestCart,String>("ageRating"));
        cartPrice.setCellValueFactory(new PropertyValueFactory<TestCart,Double>("price"));
        orderTable.setItems(list);
    }
}
