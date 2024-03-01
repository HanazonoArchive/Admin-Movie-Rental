package com.schoolproject.movie_rentaldashboard.model;

import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

public class MovieTestData {

    public static List<Movie> getTestMovies() {
        List<Movie> movies = new ArrayList<>();

        // Adding test movie data with base64-encoded image
        String base64Image = "";
        byte[] decodedImage = Base64.getDecoder().decode(base64Image);

        // Adding test movie data
        movies.add(new Movie(1, "Inception", List.of("Leonardo DiCaprio", "Joseph Gordon-Levitt", "Ellen Page"), "Science Fiction", 148, "PG-13", "A mind-bending journey through dreams and reality.", decodedImage));
        movies.add(new Movie(2, "The Dark Knight", List.of("Christian Bale", "Heath Ledger", "Aaron Eckhart"), "Action", 152, "PG-13", "The Joker wreaks havoc on Gotham City.", decodedImage));
        // Add more test movies as needed

        return movies;
    }
}
