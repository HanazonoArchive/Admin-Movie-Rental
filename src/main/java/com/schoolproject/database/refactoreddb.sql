-- Drop the database if it exists
DROP DATABASE IF EXISTS Cinematique;

-- Create the database with utf8mb4 character set
CREATE DATABASE Cinematique CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;

-- Switch to the Cinematique database
USE Cinematique;

-- Create Users table for authentication
CREATE TABLE Users
(
    username VARCHAR(255) NOT NULL PRIMARY KEY,
    password VARCHAR(255) NOT NULL
);

-- Create Customers table
CREATE TABLE Customers
(
    customerId    INT PRIMARY KEY AUTO_INCREMENT,
    username      VARCHAR(255),
    firstName     VARCHAR(255) NOT NULL,
    lastName      VARCHAR(255) NOT NULL,
    contactNumber VARCHAR(20),
    email         VARCHAR(255) NOT NULL,
    address       VARCHAR(255),
    FOREIGN KEY (username) REFERENCES Users (username)
);

-- Create Movies table
CREATE TABLE Movies
(
    movieId       INT(6) ZEROFILL AUTO_INCREMENT PRIMARY KEY, -- The format of primary key should be 6 digits (000001, 000002,... 003893)
    title         VARCHAR(255) NOT NULL,
    cast          TEXT,
    genre         VARCHAR(255),
    duration      INT,
    ageRating     VARCHAR(10),
    description   TEXT,
    image         VARCHAR(255),
    price         DOUBLE,
    year          INT,
    averageRating DOUBLE  DEFAULT 0.0,
    totalRatings  INT     DEFAULT 0,
    available     BOOLEAN DEFAULT true,                       -- New column for availability status
    stockQuantity INT     DEFAULT 1                           -- New column for stock quantity
);

-- Create Rentals table
CREATE TABLE Rentals
(
    rentalId   INT PRIMARY KEY AUTO_INCREMENT,
    customerId INT,
    movieId    INT(6) ZEROFILL,
    rentalDate DATE,
    returnDate DATE,
    rentalStatus VARCHAR(10),
    rentalFee  DOUBLE,
    returned   BOOLEAN   DEFAULT false,
    FOREIGN KEY (customerId) REFERENCES Customers (customerId),
    FOREIGN KEY (movieId) REFERENCES Movies (movieId)
);

-- Create Logs table
CREATE TABLE Logs (
                     ActionID INT PRIMARY KEY AUTO_INCREMENT,
                     DateTime VARCHAR(20) NOT NULL,
                     UserType VARCHAR(10) NOT NULL,
                     UserName VARCHAR(50) NOT NULL,
                     Action VARCHAR(20) NOT NULL,
                     Details VARCHAR(50)
);

-- Create Reviews table
CREATE TABLE Reviews
(
    reviewId   INT PRIMARY KEY AUTO_INCREMENT,
    customerId INT,
    movieId    INT(6) ZEROFILL,
    rating     INT, -- Assuming a rating out of 5, adjust as needed
    comment    TEXT,
    reviewDate DATE,
    FOREIGN KEY (customerId) REFERENCES Customers (customerId),
    FOREIGN KEY (movieId) REFERENCES Movies (movieId)
);

-- Create a trigger to update Movies table on insert in Reviews table
CREATE TRIGGER after_insert_review
    AFTER INSERT
    ON Reviews
    FOR EACH ROW
BEGIN
    -- Update totalRatings and averageRating in Movies table
    UPDATE Movies
    SET totalRatings  = (SELECT COUNT(*)
                         FROM Reviews
                         WHERE movieId = NEW.movieId),
        averageRating = (SELECT IFNULL(AVG(rating), 0)
                         FROM Reviews
                         WHERE movieId = NEW.movieId)
    WHERE movieId = NEW.movieId;
END;

-- Create a trigger to update Movies table on update in Reviews table
CREATE TRIGGER after_update_review
    AFTER UPDATE
    ON Reviews
    FOR EACH ROW
BEGIN
    -- Update totalRatings and averageRating in Movies table
    UPDATE Movies
    SET totalRatings  = (SELECT COUNT(*)
                         FROM Reviews
                         WHERE movieId = NEW.movieId),
        averageRating = (SELECT IFNULL(AVG(rating), 0)
                         FROM Reviews
                         WHERE movieId = NEW.movieId)
    WHERE movieId = NEW.movieId;
END;

-- Create a trigger to update Movies table on delete in Reviews table
CREATE TRIGGER after_delete_review
    AFTER DELETE
    ON Reviews
    FOR EACH ROW
BEGIN
    -- Update totalRatings and averageRating in Movies table
    UPDATE Movies
    SET totalRatings  = (SELECT COUNT(*)
                         FROM Reviews
                         WHERE movieId = OLD.movieId),
        averageRating = (SELECT IFNULL(AVG(rating), 0)
                         FROM Reviews
                         WHERE movieId = OLD.movieId)
    WHERE movieId = OLD.movieId;
END;