package com.schoolproject.movie_rentaldashboard;

import com.schoolproject.movie_rentaldashboard.dao.mysql.MySQLMovieDAO;
import com.schoolproject.movie_rentaldashboard.model.Movie;
import com.schoolproject.movie_rentaldashboard.model.MovieTestData;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;

import java.io.IOException;
import java.util.List;

public class display_dashboardController {

    public HBox trending_content;
    public HBox trending_content1;
    @FXML
    private AnchorPane dashboard_screen;

    public void setHomeDisplay_Dashboard(AnchorPane homeDisplay) {
        homeDisplay.getChildren().setAll(dashboard_screen);

        List<Movie> moviesList = MovieTestData.getTestMovies();
        MySQLMovieDAO mySQLMovieDAO = new MySQLMovieDAO();
        List<Movie> moviesList2 = mySQLMovieDAO.getAllMovies();

        // Generate and display movie cards for different contents
        generateMovieCards(moviesList, trending_content);

        generateMovieCards(moviesList2, trending_content1);

    }
    private void generateMovieCards(List<Movie> movies, HBox container) {
        container.getChildren().clear();

        for (Movie movie : movies) {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("movie_card.fxml"));
                AnchorPane movieCard = loader.load();

                movie_cardController controller = loader.getController();
                controller.initialize(
                        movie.getTitle(),
                        movie.getImage(),
                        String.valueOf(movie.getYear()),
                        String.valueOf(movie.getDuration()),
                        String.valueOf(movie.getPrice()),
                        movie
                );

                container.getChildren().add(movieCard);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
