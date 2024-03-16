package com.schoolproject.movie_rentaldashboard.dao.mysql;

import com.schoolproject.movie_rentaldashboard.dao.RentalDAO;
import com.schoolproject.movie_rentaldashboard.model.Customer;
import com.schoolproject.movie_rentaldashboard.model.Movie;
import com.schoolproject.movie_rentaldashboard.model.Rental;
import com.schoolproject.movie_rentaldashboard.model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySQLRentalDAO implements RentalDAO {

    private static final String GET_RENTAL_BY_ID_QUERY = "SELECT * FROM Rentals WHERE rentalId=?";
    private static final String GET_ALL_RENTALS_QUERY = "SELECT * FROM Rentals";
    private static final String ADD_RENTAL_QUERY = "INSERT INTO Rentals (customerId, movieId, rentalDate, returnDate, rentalFee) VALUES (?, ?, ?, ?, ?)";
    private static final String UPDATE_RENTAL_RETURN_DATE_QUERY = "UPDATE Rentals SET returnDate=? WHERE rentalId=?";

    @Override
    public Rental getRentalById(int rentalId) {
        try (Connection connection = MySQLDBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(GET_RENTAL_BY_ID_QUERY)) {

            preparedStatement.setInt(1, rentalId);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    int customerId = resultSet.getInt("customerId");
                    String movieId = String.valueOf(resultSet.getInt("movieId"));
                    Date rentalDate = resultSet.getDate("rentalDate");
                    Date returnDate = resultSet.getDate("returnDate");
                    double rentalFee = resultSet.getDouble("rentalFee");

                    Customer customer = new MySQLCustomerDAO().getCustomerById(customerId);
                    Movie movie = new MySQLMovieDAO().getMovieById(movieId);

                    return new Rental(rentalId, customer, movie, rentalDate, returnDate, rentalFee);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Rental> getAllRentals() {
        List<Rental> rentals = new ArrayList<>();
        try (Connection connection = MySQLDBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL_RENTALS_QUERY);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                int rentalId = resultSet.getInt("rentalId");
                int customerId = resultSet.getInt("customerId");
                String movieId = String.valueOf(resultSet.getInt("movieId"));
                Date rentalDate = resultSet.getDate("rentalDate");
                Date returnDate = resultSet.getDate("returnDate");
                double rentalFee = resultSet.getDouble("rentalFee");

                Customer customer = new MySQLCustomerDAO().getCustomerById(customerId);
                Movie movie = new MySQLMovieDAO().getMovieById(movieId);

                rentals.add(new Rental(rentalId, customer, movie, rentalDate, returnDate, rentalFee));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rentals;
    }

    @Override
    public List<Rental> getRentalByCustomer(User user) {
        List<Rental> rentals = new ArrayList<>();
        MySQLCustomerDAO ee = new MySQLCustomerDAO();
        Customer currentCustomer = ee.getCustomerByusername(user.getUsername());
        int currentCustomerId = currentCustomer.getCustomerId();
        try (Connection connection = MySQLDBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL_RENTALS_QUERY);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                int rentalId = resultSet.getInt("rentalId");
                int customerId = resultSet.getInt("customerId");
                String movieId = String.valueOf(resultSet.getInt("movieId"));
                Date rentalDate = resultSet.getDate("rentalDate");
                Date returnDate = resultSet.getDate("returnDate");
                double rentalFee = resultSet.getDouble("rentalFee");

                Customer customer = new MySQLCustomerDAO().getCustomerById(customerId);
                Movie movie = new MySQLMovieDAO().getMovieById(movieId);

                if (currentCustomerId == customerId) {
                    rentals.add(new Rental(rentalId, customer, movie, rentalDate, returnDate, rentalFee));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rentals;
    }

    @Override
    public boolean addRental(Rental rental) {
        try (Connection connection = MySQLDBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(ADD_RENTAL_QUERY)) {

            preparedStatement.setInt(1, rental.getCustomer().getCustomerId());
            preparedStatement.setInt(2, Integer.parseInt(rental.getMovie().getMovieId(), 10));
            preparedStatement.setDate(3, rental.getRentalDate());
            preparedStatement.setDate(4, rental.getReturnDate());
            preparedStatement.setDouble(5, rental.getRentalFee());

            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean updateRentalReturnDate(int rentalId, String returnDate) {
        try (Connection connection = MySQLDBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_RENTAL_RETURN_DATE_QUERY)) {

            preparedStatement.setString(1, returnDate);
            preparedStatement.setInt(2, rentalId);

            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
