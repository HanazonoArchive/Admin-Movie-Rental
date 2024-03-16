package com.schoolproject.movie_rentaldashboard.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserRentals {
    private static final UserRentals instance = new UserRentals();
    private List<Rental> items;
    private Map<Rental, Boolean> selectedRentals; // Map to store the selected status for each movie

    private UserRentals() {
        items = new ArrayList<>();
        selectedRentals = new HashMap<>();
    }

    public static UserRentals getInstance() {
        return instance;
    }

    public void addItem(Rental rental) {
        items.add(rental);
        // Default selected status is false when adding a new movie
        selectedRentals.put(rental, true);
    }

    public List<Rental> getItems() {
        return items;
    }

    public List<Rental> getItemsCopy() {
        synchronized (items) { // Synchronize on the items list to ensure thread safety
            return new ArrayList<>(items); // Return a copy of the items list
        }
    }

    public boolean isRentalSelected(Rental rental) {
        return selectedRentals.getOrDefault(rental, false);
    }

    public void setRentalSelected(Rental rental, boolean selected) {
        selectedRentals.put(rental, selected);
    }

    public void popItem(Rental rental) {
        items.remove(rental);
        selectedRentals.remove(rental);
    }
}

