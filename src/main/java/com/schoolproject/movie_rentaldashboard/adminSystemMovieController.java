package com.schoolproject.movie_rentaldashboard;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;

import javax.swing.text.html.ImageView;
import java.net.URL;
import java.util.ResourceBundle;

public class adminSystemMovieController implements Initializable {

    String log;

    @FXML
    private Button Delete_button;

//    @FXML
//    private TableView<?> MovieTable;

    @FXML
    private Button Select_button;

    @FXML
    private Button Submit_button;

    @FXML
    private DatePicker dpDate;

    @FXML
    private Label fileStatus;

    @FXML
    private ListView<String> lvGenre;

    @FXML
    private TextArea taDescription;

    @FXML
    private TextField tfCast;

    @FXML
    private TextField tfMovieID;

    @FXML
    private TextField tfRuntime;

    @FXML
    private TextField tfTitle;

    public void HandleClicks(MouseEvent event) {
        if (event.getSource() == Submit_button){
            // Logger
            log = "Action: Button Clicked -> ID: Submit_button -> Class: adminSystemMovieController.java Type: Controller";
            printLog(log);

            // Functions
            int Movie_ID = Integer.parseInt(tfMovieID.getText());
            String Title = tfTitle.getText();
            String Cast = tfCast.getText();
            String Genre;

        } else if (event.getSource() == Delete_button) {
            // Logger
            log = "Action: Button Clicked -> ID: Delete_button -> Class: adminSystemMovieController.java Type: Controller";
            printLog(log);
        } else if (event.getSource() == Select_button){
            // Logger
            log = "Action: Button Clicked -> ID: Select_button -> Class: adminSystemMovieController.java Type: Controller";
            printLog(log);
        }
    }

    private void printLog(String log) {
        System.out.println(log);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        String[] ListofGenre = {"Action", "Comedy", "Drama", "Thriller", "Horror", "Science Fiction", "Fantasy", "Romance", "Adventure", "Mystery", "Crime", "Animation", "Family", "Biography", "Documentary", "Musical", "War", "Western", "Anime"};
        lvGenre.getItems().addAll(ListofGenre);
    }
}
