package com.schoolproject.movie_rentaldashboard.authentication;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Utility class for password hashing using SHA-256.
 */
public class PasswordHasher {

    /**
     * Private constructor to prevent instantiation.
     */
    private PasswordHasher() {
        // Private constructor to prevent instantiation
    }

    /**
     * Hashes a plain text password using SHA-256.
     *
     * @param password The plain text password to be hashed.
     * @return The hashed password as a hexadecimal string.
     */
    public static String hashPassword(String password) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] encodedHash = digest.digest(password.getBytes(StandardCharsets.UTF_8));

            // Convert byte array to hexadecimal string
            StringBuilder hexString = new StringBuilder(2 * encodedHash.length);
            for (byte b : encodedHash) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Verifies if a plain text password matches a hashed password.
     *
     * @param plainTextPassword The plain text password.
     * @param hashedPassword    The hashed password to compare against.
     * @return True if the passwords match, false otherwise.
     */
    public static boolean verifyPassword(String plainTextPassword, String hashedPassword) {
        String hashedPlainTextPassword = hashPassword(plainTextPassword);
        return hashedPlainTextPassword != null && hashedPlainTextPassword.equals(hashedPassword);
    }
}
