package com.schoolproject.database;

import com.almasb.fxgl.core.collection.Array;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;

public class Functions {

    //returns length of arrays
    public int listLength(ArrayList<String> x) {
        ArrayList<String> Arrlist = x;
        return (Arrlist.size());
    }
    //save format for each rented movie -- "$MovieID:RentDate:ReturnDate"
    public String userMovieRentReturnformat(String movie_ID, Date rentdate, Date returndate) {
        String rentdateStr = rentdate.toString();
        String returndateStr = returndate.toString();

        String userMovieRent = "$" + movie_ID + ":" + rentdateStr + ":" + returndateStr;
        return userMovieRent;
    }
    //ArrayList for each formatted rented movie -- [ $MovieID1:RentDate1:ReturnDate1 , $MovieID2:RentDate2:ReturnDate2 ]
    public ArrayList<String> addToUserMovieList(ArrayList<String> arrList, String userMovieRentReturn) {
        ArrayList<String> updatedList = new ArrayList<>(arrList);
        updatedList.add(userMovieRentReturn);
        return updatedList;
    }
    //Formatting for saving user rented movie list on server -- '$MovieID1:RentDate1:ReturnDate2$MovieID2:RentDate2:ReturnDate2'
    public String userMovieListSaveFormat(ArrayList<String> userMovieList) {
        String userMLSF = null;
        for (String i : userMovieList) {
            userMLSF += i;
        }
        return userMLSF;
    }
    //Saved user rented movie list format to ArrayList -- $Movie1:RentDate1:ReturnDate2$Movie2:RentDate2:ReturnDate2 -> [ Movie1:RentDate1:ReturnDate1 , Movie2:RentDate2:ReturnDate2 ]
    public ArrayList<String> savedUserMRRtoList (String MRR) {
        String[] userMovieArr = MRR.split(":");
        ArrayList<String> userMovieList = new ArrayList<>();
        for (String i : userMovieArr) {
            userMovieList.add(i);
        }
        return userMovieList;
    }
    //PS use this to convert saveformat to variables
    public void userMRRFormatToVariable(String userMovieRentReturn /**format -- MovieID:RentDate:ReturnDate**/) {
        String MovieID = null;
        Date rentDate, returnDate;
        String[] userRentedMovieDetailsArr = userMovieRentReturn.split(":");
        MovieID = userRentedMovieDetailsArr[0];
        DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        try {
            rentDate = dateFormat.parse(userRentedMovieDetailsArr[1]);
            returnDate = dateFormat.parse(userRentedMovieDetailsArr[2]);
        } catch (ParseException e) {
            // Handle the case where the string is not in the expected format
            System.out.println("Error parsing date: " + e.getMessage());
        }
    }
}
