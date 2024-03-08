package com.schoolproject.movie_rentaldashboard.model;

/**
 * Represents a User in the movie rental system.
 */
public class User {
//    private int userId;
    private String username;
    private String password;

    /**
     * Constructs a User with specified attributes.
     *
//     * @param userId   The unique identifier for the user.
     * @param username The username of the user.
     * @param password The password associated with the user.
     */
    public User(String username, String password) {
//        this.userId = userId;
        this.username = username;
        this.password = password;
    }

//    public int getUserId() {
//        return userId;
//    }

//    public void setUserId(int userId) {
//        this.userId = userId;
//    }

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
//                "userId=" + userId +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }


}

