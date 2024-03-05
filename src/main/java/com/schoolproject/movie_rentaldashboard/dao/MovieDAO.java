package com.schoolproject.movie_rentaldashboard.dao;

import com.schoolproject.movie_rentaldashboard.model.Movie;

public interface MovieDAO {
    Movie getMovieById(int movieId);
    boolean addMovie(Movie movie);
    boolean updateMovieDetails(Movie movie);
    // Add other methods as needed
}
