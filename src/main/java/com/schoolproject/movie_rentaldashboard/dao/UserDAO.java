package com.schoolproject.movie_rentaldashboard.dao;

import com.schoolproject.movie_rentaldashboard.model.User;

public interface UserDAO {
    User getUserByUsername(String username);

    User getUserByUserId(int userId);

    boolean addUser(User user);
    boolean updateUserPassword(String username, String newPassword);
    // Add other methods as needed
}
