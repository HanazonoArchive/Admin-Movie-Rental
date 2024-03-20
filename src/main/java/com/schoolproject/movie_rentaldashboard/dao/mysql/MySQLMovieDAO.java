package com.schoolproject.movie_rentaldashboard.dao.mysql;

import com.schoolproject.movie_rentaldashboard.dao.MovieDAO;
import com.schoolproject.movie_rentaldashboard.model.Movie;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static com.schoolproject.movie_rentaldashboard.dao.mysql.helper.MoveCastConversionHelper.convertListToString;
import static com.schoolproject.movie_rentaldashboard.dao.mysql.helper.MoveCastConversionHelper.convertStringToList;

public class MySQLMovieDAO implements MovieDAO {
    public static final String SEARCH_MOVIES_QUERY = "SELECT * FROM Movies WHERE title LIKE ? OR genre LIKE ?";
    public static final String DELETE_MOVIE_QUERY = "DELETE FROM Movies WHERE movieId=?";
    private static final String SELECT_ALL_MOVIES_QUERY = "SELECT * FROM Movies";
    private static final String GET_MOVIE_BY_ID_QUERY = "SELECT * FROM Movies WHERE movieId=?";
    private static final String ADD_MOVIE_QUERY = "INSERT INTO Movies (title, cast, genre, duration, ageRating, description, image, price, year) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String UPDATE_MOVIE_DETAILS_QUERY = "UPDATE Movies SET title=?, cast=?, genre=?, duration=?, ageRating=?, description=?, image=?, price=?, year=? WHERE movieId=?";
    private static final String GET_MOVIES_BY_GENRE_QUERY = "SELECT * FROM Movies WHERE genre = ?";
    public static final String UPDATE_MOVIES_STOCKS_QUERY = "UPDATE Movies SET stockQuantity=? WHERE movieId=?";


    @Override
    public Movie getMovieById(String movieId) {
        try (Connection connection = MySQLDBConnection.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(GET_MOVIE_BY_ID_QUERY)) {

            preparedStatement.setInt(1, Integer.parseInt(movieId, 10));
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return extractMovieFromResultSet(resultSet);
                }

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Movie> getMoviesByGenre(String genre) {
        List<Movie> movies = new ArrayList<>();
        try (Connection connection = MySQLDBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(GET_MOVIES_BY_GENRE_QUERY)) {

            preparedStatement.setString(1, genre);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    // Extract movie details and create Movie objects
                    // (similar to what you did in the getMovieById method)
                    Movie movie = extractMovieFromResultSet(resultSet);
                    movies.add(movie);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return movies;
    }



    @Override
    public List<Movie> searchMovies(String keyword) {
        List<Movie> movies = new ArrayList<>();
        try (Connection connection = MySQLDBConnection.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(SEARCH_MOVIES_QUERY)) {

            String searchKeyword = "%" + keyword + "%";
            preparedStatement.setString(1, searchKeyword);
            preparedStatement.setString(2, searchKeyword);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    // Extract movie details and create Movie objects
                    Movie movie = extractMovieFromResultSet(resultSet);
                    movies.add(movie);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return movies;
    }


    @Override
    public List<Movie> getAllMovies() {
        List<Movie> movies = new ArrayList<>();
        try (Connection connection = MySQLDBConnection.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_MOVIES_QUERY)) {
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    // Extract movie details and create Movie objects
                    Movie movie = extractMovieFromResultSet(resultSet);
                    movies.add(movie);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return movies;
    }



    @Override
    public boolean addMovie(Movie movie) {
        try (Connection connection = MySQLDBConnection.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(ADD_MOVIE_QUERY)) {

            preparedStatement.setString(1, movie.getTitle());
            preparedStatement.setString(2, convertListToString(movie.getCast())); // Need to cast to String from List with format separated by comma
            preparedStatement.setString(3, movie.getGenre());
            preparedStatement.setInt(4, movie.getDuration());
            preparedStatement.setString(5, movie.getAgeRating());
            preparedStatement.setString(6, movie.getDescription());
            preparedStatement.setString(7, movie.getImageName());
            preparedStatement.setDouble(8, movie.getPrice());
            preparedStatement.setInt(9, movie.getYear());

            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deleteMovie(String movieId) {
        try (Connection connection = MySQLDBConnection.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(DELETE_MOVIE_QUERY)) {

            preparedStatement.setInt(1, Integer.parseInt(movieId, 10));
            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean updateMovieDetails(Movie movie) {
        try (Connection connection = MySQLDBConnection.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_MOVIE_DETAILS_QUERY)) {

            preparedStatement.setString(1, movie.getTitle());
            preparedStatement.setString(2, convertListToString(movie.getCast())); // Need to cast to String from List with format separated by comma
            preparedStatement.setString(3, movie.getGenre());
            preparedStatement.setInt(4, movie.getDuration());
            preparedStatement.setString(5, movie.getAgeRating());
            preparedStatement.setString(6, movie.getDescription());
            preparedStatement.setString(7, movie.getImage());
            preparedStatement.setDouble(8, movie.getPrice());
            preparedStatement.setInt(9, movie.getYear());
            preparedStatement.setInt(10, Integer.parseInt(movie.getMovieId(), 10));

            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean updateMovieStockQuantity(int movieId, int quantity) {
        try (Connection connection = MySQLDBConnection.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_MOVIES_STOCKS_QUERY)) {
            preparedStatement.setInt(1,quantity);
            preparedStatement.setInt(2, movieId);

            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    private Movie extractMovieFromResultSet(ResultSet resultSet) throws SQLException {
        Movie movie = new Movie();
        movie.setMovieId(String.valueOf(resultSet.getInt("movieId")));
        movie.setTitle(resultSet.getString("title"));
        movie.setCast(convertStringToList(resultSet.getString("cast")));
        movie.setGenre(resultSet.getString("genre"));
        movie.setDuration(resultSet.getInt("duration"));
        movie.setAgeRating(resultSet.getString("ageRating"));
        movie.setDescription(resultSet.getString("description"));
        movie.setImage(resultSet.getString("image"));
        movie.setPrice(resultSet.getDouble("price"));
        movie.setYear(resultSet.getInt("year"));
        movie.setAvailable(resultSet.getBoolean("available"));
        movie.setAverageRating(resultSet.getDouble("averageRating"));
        movie.setTotalRatings(resultSet.getInt("totalRatings"));
        movie.setStockQuantity(resultSet.getInt("stockQuantity"));
        movie.setStockQuantity(resultSet.getInt("stockQuantity"));
        return movie;
    }
}
