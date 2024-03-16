package com.schoolproject.movie_rentaldashboard.dao;

import com.schoolproject.movie_rentaldashboard.model.Customer;
import com.schoolproject.movie_rentaldashboard.model.Rental;
import com.schoolproject.movie_rentaldashboard.model.User;

import java.util.List;

public interface RentalDAO {
    Rental getRentalById(int rentalId);
    List<Rental> getAllRentals();

    List<Rental> getRentalByCustomer(User username);

    boolean addRental(Rental rental);
    boolean updateRentalReturnDate(int rentalId, String returnDate);

    boolean updateRentalStatus(int rentalId, String newStatus);
    // Add other methods as needed
}
