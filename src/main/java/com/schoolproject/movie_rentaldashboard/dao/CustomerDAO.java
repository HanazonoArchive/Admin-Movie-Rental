package com.schoolproject.movie_rentaldashboard.dao;

import com.schoolproject.movie_rentaldashboard.model.Customer;

import java.util.List;

public interface CustomerDAO {
    Customer getCustomerById(int customerId);

    Customer getCustomerByusername(String username);

    boolean addCustomer(Customer customer);

    boolean updateCustomerDetails(Customer customer);

    boolean deleteCustomer(int customerId);

    List<Customer> getAllCustomers();
    // Add other methods as needed
}
