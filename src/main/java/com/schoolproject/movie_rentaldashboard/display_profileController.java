package com.schoolproject.movie_rentaldashboard;

import com.schoolproject.database.UserFunctions;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;

public class display_profileController {
    @FXML
    private TextArea basicTextField;

    @FXML
    private TextArea conactTextField;

    @FXML
    private AnchorPane profile_display;

    public void setHomeDisplay_Profile(AnchorPane homeDisplay) {
        homeDisplay.getChildren().setAll(profile_display);
    }

    public void displayBasicInfo(){
        UserFunctions basic = new UserFunctions();
        //get info from arraylist
        basicTextField.setText("");
    }

    public void displayContactInfo(){
        UserFunctions contact = new UserFunctions();
    }
}
