package com.schoolproject.movie_rentaldashboard;
import com.schoolproject.movie_rentaldashboard.model.Movie;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

public class display_cartController {

    @FXML
    private AnchorPane cart_screen;

    @FXML
    private TableView<Movie> orderTable;

    // Method to initialize the TableView
    public void initialize() {
        TableColumn<Movie, Integer> movieIdColumn = new TableColumn<>("Movie ID");
        movieIdColumn.setCellValueFactory(new PropertyValueFactory<>("movieId"));

        TableColumn<Movie, String> titleColumn = new TableColumn<>("Title");
        titleColumn.setCellValueFactory(new PropertyValueFactory<>("title"));

        TableColumn<Movie, String> genreColumn = new TableColumn<>("Genre");
        genreColumn.setCellValueFactory(new PropertyValueFactory<>("genre"));

        TableColumn<Movie, String> runtimeColumn = new TableColumn<>("Runtime");
        genreColumn.setCellValueFactory(new PropertyValueFactory<>("runtime"));

        TableColumn<Movie, String> ageRatingColumn = new TableColumn<>("Age Rating");
        genreColumn.setCellValueFactory(new PropertyValueFactory<>("ageRating"));

        TableColumn<Movie, Double> priceColumn = new TableColumn<>("Price");
        priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));

        orderTable.getColumns().addAll(movieIdColumn, titleColumn, genreColumn, runtimeColumn,ageRatingColumn,priceColumn);
    }

    public void setHomeDisplay_Cart(AnchorPane homeDisplay) {
        homeDisplay.getChildren().setAll(cart_screen);
    }

    public void setCartInfo(Movie movieToAdd) {
        ObservableList<Movie> items = orderTable.getItems();
        items.add(movieToAdd);
    }
}
