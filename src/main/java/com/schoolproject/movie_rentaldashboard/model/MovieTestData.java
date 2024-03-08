package com.schoolproject.movie_rentaldashboard.model;

import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

public class MovieTestData {

    public static List<Movie> getTestMovies() {
        List<Movie> movies = new ArrayList<>();



        // Adding test movie data
        movies.add(new Movie(102103, "Inception", List.of("Leonardo DiCaprio", "Joseph Gordon-Levitt", "Ellen Page"), "Science Fiction", 148, "PG-13", "A mind-bending journey through dreams and reality.", "1.jpg", 78.00, 2024, 4.0, 1, false, 0));
        movies.add(new Movie(001301, "The Dark Knight", List.of("Christian Bale", "Heath Ledger", "Aaron Eckhart"), "Action", 152, "PG-13", "The Joker wreaks havoc on Gotham City.", "2.jpg", 60.00,2023, 4.2,10,true, 1));
        movies.add(new Movie(001201, "Inception", List.of("Leonardo DiCaprio", "Joseph Gordon-Levitt", "Ellen Page"), "Science Fiction", 148, "PG-13", "A mind-bending journey through dreams and reality.", "3.jpg", 78.00, 2024, 3.0, 4, true,3));
        movies.add(new Movie(012020, "The Dark Knight", List.of("Christian Bale", "Heath Ledger", "Aaron Eckhart"), "Action", 152, "PG-13", "The Joker wreaks havoc on Gotham City.", "4.jpg", 60.00,2023,3.4,2,true, 1));
        movies.add(new Movie(001202, "Inception", List.of("Leonardo DiCaprio", "Joseph Gordon-Levitt", "Ellen Page"), "Science Fiction", 148, "PG-13", "A mind-bending journey through dreams and reality.", "5.jpg", 78.00, 2024,2.4,2,false, 0));
        movies.add(new Movie(002102, "The Dark Knight", List.of("Christian Bale", "Heath Ledger", "Aaron Eckhart"), "Action", 152, "PG-13", "The Joker wreaks havoc on Gotham City.", "1.jpg", 60.00,2023, 4.5, 1, true, 1));
        movies.add(new Movie(001220, "Inception", List.of("Leonardo DiCaprio", "Joseph Gordon-Levitt", "Ellen Page"), "Science Fiction", 148, "PG-13", "A mind-bending journey through dreams and reality.", "2.jpg", 78.00, 2024, 4.5,1,true, 2));
        movies.add(new Movie(000201, "The Dark Knight", List.of("Christian Bale", "Heath Ledger", "Aaron Eckhart"), "Action", 152, "PG-13", "The Joker wreaks havoc on Gotham City.", "2.jpg", 60.00,2023, 5.0, 1, true, 1));
        movies.add(new Movie(000234, "Inception", List.of("Leonardo DiCaprio", "Joseph Gordon-Levitt", "Ellen Page"), "Science Fiction", 148, "PG-13", "A mind-bending journey through dreams and reality.", "3.jpg", 78.00, 2024, 4.2, 2, true, 2));
        movies.add(new Movie(000010, "The Dark Knight", List.of("Christian Bale", "Heath Ledger", "Aaron Eckhart"), "Action", 152, "PG-13", "The Joker wreaks havoc on Gotham City.", "4.jpg", 60.00,2023,5.0,1,true, 1));
        movies.add(new Movie(000011, "Inception", List.of("Leonardo DiCaprio", "Joseph Gordon-Levitt", "Ellen Page"), "Science Fiction", 148, "PG-13", "A mind-bending journey through dreams and reality.", "5.jpg", 78.00, 2024, 3.4, 8, true, 1));
        movies.add(new Movie(000012, "The Dark Knight", List.of("Christian Bale", "Heath Ledger", "Aaron Eckhart"), "Action", 152, "PG-13", "The Joker wreaks havoc on Gotham City.", "1.jpg", 60.00,2023,3.4, 3, true, 2));
        movies.add(new Movie(000013, "Inception", List.of("Leonardo DiCaprio", "Joseph Gordon-Levitt", "Ellen Page"), "Science Fiction", 148, "PG-13", "A mind-bending journey through dreams and reality.", "2.jpg", 78.00, 2024, 4.5, 2, true, 1));

//        movies.add(new Movie(1, "Inception", List.of("Leonardo DiCaprio", "Joseph Gordon-Levitt", "Ellen Page"), "Science Fiction", 148, "PG-13", "A mind-bending journey through dreams and reality.", "1.jpg", 78.00, 2024));
//        movies.add(new Movie(2, "The Dark Knight", List.of("Christian Bale", "Heath Ledger", "Aaron Eckhart"), "Action", 152, "PG-13", "The Joker wreaks havoc on Gotham City.", "2.jpg", 60.00,2023));
//        movies.add(new Movie(3, "Inception", List.of("Leonardo DiCaprio", "Joseph Gordon-Levitt", "Ellen Page"), "Science Fiction", 148, "PG-13", "A mind-bending journey through dreams and reality.", "3.jpg", 78.00, 2024));
//        movies.add(new Movie(4, "The Dark Knight", List.of("Christian Bale", "Heath Ledger", "Aaron Eckhart"), "Action", 152, "PG-13", "The Joker wreaks havoc on Gotham City.", "4.jpg", 60.00,2023));
//        movies.add(new Movie(5, "Inception", List.of("Leonardo DiCaprio", "Joseph Gordon-Levitt", "Ellen Page"), "Science Fiction", 148, "PG-13", "A mind-bending journey through dreams and reality.", "5.jpg", 78.00, 2024));
//        movies.add(new Movie(6, "The Dark Knight", List.of("Christian Bale", "Heath Ledger", "Aaron Eckhart"), "Action", 152, "PG-13", "The Joker wreaks havoc on Gotham City.", "1.jpg", 60.00,2023));
//        movies.add(new Movie(7, "Inception", List.of("Leonardo DiCaprio", "Joseph Gordon-Levitt", "Ellen Page"), "Science Fiction", 148, "PG-13", "A mind-bending journey through dreams and reality.", "2.jpg", 78.00, 2024));
//        movies.add(new Movie(8, "The Dark Knight", List.of("Christian Bale", "Heath Ledger", "Aaron Eckhart"), "Action", 152, "PG-13", "The Joker wreaks havoc on Gotham City.", "2.jpg", 60.00,2023));
//        movies.add(new Movie(9, "Inception", List.of("Leonardo DiCaprio", "Joseph Gordon-Levitt", "Ellen Page"), "Science Fiction", 148, "PG-13", "A mind-bending journey through dreams and reality.", "3.jpg", 78.00, 2024));
//        movies.add(new Movie(10, "The Dark Knight", List.of("Christian Bale", "Heath Ledger", "Aaron Eckhart"), "Action", 152, "PG-13", "The Joker wreaks havoc on Gotham City.", "4.jpg", 60.00,2023));
//        movies.add(new Movie(11, "Inception", List.of("Leonardo DiCaprio", "Joseph Gordon-Levitt", "Ellen Page"), "Science Fiction", 148, "PG-13", "A mind-bending journey through dreams and reality.", "5.jpg", 78.00, 2024));
//        movies.add(new Movie(12, "The Dark Knight", List.of("Christian Bale", "Heath Ledger", "Aaron Eckhart"), "Action", 152, "PG-13", "The Joker wreaks havoc on Gotham City.", "1.jpg", 60.00,2023));
//        movies.add(new Movie(13, "Inception", List.of("Leonardo DiCaprio", "Joseph Gordon-Levitt", "Ellen Page"), "Science Fiction", 148, "PG-13", "A mind-bending journey through dreams and reality.", "2.jpg", 78.00, 2024));


        // Add more test movies as needed

        return movies;
    }
}
