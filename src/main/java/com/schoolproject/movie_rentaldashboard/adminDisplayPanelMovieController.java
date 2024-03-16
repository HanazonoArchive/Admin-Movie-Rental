package com.schoolproject.movie_rentaldashboard;

import com.schoolproject.movie_rentaldashboard.dao.mysql.MySQLLogsDAO;
import com.schoolproject.movie_rentaldashboard.model.Logs;
import com.schoolproject.movie_rentaldashboard.model.UserLogged;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

import java.io.File;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ResourceBundle;

import com.schoolproject.movie_rentaldashboard.dao.mysql.MySQLMovieDAO;
import com.schoolproject.movie_rentaldashboard.model.Movie;
import javafx.stage.FileChooser;

import javax.swing.*;

public class adminDisplayPanelMovieController implements Initializable {

    File SelectedPhotos;

    public static String log;

    @FXML
    private AnchorPane display_panel;

    public void setScreenDisplay(AnchorPane homeDisplay) {
        homeDisplay.getChildren().setAll(display_panel);
    }

    @FXML
    private Button Delete_Button;

    @FXML
    private Label FileStatus;

    @FXML
    private Button SelectPNG_Button;

    @FXML
    private Button Submit_Button;

    @FXML
    private TextField dpDate;

    @FXML
    private ListView<String> lvGenre;

    @FXML
    private TextArea taDescription;

    @FXML
    private TextField tfAgeRestrictions;

    @FXML
    private TextField tfCast;

    @FXML
    private TextField tfPrice;

    @FXML
    private TextField tfRuntime;

    @FXML
    private TextField tfTitle;

    // Table
    @FXML
    private TableView<Movie> MovieTable;

    @FXML
    private TableColumn<Movie, String> colMovieID;

    @FXML
    private TableColumn<Movie, String> colMovieTitle;

    @FXML
    private TableColumn<Movie, String> colMovieCast;

    @FXML
    private TableColumn<Movie, String> colMovieGenre;

    @FXML
    private TableColumn<Movie, String> colMovieDuration;

    @FXML
    private TableColumn<Movie, String> colAgeRating;

    @FXML
    private TableColumn<Movie, String> colMovieDescription;

    @FXML
    private TableColumn<Movie, String> colMovieImage;

    @FXML
    private TableColumn<Movie, String> colMoviePrice;

    @FXML
    private TableColumn<Movie, String> colMovieYear;

    @FXML
    private TableColumn<Movie, String> colAverageRating;

    @FXML
    private TableColumn<Movie, String> colTotalRating;

    @FXML
    private TableColumn<Movie, String> colAvailable;

    @FXML
    private TableColumn<Movie, String> stockQuantity;




    public void HandlesClicks(javafx.event.ActionEvent event) {
        if (event.getSource() == Submit_Button){
            addMoviesToSQL();
        } else if (event.getSource() == Delete_Button) {
            removeMovieFromSQL();
        } else if (event.getSource() == SelectPNG_Button) {
            //Logger
            log = "Action: Clicked -> ID: SelectPNG_Button -> Class: adminDisplayPanelMovieController -> Status: Success";
            PrintLog(log);
            SelectPhotos();
        } else {
            //Logger
            log = "Action: Clicked -> ID: Else -> Class: adminDisplayPanelMovieController -> Status: Failed";
            PrintLog(log);
        }
    }

    private static void PrintLog(String log) {
        System.out.println(log);
    }

    @Override
    //initializa
    public void initialize(URL location, ResourceBundle resources) {
        // Genre Related Functions
        String[] genre = {"Action", "Comedy", "Drama", "Thriller", "Horror", "Science Fiction", "Fantasy", "Romance", "Adventure", "Mystery", "Crime", "Animation", "Family", "Biography", "Documentary", "Musical", "War", "Western"};
        lvGenre.getItems().addAll(genre);
        lvGenre.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        colMovieID.setCellValueFactory(cellData -> {
            int movieId = Integer.parseInt(cellData.getValue().getMovieId());
            String formattedMovieId = String.format("%06d", movieId);
            return new SimpleStringProperty(formattedMovieId);
        });
        colMovieTitle.setCellValueFactory(new PropertyValueFactory<>("title"));
        colMovieCast.setCellValueFactory(new PropertyValueFactory<>("cast"));
        colMovieGenre.setCellValueFactory(new PropertyValueFactory<>("genre"));
        colMovieDuration.setCellValueFactory(new PropertyValueFactory<>("duration"));
        colAgeRating.setCellValueFactory(new PropertyValueFactory<>("ageRating"));
        colMovieDescription.setCellValueFactory(new PropertyValueFactory<>("description"));
        colMovieImage.setCellValueFactory(new PropertyValueFactory<>("image"));
        colMoviePrice.setCellValueFactory(new PropertyValueFactory<>("price"));
        colMovieYear.setCellValueFactory(new PropertyValueFactory<>("year"));
        colAverageRating.setCellValueFactory(new PropertyValueFactory<>("averageRating"));
        colTotalRating.setCellValueFactory(new PropertyValueFactory<>("totalRatings"));
        colAvailable.setCellValueFactory(new PropertyValueFactory<>("available"));
        stockQuantity.setCellValueFactory(new PropertyValueFactory<>("stockQuantity"));

        //display movies
        displayMovies();
    }
    public void displayMovies() {
        MySQLMovieDAO e = new MySQLMovieDAO();
        List<Movie> movieListData = e.getAllMovies();
        ObservableList<Movie> movieObservableList = FXCollections.observableList(movieListData);
        MovieTable.setItems(movieObservableList);
    }

