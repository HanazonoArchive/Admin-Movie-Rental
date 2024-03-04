package com.schoolproject.movie_rentaldashboard.authentication;

import com.schoolproject.movie_rentaldashboard.dao.UserDAO;
import com.schoolproject.movie_rentaldashboard.dao.mysql.MySQLUserDAO;
import com.schoolproject.movie_rentaldashboard.model.User;

/**
 * Helper class for user authentication.
 */
public class AuthenticationHelper {

    /**
     * Private constructor to prevent instantiation.
     */
    private AuthenticationHelper() {
        // Private constructor to prevent instantiation
    }

    /**
     * Authenticates a user by verifying their username and password.
     *
     * @param username The username entered by the user.
     * @param password The password entered by the user.
     * @return The authenticated user if successful, or null if authentication fails.
     */
    public static User authenticateUser(String username, String password) {
        UserDAO userDAO = new MySQLUserDAO();
        User user = userDAO.getUserByUsername(username);

        if (user != null && PasswordHasher.verifyPassword(password, user.getPassword())) {
            return user;
        } else {
            return null;
        }
    }
}
