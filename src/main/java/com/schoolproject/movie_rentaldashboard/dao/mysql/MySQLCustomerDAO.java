package com.schoolproject.movie_rentaldashboard.dao.mysql;

import com.schoolproject.movie_rentaldashboard.dao.CustomerDAO;
import com.schoolproject.movie_rentaldashboard.dao.UserDAO;
import com.schoolproject.movie_rentaldashboard.model.Customer;
import com.schoolproject.movie_rentaldashboard.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MySQLCustomerDAO implements CustomerDAO {

    private static final String GET_CUSTOMER_BY_ID_QUERY = "SELECT * FROM Customers WHERE customerId=?";
    private static final String GET_CUSTOMER_BY_USERNAME_QUERY = "SELECT * FROM Customers WHERE username=?";
    private static final String ADD_CUSTOMER_QUERY = "INSERT INTO Customers (username, firstName, lastName, contactNumber, email, address) VALUES (?, ?, ?, ?, ?, ?)";
    private static final String UPDATE_CUSTOMER_DETAILS_QUERY = "UPDATE Customers SET firstName=?, lastName=?, contactNumber=?, email=?, address=? WHERE customerId=?";
    public static final String DELETE_CUSTOMER_QUERY = "DELETE FROM Customers WHERE customerId=?";
    private static final String SELECT_ALL_CUSTOMERS_QUERY = "SELECT * FROM Customers";


    @Override
    public Customer getCustomerById(int customerId) {
        try (Connection connection = MySQLDBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(GET_CUSTOMER_BY_ID_QUERY)) {

            preparedStatement.setInt(1, customerId);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    String username = resultSet.getString("username");
                    String firstName = resultSet.getString("firstName");
                    String lastName = resultSet.getString("lastName");
                    String contactNumber = resultSet.getString("contactNumber");
                    String email = resultSet.getString("email");
                    String address = resultSet.getString("address");

                    // Code to get the User from the User table using the username
                    UserDAO userDAO = new MySQLUserDAO();
                    User user;
                    user =  userDAO.getUserByUsername(username);
                    return new Customer(customerId, user, firstName, lastName, contactNumber, email, address);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Customer getCustomerByusername(String username) {
        try (Connection connection = MySQLDBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(GET_CUSTOMER_BY_USERNAME_QUERY)) {

            preparedStatement.setString(1, username);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    int customerId = resultSet.getInt("customerId");
                    String firstName = resultSet.getString("firstName");
                    String lastName = resultSet.getString("lastName");
                    String contactNumber = resultSet.getString("contactNumber");
                    String email = resultSet.getString("email");
                    String address = resultSet.getString("address");

                    // Code to get the User from the User table using the userId
                    UserDAO userDAO = new MySQLUserDAO();
                    User user;
                    user =  userDAO.getUserByUsername(username);

                    return new Customer(customerId, user, firstName, lastName, contactNumber, email, address);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean addCustomer(Customer customer) {
        try (Connection connection = MySQLDBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(ADD_CUSTOMER_QUERY)) {

            preparedStatement.setString(1,customer.getUser().getUsername());
            preparedStatement.setString(2, customer.getFirstName());
            preparedStatement.setString(3, customer.getLastName());
            preparedStatement.setString(4, customer.getContactNumber());
            preparedStatement.setString(5, customer.getEmail());
            preparedStatement.setString(6, customer.getAddress());

            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean updateCustomerDetails(Customer customer) {
        try (Connection connection = MySQLDBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_CUSTOMER_DETAILS_QUERY)) {

            preparedStatement.setString(1, customer.getFirstName());
            preparedStatement.setString(2, customer.getLastName());
            preparedStatement.setString(3, customer.getContactNumber());
            preparedStatement.setString(4, customer.getEmail());
            preparedStatement.setString(5, customer.getAddress());
            preparedStatement.setInt(6, customer.getCustomerId());

            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deleteCustomer(int customerId) {
        try (Connection connection = MySQLDBConnection.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(DELETE_CUSTOMER_QUERY)) {

            preparedStatement.setInt(1, customerId);
            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public List<Customer> getAllCustomers() {
        List<Customer> customers = new ArrayList<>();
        try (Connection connection = MySQLDBConnection.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_CUSTOMERS_QUERY)) {
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    // Extract movie details and create Movie objects
                    Customer customer = extractCustomersFromResultSet(resultSet);
                    customers.add(customer);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customers;
    }
    private Customer extractCustomersFromResultSet(ResultSet resultSet) throws SQLException {
        MySQLUserDAO e = new MySQLUserDAO();

        Customer customer = new Customer();
        customer.setCustomerId(resultSet.getInt("customerId"));
        customer.setUser(e.getUserByUsername(resultSet.getString("username")));
        customer.setFirstName(resultSet.getString("firstName"));
        customer.setLastName(resultSet.getString("lastName"));
        customer.setContactNumber(resultSet.getString("contactNumber"));
        customer.setEmail(resultSet.getString("email"));
        customer.setAddress(resultSet.getString("address"));

        return customer;
    }
}
