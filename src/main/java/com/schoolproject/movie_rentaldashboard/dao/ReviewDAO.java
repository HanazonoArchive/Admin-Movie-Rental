package com.schoolproject.movie_rentaldashboard.dao;

import com.schoolproject.movie_rentaldashboard.model.Review;

import java.util.List;

public interface ReviewDAO {
    boolean addReview(Review review);

    List<Review> getReviewsForMovie(int movieId);

    boolean updateReview(Review review);

    boolean deleteReview(int reviewId);
    // Add other methods as needed
}
