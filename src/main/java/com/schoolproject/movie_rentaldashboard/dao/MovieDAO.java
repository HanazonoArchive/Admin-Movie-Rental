package com.schoolproject.movie_rentaldashboard.dao;

import com.schoolproject.movie_rentaldashboard.model.Movie;

import java.util.List;

public interface MovieDAO {
    Movie getMovieById(String movieId);

    List<Movie> getAllMovies();

    boolean addMovie(Movie movie);

    List<Movie> getMoviesByGenre(String genre);

    List<Movie> searchMovies(String keyword);

    boolean deleteMovie(String movieId);

    boolean updateMovieDetails(Movie movie);

    boolean updateMovieStockQuantity(int movieId, int quantity);
    // Add other methods as needed
}
