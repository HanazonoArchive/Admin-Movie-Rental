package com.schoolproject.movie_rentaldashboard;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

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
    private String lastame;
    private String password;
    private String confirmPassword;
    private String address;
    private String contactNumber;
    private String email;

    // Setters for user information
    public void setUsername(String username) {
        // You can perform validation or additional processing here if needed
        this.username = username;
    }
    public void setFirstname(String username) {
        // You can perform validation or additional processing here if needed
        this.firstname = firstname;
    }
    public void setLastame(String username) {
        // You can perform validation or additional processing here if needed
        this.lastame = lastame;
    }

    public void setPassword(String password) {
        // You can perform validation or additional processing here if needed
        this.password = password;
    }

    public void setConfirmPassword(String confirmPassword) {
        // You can perform validation or additional processing here if needed
        this.confirmPassword = confirmPassword;
    }

    public void setAddress(String address) {
        // You can perform validation or additional processing here if needed
        this.address = address;
    }

    public void setContactNumber(String contactNumber) {
        // You can perform validation or additional processing here if needed
        this.contactNumber = contactNumber;
    }
    public void setEmail(String username) {
        // You can perform validation or additional processing here if needed
        this.email = email;
    }


    private void showUserInterface(Stage primaryStage) {
        new LoginDemo(primaryStage);

    }

// add method here to store these info in the DB




        //showPassIcon.setOnMouseClicked(e -> toggleOnPasswordVisibility(passwordTextField,showPassIcon,hiddenPassIcon,showTextField));
         //hiddenPassIcon.setOnMouseClicked(e -> toggleOffPasswordVisibility(passwordTextField,showPassIcon,hiddenPassIcon,showTextField));

         //showConPassIcon.setOnMouseClicked(e -> toggleOnConPasswordVisibility(conPasswordTextField,showConPassIcon,hiddenConPassIcon,showConTextField));
         //hiddenConPassIcon.setOnMouseClicked(e -> toggleOffConPasswordVisibility(conPasswordTextField,showConPassIcon,hiddenConPassIcon,showConTextField));

         @FXML
         private void toggleOffPasswordVisibility(PasswordField passwordTextField, ImageView showPassIcon, ImageView hiddenPassIcon,TextField showtextField) {
        System.out.println("toggle off");


        passwordTextField.setText(showtextField.getText());
        showtextField.setVisible(false);
        passwordTextField.setVisible(true);

        showPassIcon.setVisible(true);
        hiddenPassIcon.setVisible(false);
    }
    private void toggleOnPasswordVisibility(PasswordField passwordTextField, ImageView showPassIcon, ImageView hiddenPassIcon,TextField showtextField){
        System.out.println("toggle On");

        showtextField.setText(passwordTextField.getText());
        passwordTextField.setVisible(false);
        showtextField.setVisible(true);

        hiddenPassIcon.setVisible(true);
        showPassIcon.setVisible(false);

    }

    private void toggleOnConPasswordVisibility(PasswordField passwordTextField, ImageView showPassIcon, ImageView hiddenPassIcon,TextField showtextField){
        System.out.println("toggle On");

        showtextField.setText(passwordTextField.getText());
        passwordTextField.setVisible(false);
        showtextField.setVisible(true);

        hiddenPassIcon.setVisible(true);
        showPassIcon.setVisible(false);

    }
    private void toggleOffConPasswordVisibility(PasswordField passwordTextField, ImageView showPassIcon, ImageView hiddenPassIcon,TextField showtextField){
        System.out.println("toggle off");


        passwordTextField.setText(showtextField.getText());
        showtextField.setVisible(false);
        passwordTextField.setVisible(true);

        showPassIcon.setVisible(true);
        hiddenPassIcon.setVisible(false);
    }



}
