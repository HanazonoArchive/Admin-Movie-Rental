package com.schoolproject.movie_rentaldashboard;

import com.schoolproject.movie_rentaldashboard.dao.mysql.MySQLMovieDAO;
import com.schoolproject.movie_rentaldashboard.model.Movie;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;

import java.io.IOException;
import java.util.List;

public class display_rentController {
    public HBox fantasy_content;
    public HBox anime_content;
    public HBox action_content;
    @FXML
    private AnchorPane rent_screen;

    public void setHomeDisplay_Rent(AnchorPane homeDisplay) {
        homeDisplay.getChildren().setAll(rent_screen);
        MySQLMovieDAO mySQLMovieDAO = new MySQLMovieDAO();

        List<Movie> fantasy_content_list = mySQLMovieDAO.getMoviesByGenre("Fantasy");
        List<Movie> anime_content_list = mySQLMovieDAO.getMoviesByGenre("Anime");
        List<Movie> action_content_list = mySQLMovieDAO.getMoviesByGenre("Action");

        generateMovieCards(fantasy_content_list, fantasy_content);
        generateMovieCards(anime_content_list, anime_content);
        generateMovieCards(action_content_list,action_content);
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
