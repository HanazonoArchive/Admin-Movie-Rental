package com.schoolproject.movie_rentaldashboard;

public class UserInfoClass {
    private String userInfoMovie;
    private String userInfoMovieDate;
    private String userInfoMovieRentedDays;
    private String userInfoMovieRentedDate;
    private String userInfoMovieRefID;

    public UserInfoClass(String userInfoMovie, String userInfoMovieDate, String userInfoMovieRentedDays, String userInfoMovieRentedDate, String userInfoMovieRefID){
        this.userInfoMovie = userInfoMovie;
        this.userInfoMovieDate = userInfoMovieDate;
        this.userInfoMovieRentedDays = userInfoMovieRentedDays;
        this.userInfoMovieRentedDate = userInfoMovieRentedDate;
        this.userInfoMovieRefID = userInfoMovieRefID;
    }

    public String getUserInfoMovie(){
        return userInfoMovie;
    }
    public void setUserInfoMovie(String userInfoMovie){
        this.userInfoMovie = userInfoMovie;
    }

    public String getUserInfoMovieDate(){
        return  userInfoMovieDate;
    }

    public void setUserInfoMovieDate(String userInfoMovieDate){
        this.userInfoMovieDate = userInfoMovieDate;
    }

    public String getUserInfoMovieRentedDays(){
        return userInfoMovieRentedDays;
    }

    public void setUserInfoMovieRentedDays(String userInfoMovieRentedDays){
        this.userInfoMovieRentedDays = userInfoMovieRentedDays;
    }

    public String getUserInfoMovieRentedDate(){
        return userInfoMovieRentedDate;
    }

    public void setUserInfoMovieRentedDate(String userInfoMovieRentedDate){
        this.userInfoMovieRentedDate = userInfoMovieRentedDate;
    }

    public String getUserInfoMovieRefID() {
        return userInfoMovieRefID;
    }

    public void setUserInfoMovieRefID(String userInfoRefID){
        this.userInfoMovieRefID = userInfoRefID;
    }
}