    public void addMoviesToSQL(){
        //Logger
        log = "Action: Clicked -> ID: Submit_Button -> Class: adminDisplayPanelMovieController -> Status: Success";
        PrintLog(log);

        //Functions Genre Selection
        ObservableList<String> selectedItems = lvGenre.getSelectionModel().getSelectedItems();
        String selectedGenres = String.join(",", selectedItems);
        //Genre Selection Logger
        log = "Selection: Picked -> ID: lvGenre -> Class: adminDisplayPanelMovieController -> Status: Success";
        PrintLog(log);

        //Cast
        String movieCastString = tfCast.getText();
        String[] movieCastArr = movieCastString.split(",");
        List<String> movieCast = new ArrayList<>();
        Collections.addAll(movieCast, movieCastArr);

        //Variables
        String movieTitle = tfTitle.getText();
        String movieGenre = selectedGenres;
        String movieDuration = tfRuntime.getText();
        String ageRating = tfAgeRestrictions.getText();
        String movieDescription = taDescription.getText();
        String movieImage = "image.png";
        String moviePrice = tfPrice.getText();
        String movieYear = dpDate.getText();

        Movie newMovie = new Movie(movieTitle, movieCast, movieGenre, Integer.parseInt(movieDuration),
                ageRating, movieDescription, movieImage, Double.parseDouble(moviePrice),
                Integer.parseInt(movieYear));

        // Check if Empty or not
        if (!movieTitle.isEmpty() && !movieCast.isEmpty() && !movieDuration.isEmpty() && !ageRating.isEmpty() && !movieDescription.isEmpty() && !movieYear.isEmpty() && !lvGenre.getSelectionModel().getSelectedItems().isEmpty()) {
            //add movie to database
            MySQLMovieDAO e = new MySQLMovieDAO();
            e.addMovie(newMovie);

            // Clear input
            tfTitle.clear();
            tfCast.clear();
            tfRuntime.clear();
            tfAgeRestrictions.clear();
            dpDate.clear();
            tfPrice.clear();
            taDescription.clear();
            lvGenre.getSelectionModel().clearSelection();

            // Logger
            log = "Added successfully";
            PrintLog(log);
            //add movie log entry
            MySQLLogsDAO logger = new MySQLLogsDAO();
            String currentUser = "admin";

            LocalDateTime now = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            String formattedDateTime = now.format(formatter);
            Logs log = new Logs(formattedDateTime, "admin", currentUser, "add", currentUser + " added new movie - movieTitle: " + newMovie.getTitle());
            logger.addLog(log);

            displayMovies();
        } else {
            System.err.println("Error: NOT FILLED BLANKS");
        }
    }
    public void removeMovieFromSQL(){
        // Get the selected movie from the TableView
        Movie selectedMovie = MovieTable.getSelectionModel().getSelectedItem();

        if (selectedMovie != null) {

            int confirmation = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this movie?", "Confirmation", JOptionPane.YES_NO_OPTION);

            if (confirmation == JOptionPane.YES_OPTION) {
                // User confirmed, proceed with deletion
                MySQLMovieDAO e = new MySQLMovieDAO();
                String movieID = selectedMovie.getMovieId();
                e.deleteMovie(movieID);
                displayMovies();
                // Log the deletion
                log = "Action: Deleted Movie -> ID: " + selectedMovie.getMovieId() + " -> Title: " + selectedMovie.getTitle();
                PrintLog(log);
                // movie deletion log entry
                MySQLLogsDAO logger = new MySQLLogsDAO();
                String currentUser = "admin";

                LocalDateTime now = LocalDateTime.now();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                String formattedDateTime = now.format(formatter);
                Logs log = new Logs(formattedDateTime, "admin", currentUser, "delete", currentUser + " removed movie - movieTitle: " + selectedMovie.getTitle() + " movieId: " + selectedMovie.getMovieId());
                logger.addLog(log);
            } else {
                // User canceled the deletion
                System.out.println("Deletion canceled.");
            }
        } else {
            // If no movie is selected, show an error message
            System.err.println("Error: No movie selected for deletion");
        }
    }

    public void SelectPhotos() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg"));

        SelectedPhotos = fileChooser.showOpenDialog(null);
        if (SelectedPhotos != null) {

            String filePath = SelectedPhotos.getAbsolutePath();
            FileStatus.setText("Selected file: " + filePath);

            //Logger
            log = "Action: Selected Photo -> File: " + filePath + " -> Class: adminDisplayPanelMovieController -> Status: Success";
            PrintLog(log);
        } else {
            System.out.println("File selection canceled.");
            //Logger
            log = "Action: Canceled Photo Selection -> Class: adminDisplayPanelMovieController -> Status: Success";
            PrintLog(log);
        }
    }

}
