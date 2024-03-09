package com.schoolproject.movie_rentaldashboard;

public class UserClass {
    private String userID;
    private String username;
    private String password;
    private String name;
    private String contactNo;
    private String email;

    public UserClass(String userID, String username, String password, String name, String contactNo, String email){
        this.userID = userID;
        this.username = username;
        this.password = password;
        this.name = name;
        this.contactNo = contactNo;
        this.email = email;
    }

    public String getUserID(){
        return userID;
    }

    public void setUserID(String userID){
        this.userID = userID;
    }

    public String getUsername(){
        return username;
    }

    public void setUsername(String username){
        this.username = username;
    }

    public String getPassword(){
        return password;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getContactNo(){
        return contactNo;
    }

    public void setContactNo(String contactNo){
        this.contactNo = contactNo;
    }

    public String getEmail(){
        return email;
    }

    public void setEmail(String email){
        this.email = email;
    }
}
