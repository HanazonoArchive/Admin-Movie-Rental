package com.schoolproject.movie_rentaldashboard;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

public class adminDisplayPanelMovieController implements Initializable {

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
    private DatePicker dpDate;

    @FXML
    private ListView<String> lvGenre;

    @FXML
    private TextArea taDescription;

    @FXML
    private TextField tfAgeRestrictions;

    @FXML
    private TextField tfCast;

    @FXML
    private TextField tfMovieID;

    @FXML
    private TextField tfRuntime;

    @FXML
    private TextField tfTitle;

    // Table
    @FXML
    private TableView<MovieClass> MovieTable;
    private ObservableList<MovieClass> movieList = FXCollections.observableArrayList();

    @FXML
    private TableColumn<MovieClass, String> colMovieID;

    @FXML
    private TableColumn<MovieClass, String> colMovieTitle;

    @FXML
    private TableColumn<MovieClass, String> colMovieCast;

    @FXML
    private TableColumn<MovieClass, String> colMovieRuntime;

    @FXML
    private TableColumn<MovieClass, String> colAgeRestriction;

    @FXML
    private TableColumn<MovieClass, String> colMovieDate;

    @FXML
    private TableColumn<MovieClass, String> colMovieDescription;

    @FXML
    private TableColumn<MovieClass, String> colMovieGenre;


    public void HandlesClicks(javafx.event.ActionEvent event) {
        if (event.getSource() == Submit_Button){
            addMoviesToTable();
        } else if (event.getSource() == Delete_Button) {
            deleteMoviesToTable();
        } else if (event.getSource() == SelectPNG_Button) {
            //Logger
            log = "Action: Clicked -> ID: SelectPNG_Button -> Class: adminDisplayPanelMovieController -> Status: Success";
            PrintLog(log);

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
    public void initialize(URL location, ResourceBundle resources) {
        String[] genre = {"Action", "Comedy", "Drama", "Thriller", "Horror", "Science Fiction", "Fantasy", "Romance", "Adventure", "Mystery", "Crime", "Animation", "Family", "Biography", "Documentary", "Musical", "War", "Western"};
        lvGenre.getItems().addAll(genre);
        lvGenre.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        colMovieID.setCellValueFactory(new PropertyValueFactory<>("movieID"));
        colMovieTitle.setCellValueFactory(new PropertyValueFactory<>("movieTitle"));
        colMovieCast.setCellValueFactory(new PropertyValueFactory<>("movieCast"));
        colMovieGenre.setCellValueFactory(new PropertyValueFactory<>("genres"));
        colMovieRuntime.setCellValueFactory(new PropertyValueFactory<>("movieRuntime"));
        colAgeRestriction.setCellValueFactory(new PropertyValueFactory<>("ageRestriction"));
        colMovieDate.setCellValueFactory(new PropertyValueFactory<>("movieDate"));
        colMovieDescription.setCellValueFactory(new PropertyValueFactory<>("movieDescription"));
    }

    public void addMoviesToTable(){
        //Logger
        log = "Action: Clicked -> ID: Submit_Button -> Class: adminDisplayPanelMovieController -> Status: Success";
        PrintLog(log);

        //Functions Genre Selection
        ObservableList<String> selectedItems = lvGenre.getSelectionModel().getSelectedItems();
        String selectedGenres = String.join(", ", selectedItems);
        //Genre Selection Logger
        log = "Selection: Picked -> ID: lvGenre -> Class: adminDisplayPanelMovieController -> Status: Success";
        PrintLog(log);

        //Functions Others TextField
        String Movie_ID = tfMovieID.getText();
        String Movie_Title = tfTitle.getText();
        String Movie_Cast  = tfCast.getText();
        String Movie_Genre = selectedGenres;
        String Movie_Runtime = tfRuntime.getText();
        String Age_Restriction = tfAgeRestrictions.getText();
        String Movie_Date = dpDate.getValue() != null ? dpDate.getValue().toString() : "";
        String Movie_Description = taDescription.getText();

        // Check if Empty or not
        if (!Movie_ID.isEmpty() && !Movie_Title.isEmpty() && !Movie_Cast.isEmpty() && !Movie_Runtime.isEmpty() && !Age_Restriction.isEmpty() && dpDate.getValue() != null && !Movie_Date.isEmpty() && !lvGenre.getSelectionModel().getSelectedItems().isEmpty()) {
            // Adding The Movie to the Panel
            MovieClass addMovie = new MovieClass(Movie_ID, Movie_Title, Movie_Cast, Movie_Genre, Movie_Runtime, Age_Restriction, Movie_Date, Movie_Description);
            movieList.add(addMovie);
            MovieTable.getItems().add(addMovie);

            // Clearing the TextField and etc...
            tfMovieID.clear();
            tfTitle.clear();
            tfCast.clear();
            tfRuntime.clear();
            tfAgeRestrictions.clear();
            dpDate.setValue(null);
            taDescription.clear();
            lvGenre.getSelectionModel().clearSelection();

            // Logger
            log = "Added:\n" +
                    "Movie ID: " + Movie_ID + "\n" +
                    "Title: " + Movie_Title + "\n" +
                    "Cast: " + Movie_Cast + "\n" +
                    "Genre: " + Movie_Genre + "\n" +
                    "Runtime: " + Movie_Runtime + "\n" +
                    "Age Restriction: " + Age_Restriction + "\n" +
                    "Release Date: " + Movie_Date + "\n" +
                    "Description: " + Movie_Description;
            PrintLog(log);


        } else {
            System.err.println("Error: NOT FILLED BLANKS");
        }
    }

    public void deleteMoviesToTable(){
        // Get the selected movie from the TableView
        MovieClass selectedMovie = MovieTable.getSelectionModel().getSelectedItem();

        if (selectedMovie != null) {
            // Remove the selected movie from the TableView and the movieList
            MovieTable.getItems().remove(selectedMovie);
            movieList.remove(selectedMovie);

            // Log the deletion
            log = "Action: Deleted Movie -> ID: " + selectedMovie.getMovieID() + " -> Title: " + selectedMovie.getMovieTitle();
            PrintLog(log);
        } else {
            // If no movie is selected, show an error message
            System.err.println("Error: No movie selected for deletion");
        }
    }
}
