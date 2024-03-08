package com.schoolproject.movie_rentaldashboard;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class TestCart {
    private int movieID;
    private String title;
    private String genre;
    private int duration;
    private String ageRating;
    private double price;


    public TestCart(int movieID, String title, String genre, int duration, String ageRating, double price) {
        this.movieID = movieID;
        this.title = title;
        this.genre = genre;
        this.duration = duration;
        this.ageRating = ageRating;
        this.price = price;
    }

    public int getMovieID() {
        return movieID;
    }

    public void setMovieID(int movieID) {
        this.movieID = movieID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getAgeRating() {
        return ageRating;
    }

    public void setAgeRating(String ageRating) {
        this.ageRating = ageRating;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}

