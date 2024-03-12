package com.schoolproject.movie_rentaldashboard.model;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private static final ShoppingCart instance = new ShoppingCart();
    private List<Movie> items;

    private ShoppingCart() {
        items = new ArrayList<>();
    }

    public static ShoppingCart getInstance() {
        return instance;
    }

    public void addItem(Movie movie) {
        items.add(movie);
    }

    public List<Movie> getItems() {
        return items;
    }
}
