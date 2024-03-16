package com.schoolproject.movie_rentaldashboard.model;

import java.util.List;

/**
 * Represents a Movie in the movie rental system.
 */
public class Movie {
    // Root directory for the movie images
    String appDirRoot = "/com/schoolproject/movie_rentaldashboard/movieImageResources/";

    // Attributes or properties
    private String movieId;
    private String title;
    private List<String> cast;
    private String genre;
    private int duration;
    private String ageRating;
    private String description;

    private String image;

    private double price;
    private int year;

    // Additional properties for popularity tracking
    private double averageRating;
    private int totalRatings;
    private boolean available;
    private int stockQuantity;

    /**
     * Constructs a Movie with specified attributes.
     *
     * @param movieId       The unique identifier for the movie.
     * @param title         The title of the movie.
     * @param cast          The list of cast members in the movie.
     * @param genre         The genre of the movie.
     * @param duration      The duration of the movie in minutes.
     * @param ageRating     The age rating of the movie.
     * @param description   The description or summary of the movie.
     * @param image         The image file name associated with the movie.
     * @param price         The rental price of the movie.
     * @param year          The release year of the movie.
     * @param averageRating The average rating of the movie.
     * @param totalRatings  The total number of ratings for the movie.
     * @param available     The availability status of the movie.
     * @param stockQuantity The stock quantity of the movie.
     */
    public Movie(String movieId, String title, List<String> cast, String genre, int duration, String ageRating, String description, String image, double price, int year,
                 double averageRating, int totalRatings, boolean available, int stockQuantity) {
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
        this.averageRating = averageRating;
        this.totalRatings = totalRatings;
        this.available = available;
        this.stockQuantity = stockQuantity;
    }

    public Movie(String title, List<String> cast, String genre, int duration, String ageRating, String description, String image, double price, int year) {
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
    /**
     * Constructs a Movie with specified attributes.
     *
     * @param movieId       The unique identifier for the movie.
     * @param title         The title of the movie.
     * @param cast          The list of cast members in the movie.
     * @param genre         The genre of the movie.
     * @param duration      The duration of the movie in minutes.
     * @param ageRating     The age rating of the movie.
     * @param description   The description or summary of the movie.
     * @param image         The image file name associated with the movie.
     * @param price         The rental price of the movie.
     * @param year          The release year of the movie.
     * @param averageRating The average rating of the movie.
     * @param totalRatings  The total number of ratings for the movie.
     * @param available     The availability status of the movie.
     * @param stockQuantity The stock quantity of the movie.
     */
    public Movie(int movieId, String title, List<String> cast, String genre, int duration, String ageRating, String description, String image, double price, int year,
                 double averageRating, int totalRatings, boolean available, int stockQuantity) {
        String.format("%0" + 6 + "d", movieId);
        this.movieId = String.format("%0" + 6 + "d", movieId);
        this.title = title;
        this.cast = cast;
        this.genre = genre;
        this.duration = duration;
        this.ageRating = ageRating;
        this.description = description;
        this.image = image;
        this.price = price;
        this.year = year;
        this.averageRating = averageRating;
        this.totalRatings = totalRatings;
        this.available = available;
        this.stockQuantity = stockQuantity;
    }

    /**
     /**
     * Constructs a Movie with specified attributes.
     *
     * @param movieId       The unique identifier for the movie.
     * @param title         The title of the movie.
//     * @param cast          The list of cast members in the movie.
     * @param genre         The genre of the movie.
     * @param duration      The duration of the movie in minutes.
     * @param ageRating     The age rating of the movie.
//     * @param description   The description or summary of the movie.
//     * @param image         The image file name associated with the movie.
     * @param price         The rental price of the movie.
//     * @param year          The release year of the movie.
//     * @param averageRating The average rating of the movie.
//     * @param totalRatings  The total number of ratings for the movie.
//     * @param available     The availability status of the movie.
//     * @param stockQuantity The stock quantity of the movie.
     */
    public Movie(String movieId, String title, String genre, int duration, String ageRating, double price) {
        this.movieId = movieId;
        this.title = title;
//        this.cast = cast;
        this.genre = genre;
        this.duration = duration;
        this.ageRating = ageRating;
//        this.image = image;
        this.price = price;
//        this.year = year;
        this.averageRating = averageRating;
//        this.totalRatings = totalRatings;
//        this.available = available;
//        this.stockQuantity = stockQuantity;
    }

    public Movie() {
        
    }

    // getters and setters

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getMovieId() {
        return movieId;
    }

    public void setMovieId(String movieId) {
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

    public double getAverageRating() {
        return averageRating;
    }

    public void setAverageRating(double averageRating) {
        this.averageRating = averageRating;
    }

    public int getTotalRatings() {
        return totalRatings;
    }

    public void setTotalRatings(int totalRatings) {
        this.totalRatings = totalRatings;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public int getStockQuantity() {
        return stockQuantity;
    }

    public void setStockQuantity(int stockQuantity) {
        this.stockQuantity = stockQuantity;
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
                ", averageRating=" + averageRating +
                ", totalRatings=" + totalRatings +
                ", available=" + available +
                ", stockQuantity=" + stockQuantity +
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
        System.out.println("Average Rating: " + averageRating);
        System.out.println("Total Ratings: " + totalRatings);
        System.out.println("Available: " + available);
        System.out.println("Stock Quantity: " + stockQuantity);
    }
}

