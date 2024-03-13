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

    private MySQLCustomerDAO mySQLCustomerDAO = new MySQLCustomerDAO();

    public void initialize() {
    }

    public void setHomeDisplay_Profile(AnchorPane homeDisplay) {
        homeDisplay.getChildren().setAll(profile_display);
    }

    @FXML
    public void displayBasicInfo(String username) {
        Customer customer = mySQLCustomerDAO.getCustomerByusername(username);
        if (customer != null) {
            basicTextField.setText("First Name: " + customer.getFirstName() + "\n"
                    + "Last Name: " + customer.getLastName() );
        } else {
            basicTextField.setText("No customer found with the provided user ID.");
        }
    }

    @FXML
    public void displayBasicInfo(int customerId) {
        Customer customer = mySQLCustomerDAO.getCustomerById(customerId);
        if (customer != null) {
            basicTextField.setText("First Name: " + customer.getFirstName() + "\n"
                    + "Last Name: " + customer.getLastName() );
        } else {
            basicTextField.setText("No customer found with the provided user ID.");
        }
    }

    @FXML
    public void displayContactInfo(String username) {
        Customer customer = mySQLCustomerDAO.getCustomerByusername(username);
        if (customer != null) {
            contactTextField.setText("Contact Number: " + customer.getContactNumber() + "\n"
                    + "Email: " + customer.getEmail() + "\n"
                    + "Address: " + customer.getAddress());
        } else {
            contactTextField.setText("No customer found with the provided user ID.");
        }
    }

    public void displayContactInfo(int customerId) {
        Customer customer = mySQLCustomerDAO.getCustomerById(customerId);
        if (customer != null) {
            contactTextField.setText("Contact Number: " + customer.getContactNumber() + "\n"
                    + "Email: " + customer.getEmail() + "\n"
                    + "Address: " + customer.getAddress());
        } else {
            contactTextField.setText("No customer found with the provided user ID.");
        }
    }
}
