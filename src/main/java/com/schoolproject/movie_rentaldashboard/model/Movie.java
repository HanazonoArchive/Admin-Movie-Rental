package com.schoolproject.movie_rentaldashboard.model;

import java.util.List;
import java.sql.Blob;

public class Movie {
    private int movieId;
    private String title;
    private List<String> cast;
    private String genre;
    private int duration;
    private String ageRating;
    private String description;

    private Blob image;


    // Constructor
    public Movie(int movieId, String title, List<String> cast, String genre, int duration, String ageRating, String description, byte[] image) {
        this.movieId = movieId;
        this.title = title;
        this.cast = cast;
        this.genre = genre;
        this.duration = duration;
        this.ageRating = ageRating;
        this.description = description;
        this.image = image;
    }

    // Getters
    public int getMovieId() {
        return movieId;
    }

    public String getTitle() {
        return title;
    }

    public List<String> getCast() {
        return cast;
    }

    public String getGenre() {
        return genre;
    }

    public int getDuration() {
        return duration;
    }

    public String getAgeRating() {
        return ageRating;
    }

    public String getDescription() {
        return description;
    }

    // Setters
    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setCast(List<String> cast) {
        this.cast = cast;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public void setAgeRating(String ageRating) {
        this.ageRating = ageRating;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    // Display method
    public void displayInfo() {
        System.out.println("Movie ID: " + movieId);
        System.out.println("Title: " + title);
        System.out.println("Cast: " + String.join(", ", cast));
        System.out.println("Genre: " + genre);
        System.out.println("Duration: " + duration + " minutes");
        System.out.println("Age Rating: " + ageRating);
        System.out.println("Description: " + description);
    }

    public Blob getImage() {
        return image;
    }

    public void setImage(Blob image) {
        this.image = image;
    }

//    // Example usage
//    public static void main(String[] args) {
//        // Creating and displaying a movie
//        Movie movie1 = new Movie(
//                1,
//                "Inception",
//                List.of("Leonardo DiCaprio", "Joseph Gordon-Levitt", "Ellen Page"),
//                "Science Fiction",
//                148,
//                "PG-13",
//                "A mind-bending journey through dreams and reality."
//        );
//
//        movie1.displayInfo();
//    }
}
