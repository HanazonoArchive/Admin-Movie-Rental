package com.schoolproject.movie_rentaldashboard.model;

/**
 * Represents a User in the movie rental system.
 */
public class User {
    private String username;
    private String password;

    /**
     * Constructs a User with specified attributes.
     *
     * @param username The username of the user.
     * @param password The password associated with the user.
     */
    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User(){
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }


}

