package com.schoolproject.movie_rentaldashboard;
import com.schoolproject.movie_rentaldashboard.model.Movie;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

public class display_cartController {
    @FXML
    private TableColumn<Movie, Integer> CartRuntime;

    @FXML
    private Button btnCancel;

    @FXML
    private Button btnCheckout;

    @FXML
    private TableColumn<Movie, String> cartAgeRating;

    @FXML
    private TableColumn<Movie, String> cartGenre;

    @FXML
    private TableColumn<Movie, Integer> cartMovieID;

    @FXML
    private TableColumn<Movie, Double> cartPrice;

    @FXML
    private TableColumn<Movie, String> cartTitle;

    @FXML
    private AnchorPane cart_screen;

    //@FXML
    //private TableView<?> orderTable;
    //@FXML
    //private AnchorPane cart_screen;
    @FXML
    private RadioButton ewallet;

    @FXML
    private RadioButton mastercard;

    @FXML
    private RadioButton visa;

    @FXML
    private TableView<Movie> orderTable;
    @FXML
    private ToggleGroup paymentToggleGroup;

    // Method to initialize the TableView
    /*public void initialize() {

        cartMovieID.setCellValueFactory(new PropertyValueFactory<Movie,Integer>("movieId"));

        cartTitle.setCellValueFactory(new PropertyValueFactory<Movie, String>("title"));

        cartGenre.setCellValueFactory(new PropertyValueFactory<Movie, String>("genre"));

        CartRuntime.setCellValueFactory(new PropertyValueFactory<Movie,Integer>("duration"));

        cartAgeRating.setCellValueFactory(new PropertyValueFactory<Movie, String>("ageRating"));

        cartPrice.setCellValueFactory(new PropertyValueFactory<Movie, Double>("price"));

        orderTable.getColumns().addAll(cartMovieID, cartTitle, cartGenre, CartRuntime,cartAgeRating,cartPrice);
    }*/

    public void setHomeDisplay_Cart(AnchorPane homeDisplay) {
        homeDisplay.getChildren().setAll(cart_screen);
    }

    /*public void setCartInfo(Movie movieToAdd) {
        Movie movie = new Movie(Integer.parseInt(cartMovieID.getText()),cartTitle.getText(),cartGenre.getText(),Integer.parseInt(CartRuntime.getText()),cartAgeRating.getText(),Double.parseDouble(cartPrice.getText()));

        ObservableList<Movie> items = orderTable.getItems();
        items.add(movieToAdd);
        orderTable.setItems(items);
    }*/
    @FXML
    public void checkout(){
        /*int selectedID = orderTable.getSelectionModel().getSelectedIndex();
        orderTable.getItems().remove(selectedID);*/
    }
    public void initialize() {
        paymentToggleGroup = new ToggleGroup();
        ewallet.setToggleGroup(paymentToggleGroup);
        mastercard.setToggleGroup(paymentToggleGroup);
        visa.setToggleGroup(paymentToggleGroup);
    }
}
