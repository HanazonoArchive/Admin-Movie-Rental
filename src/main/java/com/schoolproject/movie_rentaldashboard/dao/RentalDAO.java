package com.schoolproject.movie_rentaldashboard.dao;

import com.schoolproject.movie_rentaldashboard.model.Rental;

import java.util.List;

public interface RentalDAO {
    Rental getRentalById(int rentalId);
    List<Rental> getAllRentals();
    boolean addRental(Rental rental);
    boolean updateRentalReturnDate(int rentalId, String returnDate);
    // Add other methods as needed
}
