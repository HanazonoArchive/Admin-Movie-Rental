package com.schoolproject.movie_rentaldashboard;

import com.schoolproject.database.UserFunctions;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;

public class display_cartController {

    @FXML
    private AnchorPane cart_screen;
    //@FXML
    //private TableView<?> orderTable;

    public void setHomeDisplay_Cart(AnchorPane homeDisplay) {
        homeDisplay.getChildren().setAll(cart_screen);
    }

    /*public void setInformation(){
        UserFunctions functions = new UserFunctions();
        //functions.userData("");
        orderTable.setAccessibleText(functions.userData(""));

    }*/


}
