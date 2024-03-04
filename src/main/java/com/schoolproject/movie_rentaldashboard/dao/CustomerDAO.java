package com.schoolproject.movie_rentaldashboard.dao;

import com.schoolproject.movie_rentaldashboard.model.Customer;

public interface CustomerDAO {
    Customer getCustomerById(int customerId);

    Customer getCustomerByuserId(int userId);

    boolean addCustomer(Customer customer);
    boolean updateCustomerDetails(Customer customer);
    // Add other methods as needed
}
