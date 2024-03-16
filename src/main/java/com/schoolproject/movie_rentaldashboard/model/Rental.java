package com.schoolproject.movie_rentaldashboard.model;

import java.sql.Date;

/**
 * Represents a rental transaction in the Movie Rental System.
 */
public class Rental {
    private int rentalId;
    private Customer customer;
    private Movie movie;
    private Date rentalDate;
    private Date returnDate;
    private double rentalFee;
    private boolean returned;

    /**
     * Constructs a Rental object with the specified parameters.
     *
     * @param rentalId   The unique identifier for the rental.
     * @param customer   The customer associated with the rental.
     * @param movie      The movie rented.
     * @param rentalDate The date the movie was rented.
     * @param returnDate The expected return date.
     * @param rentalFee  The rental fee charged.
     * @param returned   Boolean that determines if the rented movie is returned.
     */

    public Rental(int rentalId, Customer customer, Movie movie, Date rentalDate, Date returnDate, double rentalFee, boolean returned) {
        this.rentalId = rentalId;
        this.customer = customer;
        this.movie = movie;
        this.rentalDate = rentalDate;
        this.returnDate = returnDate;
        this.rentalFee = rentalFee;
        this.returned = returned;
    }

    /**
     * Constructs a Rental object without the rentalId with the specified parameters.
     *
     * @param customer   The customer associated with the rental.
     * @param movie      The movie rented.
     * @param rentalDate The date the movie was rented.
     * @param returnDate The expected return date.
     * @param rentalFee  The rental fee charged.
     */

    public Rental(Customer customer, Movie movie, Date rentalDate, Date returnDate, double rentalFee) {
        this.customer = customer;
        this.movie = movie;
        this.rentalDate = rentalDate;
        this.returnDate = returnDate;
        this.rentalFee = rentalFee;
    }

    public int getRentalId() {
        return rentalId;
    }

    public void setRentalId(int rentalId) {
        this.rentalId = rentalId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Date getRentalDate() {
        return rentalDate;
    }

    public void setRentalDate(Date rentalDate) {
        this.rentalDate = rentalDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public double getRentalFee() {
        return rentalFee;
    }

    public void setRentalFee(double rentalFee) {
        this.rentalFee = rentalFee;
    }

    public boolean isReturned() {
        return returned;
    }

    public void setReturned(boolean returned) {
        this.returned = returned;
    }
}
