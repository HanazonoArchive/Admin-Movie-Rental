package com.schoolproject.movie_rentaldashboard;

public class MovieClass {
    private String movieID;
    private String movieTitle;
    private String movieCast;
    private String genres;
    private String movieRuntime;
    private String ageRestriction;
    private String movieDate;
    private String movieDescription;

    // Constructor
    public MovieClass(String movieID, String movieTitle, String movieCast, String genres, String movieRuntime, String ageRestriction, String movieDate, String movieDescription) {
        this.movieID = movieID;
        this.movieTitle = movieTitle;
        this.movieCast = movieCast;
        this.genres = genres;
        this.movieRuntime = movieRuntime;
        this.ageRestriction = ageRestriction;
        this.movieDate = movieDate;
        this.movieDescription = movieDescription;
    }

    // Getters and setters
    public String getMovieID() {
        return movieID;
    }

    public void setMovieID(String movieID) {
        this.movieID = movieID;
    }

    public String getMovieTitle() {
        return movieTitle;
    }

    public void setMovieTitle(String movieTitle) {
        this.movieTitle = movieTitle;
    }

    public String getMovieCast() {
        return movieCast;
    }

    public void setMovieCast(String movieCast) {
        this.movieCast = movieCast;
    }

    public String getGenres() {
        return genres;
    }

    public void setGenres(String genres) {
        this.genres = genres;
    }

    public String getMovieRuntime() {
        return movieRuntime;
    }

    public void setMovieRuntime(String movieRuntime) {
        this.movieRuntime = movieRuntime;
    }

    public String getAgeRestriction() {
        return ageRestriction;
    }

    public void setAgeRestriction(String ageRestriction) {
        this.ageRestriction = ageRestriction;
    }

    public String getMovieDate() {
        return movieDate;
    }

    public void setMovieDate(String movieDate) {
        this.movieDate = movieDate;
    }

    public String getMovieDescription() {
        return movieDescription;
    }

    public void setMovieDescription(String movieDescription) {
        this.movieDescription = movieDescription;
    }
}

