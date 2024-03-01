package com.schoolproject.database;

import com.almasb.fxgl.core.collection.Array;

import java.util.ArrayList;
import java.util.Date;

public class Functions {
    public int listLength(ArrayList<String> x) {
        ArrayList<String> Arrlist = x;
        return (Arrlist.size());
    }
    public String userMovieRentformat(String movie_ID, Date rentdate, Date returndate) {
        String rentdateStr = rentdate.toString();
        String returndateStr = returndate.toString();

        String userMovieRent = "$" + movie_ID + ":" + rentdateStr + ":" + returndateStr;
        return userMovieRent;
    }
    public ArrayList<String> userMovieListformat(ArrayList<String> arrList, String userMovieRent) {
        ArrayList<String> updatedList = new ArrayList<>(arrList);
        updatedList.add(userMovieRent);
        return updatedList;
    }
}
