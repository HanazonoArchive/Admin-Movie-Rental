package com.schoolproject.movie_rentaldashboard.dao;

import com.schoolproject.movie_rentaldashboard.model.Customer;

public interface CustomerDAO {
    Customer getCustomerById(int customerId);

    Customer getCustomerByusername(String username);

    boolean addCustomer(Customer customer);

    boolean updateCustomerDetails(Customer customer);
    // Add other methods as needed
}
