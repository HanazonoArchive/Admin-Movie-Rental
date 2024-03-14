package com.schoolproject.movie_rentaldashboard.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShoppingCart {
    private static final ShoppingCart instance = new ShoppingCart();
    private List<Movie> items;
    private Map<Movie, Boolean> selectedMovies; // Map to store the selected status for each movie

    private ShoppingCart() {
        items = new ArrayList<>();
        selectedMovies = new HashMap<>();
    }

    public static ShoppingCart getInstance() {
        return instance;
    }

    public void addItem(Movie movie) {
        items.add(movie);
        // Default selected status is false when adding a new movie
        selectedMovies.put(movie, false);
    }

    public List<Movie> getItems() {
        return items;
    }

    public List<Movie> getItemsCopy() {
        synchronized (items) { // Synchronize on the items list to ensure thread safety
            return new ArrayList<>(items); // Return a copy of the items list
        }
    }

    public boolean isMovieSelected(Movie movie) {
        return selectedMovies.getOrDefault(movie, false);
    }

    public void setMovieSelected(Movie movie, boolean selected) {
        selectedMovies.put(movie, selected);
    }

    public void popItem(Movie movie) {
        items.remove(movie);
        selectedMovies.remove(movie);
    }


}
