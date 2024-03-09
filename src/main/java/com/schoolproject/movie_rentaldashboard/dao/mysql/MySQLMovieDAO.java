package com.schoolproject.movie_rentaldashboard.dao.mysql;

import com.schoolproject.movie_rentaldashboard.dao.MovieDAO;
import com.schoolproject.movie_rentaldashboard.model.Movie;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static com.schoolproject.movie_rentaldashboard.dao.mysql.helper.MoveCastConversionHelper.convertListToString;
import static com.schoolproject.movie_rentaldashboard.dao.mysql.helper.MoveCastConversionHelper.convertStringToList;

public class MySQLMovieDAO implements MovieDAO {
    public static final String SEARCH_MOVIES_QUERY = "SELECT * FROM Movies WHERE title LIKE ? OR genre LIKE ?";
    private static final String SELECT_ALL_MOVIES_QUERY = "SELECT * FROM Movies";
    public static final String DELETE_MOVIE_QUERY = "DELETE FROM Movies WHERE movieId=?";
    private static final String GET_MOVIE_BY_ID_QUERY = "SELECT * FROM Movies WHERE movieId=?";
    private static final String ADD_MOVIE_QUERY = "INSERT INTO Movies (title, cast, genre, duration, ageRating, description, image, price, year) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String UPDATE_MOVIE_DETAILS_QUERY = "UPDATE Movies SET title=?, cast=?, genre=?, duration=?, ageRating=?, description=?, image=?, price=?, year=? WHERE movieId=?";


    @Override
    public Movie getMovieById(String movieId) {
        try (Connection connection = MySQLDBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(GET_MOVIE_BY_ID_QUERY)) {

            preparedStatement.setInt(1, Integer.parseInt(movieId, 10));
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    String title = resultSet.getString("title");
                    List<String> cast = convertStringToList(resultSet.getString("cast")); // Need to cast to List from String with format separated by commas
                    String genre = resultSet.getString("genre");
                    int duration = resultSet.getInt("duration");
                    String ageRating = resultSet.getString("ageRating");
                    String description = resultSet.getString("description");
                    String image = resultSet.getString("image");
                    double price = resultSet.getDouble("price");
                    int year = resultSet.getInt("year");
                    double averageRating = resultSet.getDouble("averageRating");
                    int totalRatings = resultSet.getInt("totalRatings");
                    boolean available = resultSet.getBoolean("available");
                    int stockQuantity = resultSet.getInt("stockQuantity");

                    return new Movie(movieId, title, cast, genre, duration, ageRating, description, image, price, year, averageRating, totalRatings, available, stockQuantity);
                }

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    @Override
    public List<Movie> getAllMovies() {
        List<Movie> movies = new ArrayList<>();
        try (Connection connection = MySQLDBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_MOVIES_QUERY)) {
            try (ResultSet resultSet = preparedStatement.executeQuery()){
                while (resultSet.next()){

                }

            } catch (SQLException e){
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return movies;
    }

    private Movie extractMovieFromResultSet(ResultSet resultSet) throws SQLException {
        Movie movie = new Movie();
        movie.resultSet.getInt("movieId");
        resultSet.getString("title");
        resultSet.getString("cast");
        resultSet.getString("genre");
        resultSet.getInt("duration");
        resultSet.getString("ageRating");
        resultSet.getString("description");
        resultSet.getString("image");
        resultSet.getDouble("price");
        resultSet.getInt("year");
        resultSet.getDouble("averageRating");
        resultSet.getInt("totalRatings");
        resultSet.getBoolean("available");
        resultSet.getInt("stockQuantity");
    }


    @Override
    public boolean addMovie(Movie movie) {
        try (Connection connection = MySQLDBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(ADD_MOVIE_QUERY)) {

            preparedStatement.setString(1, movie.getTitle());
            preparedStatement.setString(2, convertListToString(movie.getCast())); // Need to cast to String from List with format separated by comma
            preparedStatement.setString(3, movie.getGenre());
            preparedStatement.setInt(4, movie.getDuration());
            preparedStatement.setString(5, movie.getAgeRating());
            preparedStatement.setString(6, movie.getDescription());
            preparedStatement.setString(7, movie.getImage());
            preparedStatement.setDouble(8, movie.getPrice());
            preparedStatement.setInt(9, movie.getYear());

            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public List<Movie> searchMovies(String keyword) {
        List<Movie> movies = new ArrayList<>();
        try (Connection connection = MySQLDBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SEARCH_MOVIES_QUERY)) {

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
    public boolean deleteMovie(String movieId) {
        try (Connection connection = MySQLDBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_MOVIE_QUERY)) {

            preparedStatement.setInt(1, Integer.parseInt(movieId, 10));
            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean updateMovieDetails(Movie movie) {
        try (Connection connection = MySQLDBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_MOVIE_DETAILS_QUERY)) {

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


}
