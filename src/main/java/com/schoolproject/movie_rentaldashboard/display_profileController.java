package com.schoolproject.movie_rentaldashboard;

import com.schoolproject.database.UserFunctions;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;

import java.util.ArrayList;

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

    @FXML
    public void displayBasicInfo(String userID) {
        UserFunctions userFunctions = new UserFunctions();
        ArrayList<String> userData = userFunctions.userData(userID);

        if (!userData.isEmpty()) {
            basicTextField.setText("First name: " + userData.get(0)+"\n"+
                                   "Last name: " + userData.get(1)+"\n"+
                                    "Address: "+userData.get(4)+"\n");
        } else {
            basicTextField.setText("User does not exist.");
        }
    }

@FXML
    public void displayContactInfo(String userID){
        UserFunctions contact = new UserFunctions();
        ArrayList<String> userData = contact.userData(userID);

        if (!userData.isEmpty()) {
            basicTextField.setText("Contact Number: " + userData.get(2)+"\n"+
                    "Email : " + userData.get(3)+"\n"
                  );
        } else {
            basicTextField.setText("User does not exist.");
        }
    }

}
