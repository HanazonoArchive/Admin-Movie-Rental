package com.schoolproject.movie_rentaldashboard.dao;

import com.schoolproject.movie_rentaldashboard.model.Movie;

import java.util.List;

public interface MovieDAO {
    Movie getMovieById(String movieId);

    List<Movie> getAllMovies();

    boolean addMovie(Movie movie);

    boolean deleteMovie(String movieId);

    boolean updateMovieDetails(Movie movie);
    // Add other methods as needed
}
