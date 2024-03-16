package com.schoolproject.movie_rentaldashboard.model;

import java.sql.Date;

/**
 * Represents a review for a movie in the movie rental system.
 */
public class Review {
    private int reviewId;
    private int customerId;
    private int movieId;
    private int rating;
    private String comment;
    private Date reviewDate;

    // Constructors, getters, and setters

    public Review() {
    }

    public Review(int reviewId, int customerId, int movieId, int rating, String comment, Date reviewDate) {
        this.reviewId = reviewId;
        this.customerId = customerId;
        this.movieId = movieId;
        this.rating = rating;
        this.comment = comment;
        this.reviewDate = reviewDate;
    }

    public Review(int customerId, int movieId, int rating, String comment, Date reviewDate) {
        this.customerId = customerId;
        this.movieId = movieId;
        this.rating = rating;
        this.comment = comment;
        this.reviewDate = reviewDate;
    }

    // Getters and setters

    public int getReviewId() {
        return reviewId;
    }

    public void setReviewId(int reviewId) {
        this.reviewId = reviewId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Date getReviewDate() {
        return reviewDate;
    }

    public void setReviewDate(Date reviewDate) {
        this.reviewDate = reviewDate;
    }

    @Override
    public String toString() {
        return "Review{" +
                "reviewId=" + reviewId +
                ", customerId=" + customerId +
                ", movieId=" + movieId +
                ", rating=" + rating +
                ", comment='" + comment + '\'' +
                ", reviewDate=" + reviewDate +
                '}';
    }
}
