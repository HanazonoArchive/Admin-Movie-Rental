package com.schoolproject.movie_rentaldashboard;

import com.schoolproject.movie_rentaldashboard.dao.CustomerDAO;
import com.schoolproject.movie_rentaldashboard.dao.mysql.MySQLCustomerDAO;
import com.schoolproject.movie_rentaldashboard.model.Customer;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;

public class display_profileController {
    @FXML
    private TextArea basicTextField;

    @FXML
    private TextArea contactTextField;

    @FXML
    private AnchorPane profile_display;

    private CustomerDAO customerDAO;

    public void initialize() {
        customerDAO = new MySQLCustomerDAO(); // Instantiate CustomerDAO
    }

    public void setHomeDisplay_Profile(AnchorPane homeDisplay) {
        homeDisplay.getChildren().setAll(profile_display);
    }

    @FXML
    public void displayBasicInfo(int userID) {
        Customer customer = customerDAO.getCustomerByuserId(userID);
        if (customer != null) {
            basicTextField.setText("First Name: " + customer.getFirstName() + "\n"
                    + "Last Name: " + customer.getLastName() );
        } else {
            basicTextField.setText("No customer found with the provided user ID.");
        }
    }

    @FXML
    public void displayContactInfo(int userID) {
        Customer customer = customerDAO.getCustomerByuserId(userID);
        if (customer != null) {
            contactTextField.setText("Contact Number: " + customer.getContactNumber() + "\n"
                    + "Email: " + customer.getEmail() + "\n"
                    + "Address: " + customer.getAddress());
        } else {
            contactTextField.setText("No customer found with the provided user ID.");
        }
    }
}
