package com.schoolproject.movie_rentaldashboard.dao.mysql;

import com.schoolproject.movie_rentaldashboard.dao.ReviewDAO;
import com.schoolproject.movie_rentaldashboard.model.Review;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MySQLReviewDAO implements ReviewDAO {
    public static final String ADD_REVIEW_QUERY = "INSERT INTO Reviews (customerId, movieId, rating, comment, reviewDate) VALUES (?, ?, ?, ?, ?)";
    public static final String GET_REVIEWS_FOR_MOVIE_QUERY = "SELECT * FROM Reviews WHERE movieId=?";
    public static final String UPDATE_REVIEW_QUERY = "UPDATE Reviews SET rating=?, comment=?, reviewDate=? WHERE reviewId=?";
    public static final String DELETE_REVIEW_QUERY = "DELETE FROM Reviews WHERE reviewId=?";
    // Add other queries as needed...

    @Override
    public boolean addReview(Review review) {
        try (Connection connection = MySQLDBConnection.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(ADD_REVIEW_QUERY)) {
            preparedStatement.setInt(1, review.getCustomerId());
            preparedStatement.setInt(2, review.getMovieId());
            preparedStatement.setInt(3, review.getRating());
            preparedStatement.setString(4, review.getComment());
            preparedStatement.setDate(5, review.getReviewDate());

            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public List<Review> getReviewsForMovie(int movieId) {
        List<Review> reviews = new ArrayList<>();
        try (Connection connection = MySQLDBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(GET_REVIEWS_FOR_MOVIE_QUERY)) {

            preparedStatement.setInt(1, movieId);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    // Extract review details and create Review objects
                    Review review = extractReviewFromResultSet(resultSet);
                    reviews.add(review);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return reviews;
    }

    @Override
    public boolean updateReview(Review review) {
        try (Connection connection = MySQLDBConnection.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_REVIEW_QUERY)) {
            preparedStatement.setInt(1, review.getRating());
            preparedStatement.setString(2, review.getComment());
            preparedStatement.setDate(3, review.getReviewDate());
            preparedStatement.setInt(4, review.getReviewId());

            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deleteReview(int reviewId) {
        try (Connection connection = MySQLDBConnection.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(DELETE_REVIEW_QUERY)) {
            preparedStatement.setInt(1, reviewId);

            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Add other methods as needed...

    private Review extractReviewFromResultSet(ResultSet resultSet) throws SQLException {
        Review review = new Review();
        review.setReviewId(resultSet.getInt("reviewId"));
        review.setCustomerId(resultSet.getInt("customerId"));
        review.setMovieId(resultSet.getInt("movieId"));
        review.setRating(resultSet.getInt("rating"));
        review.setComment(resultSet.getString("comment"));
        review.setReviewDate(resultSet.getDate("reviewDate"));
        return review;
    }
}
