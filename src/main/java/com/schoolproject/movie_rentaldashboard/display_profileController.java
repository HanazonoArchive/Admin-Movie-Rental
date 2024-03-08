package com.schoolproject.movie_rentaldashboard;

import com.schoolproject.database.UserFunctions;
import com.schoolproject.movie_rentaldashboard.dao.mysql.MySQLCustomerDAO;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;

import java.util.ArrayList;

public class display_profileController {
    @FXML
    private TextArea basicTextField;

    @FXML
    private TextArea contactTextField;

    @FXML
    private AnchorPane profile_display;

    public void setHomeDisplay_Profile(AnchorPane homeDisplay) {
        homeDisplay.getChildren().setAll(profile_display);
    }

    @FXML
    public void displayBasicInfo(String userID) {

    }

@FXML
    public void displayContactInfo(String userID){

    }

}
