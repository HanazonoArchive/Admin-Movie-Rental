package com.schoolproject.movie_rentaldashboard.model;

public class UserLogged {
    private static final UserLogged instance = new UserLogged();
    private User user;

    private UserLogged() {
        user = new User();
    }

    public static UserLogged getInstance() {
        return instance;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getUserName() {
        return user.getUsername();
    }
}