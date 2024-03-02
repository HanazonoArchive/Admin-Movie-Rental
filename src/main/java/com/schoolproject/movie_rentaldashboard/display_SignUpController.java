package com.schoolproject.movie_rentaldashboard;

import com.schoolproject.database.UserFunctions;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class display_SignUpController  {

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

    private String username  ;
    private String firstname ;
    private String lastame ;
    private String password ;
    private String confirmPassword ;
    private String address ;
    private String contactNumber ;
    private String email;

    private String MRR;
    private Stage primaryStage;
    // Add a setter method to set the primaryStage
    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }


    // Setters for user information
    /*public String setUsername(){
        this.username = userNameTextField.getText();

        return this.username;
    }
    public String setFirstname(){
        this.firstname = firstNameTextField.getText();
        return this.firstname;

    }
    public String setLastame (){
        this.lastame = lastNameTextField.getText();
        return this.lastame;

    }
    public String setPassword (){
        this.password = passwordTextField.getText();
        return this.password;

    }
    public String setConfirmPassword (){
        this.confirmPassword = conPasswordTextField.getText();
        return confirmPassword;
    }
    public String setAddress (){
        this.address = addressTextField.getText();
        return this.address;
    }
    public String setContactNumber (){
        this.contactNumber = contactNumberTextField.getText();
        return this.contactNumber;
    }
    public String setEmail (){
        this.email = EmailTextField.getText();
        return this.email;
    }*/

    public void dataCollection(){
        UserFunctions signUp = new UserFunctions();
        signUp.addNewUser(username,password,firstname,lastame,contactNumber,email,address,MRR);
        showAlert("Added Succesfully");
    }

    @FXML
    public void Register(){
        username = userNameTextField.getText();
        firstname = firstNameTextField.getText();
        lastame = lastNameTextField.getText();
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
        if (username.isEmpty() || password.isEmpty() || firstname.isEmpty() || lastame.isEmpty() || contactNumber.isEmpty() || email.isEmpty() || address.isEmpty()) {
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
    }

    private void showAlert(String message) {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }


    public void showPassword(){
        showPassIcon.setOnMouseClicked(e -> toggleOnPasswordVisibility(passwordTextField,showPassIcon,hiddenPassIcon,showTextField));
    }
    public void hidePassword(){
        hiddenPassIcon.setOnMouseClicked(e -> toggleOffPasswordVisibility(passwordTextField,showPassIcon,hiddenPassIcon,showTextField));
    }
    public void showConPassword(){
        showConPassIcon.setOnMouseClicked(e -> toggleOnConPasswordVisibility(conPasswordTextField,showConPassIcon,hiddenConPassIcon,showConTextField));
    }
    public void hideConPassword(){
        hiddenConPassIcon.setOnMouseClicked(e -> toggleOffConPasswordVisibility(conPasswordTextField,showConPassIcon,hiddenConPassIcon,showConTextField));
    }


         @FXML
         private void toggleOffPasswordVisibility(PasswordField passwordTextField, ImageView showPassIcon, ImageView hiddenPassIcon,TextField showtextField) {
        System.out.println("toggle off");


        passwordTextField.setText(showtextField.getText());
        showtextField.setVisible(false);
        passwordTextField.setVisible(true);

        showPassIcon.setVisible(true);
        hiddenPassIcon.setVisible(false);
    }
    @FXML
    private void toggleOnPasswordVisibility(PasswordField passwordTextField, ImageView showPassIcon, ImageView hiddenPassIcon,TextField showtextField){
        System.out.println("toggle On");

        showtextField.setText(passwordTextField.getText());
        passwordTextField.setVisible(false);
        showtextField.setVisible(true);

        hiddenPassIcon.setVisible(true);
        showPassIcon.setVisible(false);

    }
@FXML
    private void toggleOnConPasswordVisibility(PasswordField passwordTextField, ImageView showPassIcon, ImageView hiddenPassIcon,TextField showtextField){
        System.out.println("toggle On");

        showtextField.setText(passwordTextField.getText());
        passwordTextField.setVisible(false);
        showtextField.setVisible(true);

        hiddenPassIcon.setVisible(true);
        showPassIcon.setVisible(false);

    }
    @FXML
    private void toggleOffConPasswordVisibility(PasswordField passwordTextField, ImageView showPassIcon, ImageView hiddenPassIcon,TextField showtextField){
        System.out.println("toggle off");


        passwordTextField.setText(showtextField.getText());
        showtextField.setVisible(false);
        passwordTextField.setVisible(true);

        showPassIcon.setVisible(true);
        hiddenPassIcon.setVisible(false);
    }




}
