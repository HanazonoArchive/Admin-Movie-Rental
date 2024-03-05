package com.schoolproject.movie_rentaldashboard.model;

import java.util.List;

/**
 * Represents a Movie in the movie rental system.
 */
public class Movie {
    // Root directory for the movie images
    String appDirRoot = "/com/schoolproject/movie_rentaldashboard/";

    // Attributes or properties
    private int movieId;
    private String title;
    private List<String> cast;
    private String genre;
    private int duration;
    private String ageRating;
    private String description;

    private String image;

    private double price;
    private int year;

    /**
     * Constructs a Movie with specified attributes.
     *
     * @param movieId     The unique identifier for the movie.
     * @param title       The title of the movie.
     * @param cast        The list of cast members in the movie.
     * @param genre       The genre of the movie.
     * @param duration    The duration of the movie in minutes.
     * @param ageRating   The age rating of the movie.
     * @param description The description or summary of the movie.
     * @param image       The image file name associated with the movie.
     * @param price       The rental price of the movie.
     * @param year        The release year of the movie.
     */
    public Movie(int movieId, String title, List<String> cast, String genre, int duration, String ageRating, String description, String image, double price, int year) {
        this.movieId = movieId;
        this.title = title;
        this.cast = cast;
        this.genre = genre;
        this.duration = duration;
        this.ageRating = ageRating;
        this.description = description;
        this.image = image;
        this.price = price;
        this.year = year;
    }
    public Movie(int movieId, String title, String genre, int duration, String ageRating, double price) {
        this.movieId = movieId;
        this.title = title;
       // this.cast = cast;
        this.genre = genre;
        this.duration = duration;
        this.ageRating = ageRating;
        //this.description = description;
        //this.image = image;
        this.price = price;
        //this.year = year;
    }

    // getters and setters

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<String> getCast() {
        return cast;
    }

    public void setCast(List<String> cast) {
        this.cast = cast;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return appDirRoot + image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "appDirRoot='" + appDirRoot + '\'' +
                ", movieId=" + movieId +
                ", title='" + title + '\'' +
                ", cast=" + cast +
                ", genre='" + genre + '\'' +
                ", duration=" + duration +
                ", ageRating='" + ageRating + '\'' +
                ", description='" + description + '\'' +
                ", image='" + image + '\'' +
                ", price=" + price +
                ", year=" + year +
                '}';
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
        System.out.println("Image: " + image);
        System.out.println("Price: " + price);
        System.out.println("Year: " + year);
    }
}

