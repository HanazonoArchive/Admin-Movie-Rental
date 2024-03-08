package com.schoolproject.movie_rentaldashboard;

import com.schoolproject.database.UserFunctions;
import com.schoolproject.movie_rentaldashboard.dao.mysql.MySQLCustomerDAO;
import com.schoolproject.movie_rentaldashboard.dao.mysql.MySQLUserDAO;
import com.schoolproject.movie_rentaldashboard.model.Customer;
import com.schoolproject.movie_rentaldashboard.model.User;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

import javax.swing.*;

import static java.sql.Types.NULL;

public class display_SignUpController {

    @FXML
    private TextField EmailTextField;

    @FXML
    private TextField addressTextField;

    @FXML
    private PasswordField conPasswordTextField;

    @FXML
    private TextField contactNumberTextField;

    @FXML
    private TextField firstNameTextField;

    @FXML
    private ImageView hiddenConPassIcon;

    @FXML
    private ImageView hiddenPassIcon;

    @FXML
    private TextField lastNameTextField;

    @FXML
    private PasswordField passwordTextField;

    @FXML
    private Button registerButton;

    @FXML
    private ImageView showConPassIcon;


    @FXML
    private TextField showConTextField;

    @FXML
    private ImageView showPassIcon;

    @FXML
    private TextField showTextField;

    @FXML
    private AnchorPane signUpScreen;

    @FXML
    private TextField userNameTextField;

    private String username;
    private String firstname;
    private String lastname;
    private String password;
    private String confirmPassword;
    private String address;
    private String contactNumber;
    private String email;

    private String MRR;

    User user;
    Customer customer;
    private Stage primaryStage;

    // Add a setter method to set the primaryStage
    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }


    public void dataCollection() {
//        UserFunctions signUp = new UserFunctions();
//        signUp.addNewUser(username,password,firstname, lastname,contactNumber,email,address,MRR);

        user = new User(username, password);

        MySQLUserDAO mySQLUserDAO = new MySQLUserDAO();
        MySQLCustomerDAO mySQLCustomerDAO = new MySQLCustomerDAO();
        mySQLUserDAO.addUser(user);
//        user.setUserId(mySQLUserDAO.getUserByUsername(username).getUserId());
        customer = new Customer(NULL, user, firstname, lastname, contactNumber, email, address);
        mySQLCustomerDAO.addCustomer(customer);
//        customer.setCustomerId(mySQLCustomerDAO.getCustomerByuserId(user.getUserId()).getCustomerId());
    }

    @FXML
    public void Register() {
        username = userNameTextField.getText();
        firstname = firstNameTextField.getText();
        lastname = lastNameTextField.getText();
        confirmPassword = conPasswordTextField.getText();
        password = passwordTextField.getText();
        address = addressTextField.getText();
        contactNumber = contactNumberTextField.getText();
        email = EmailTextField.getText();
        MRR = "";
        if (!password.equals(confirmPassword)) {
            showAlert("Password and Confirm Password do not match!");
            return;
        }
        if (username.isEmpty() || password.isEmpty() || firstname.isEmpty() || lastname.isEmpty() || contactNumber.isEmpty() || email.isEmpty() || address.isEmpty()) {
            showAlert("All fields are required!");
            return;
        }

        // Check if contact number matches the desired format
        if (!contactNumber.matches("\\d*")) {
            showAlert("Contact Number should contain only digits!");
            return;
        }

        // Check if email matches the desired format
        if (!email.matches("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}")) {
            showAlert("Email address is not valid!");
            return;
        }


        dataCollection();//connecting to db

        primaryStage.close(); // Close the sign-up screen
        new LoginDemo(primaryStage);//open userlogin
        JOptionPane.showMessageDialog(null, "Registered Successfully");
    }

    private void showAlert(String message) {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    @FXML
    private void ontoggleOffPasswordVisibility(PasswordField passwordTextField, ImageView showPassIcon, ImageView hiddenPassIcon, TextField showtextField) {
        System.out.println("toggle off");
        showPassIcon.setVisible(true);
        hiddenPassIcon.setVisible(false);

        passwordTextField.setText(showtextField.getText());
        showtextField.setVisible(false);
        passwordTextField.setVisible(true);


    }

    @FXML
    private void ontoggleOnPasswordVisibility(PasswordField passwordTextField, ImageView showPassIcon, ImageView hiddenPassIcon, TextField showtextField) {
        System.out.println("toggle On");

        hiddenPassIcon.setVisible(true);
        showPassIcon.setVisible(false);

        showtextField.setText(passwordTextField.getText());
        passwordTextField.setVisible(false);
        showtextField.setVisible(true);
    }
    @FXML
    private void toggleON() {
        showPassIcon.setOnMouseClicked(e -> ontoggleOnPasswordVisibility(passwordTextField, showPassIcon, hiddenPassIcon, showTextField));

    }
    @FXML
    private void toggleOF() {
        hiddenPassIcon.setOnMouseClicked(e -> ontoggleOffPasswordVisibility(passwordTextField, showPassIcon, hiddenPassIcon, showTextField));
    }

    private void toggleOnConPasswordVisibility(PasswordField passwordTextField, ImageView showPassIcon, ImageView hiddenPassIcon, TextField showtextField) {
        System.out.println("toggle On");

        showtextField.setText(passwordTextField.getText());
        passwordTextField.setVisible(false);
        showtextField.setVisible(true);

        hiddenPassIcon.setVisible(true);
        showPassIcon.setVisible(false);

    }
    private void toggleOffConPasswordVisibility(PasswordField passwordTextField, ImageView showPassIcon, ImageView hiddenPassIcon, TextField showtextField) {
        System.out.println("toggle off");


        passwordTextField.setText(showtextField.getText());
        showtextField.setVisible(false);
        passwordTextField.setVisible(true);

        showPassIcon.setVisible(true);
        hiddenPassIcon.setVisible(false);
    }
    @FXML
    private void conToggleON() {
        showConPassIcon.setOnMouseClicked(e -> toggleOnConPasswordVisibility(conPasswordTextField, showConPassIcon, hiddenConPassIcon, showConTextField));
    }
    @FXML
    private void conToggleOFF() {
        hiddenConPassIcon.setOnMouseClicked(e -> toggleOffConPasswordVisibility(conPasswordTextField, showConPassIcon, hiddenConPassIcon, showConTextField));
    }

    public void getUsername(String username) {
        this.username = username;
    }
}