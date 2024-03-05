package com.schoolproject.movie_rentaldashboard.model;

/**
 * Represents a Customer in the movie rental system.
 */
public class Customer {
    private int customerId;
    private User user; // User associated with the customer
    private String firstName;
    private String lastName;
    private String contactNumber;
    private String email;
    private String address;

    /**
     * Constructs a Customer with specified attributes.
     *
     * @param customerId    The unique identifier for the customer.
     * @param user          The user associated with the customer.
     * @param firstName     The first name of the customer.
     * @param lastName      The last name of the customer.
     * @param contactNumber The contact number of the customer.
     * @param email         The email address of the customer.
     * @param address       The address of the customer.
     */
    public Customer(int customerId, User user, String firstName, String lastName, String contactNumber, String email, String address) {
        this.customerId = customerId;
        this.user = user;
        this.firstName = firstName;
        this.lastName = lastName;
        this.contactNumber = contactNumber;
        this.email = email;
        this.address = address;
    }

    // getters and setters

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerId=" + customerId +
                ", user=" + user +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", contactNumber='" + contactNumber + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
