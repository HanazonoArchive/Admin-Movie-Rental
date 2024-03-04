package com.schoolproject.movie_rentaldashboard;

import com.schoolproject.database.UserFunctions;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.input.KeyCode;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.IOException;


public class LoginDemo {

    public LoginDemo(Stage primaryStage) {

        Image icon = new Image(getClass().getResource("/com/schoolproject/movie_rentaldashboard/home_ui_navbar_icons/logo.png").toExternalForm());;
        primaryStage.getIcons().add(icon);


        // Create BorderPane
        BorderPane root = new BorderPane();
        root.setPrefSize(700, 500);

        // For left AnchorPane
        AnchorPane leftAnchorPane = new AnchorPane();
        leftAnchorPane.setPrefSize(400, 500);
        leftAnchorPane.setStyle("-fx-background-color: #30D5C8;");

        /*  Text for left anchor pane "Title"
        Text movieRentalTitle = new Text("Paolo's Movie Rental");
        movieRentalTitle.setLayoutX(33);
        movieRentalTitle.setLayoutY(283);
        movieRentalTitle.setFont(Font.font("MV Boli", 29));
        movieRentalTitle.setFill(Color.WHITE);*/
        ImageView logo = new ImageView(getClass().getResource("/com/schoolproject/movie_rentaldashboard/home_ui_navbar_icons/LogoTemp.png").toExternalForm());;
        logo.setLayoutX(-320);
        logo.setLayoutY(90);
        logo.setFitWidth(250);
        logo.setFitHeight(300);

        leftAnchorPane.getChildren().add(logo);

        // Set left AnchorPane in BorderPane
        root.setLeft(leftAnchorPane);

        // For right AnchorPane
        AnchorPane rightAnchorPane = new AnchorPane();
        rightAnchorPane.setPrefSize(350, 200);

        //  Text for login title
        Text loginTitle = new Text("User Login");
        loginTitle.setLayoutX(113);
        loginTitle.setLayoutY(158);
        loginTitle.setFont(Font.font("Berlin Sans FB", 29));

        // TextField for username
        TextField usernameField = new TextField();
        usernameField.setLayoutX(101);
        usernameField.setLayoutY(213);
        usernameField.setPromptText("Username");
        usernameField.setStyle("-fx-background-color: #abd1c6;");

        //  PasswordField for password
        PasswordField passwordField = new PasswordField();
        passwordField.setLayoutX(101);
        passwordField.setLayoutY(262);
        passwordField.setPromptText("Password");
        passwordField.setStyle("-fx-background-color: #abd1c6;");

        // Login Button
        Button loginButton = new Button("Login");
        loginButton.setLayoutX(128);
        loginButton.setLayoutY(332);
        loginButton.setPrefSize(75, 32);
        loginButton.setStyle(
                                "-fx-background-color: linear-gradient(to right, #29323c, #485563, #2b5876, #4e4376), #004643;" +
                                "-fx-background-radius: 50px;" +
                                "-fx-background-insets: 0;" +
                                "-fx-text-fill: white;" +
                                "-fx-font-size: 14px;" +
                                "-fx-font-weight: 600;" +
                                "-fx-padding: 10 20;" + // Adjust padding as needed
                                "-fx-cursor: hand;" + // Change cursor to pointer
                                "-fx-alignment: center;" +
                                "-fx-pref-width: 90px;" +
                                "-fx-pref-height: 32px;" +
                                "-fx-effect: dropshadow(three-pass-box, rgba(45, 54, 65, 0.75), 10, 0, 0, 0);" // Shadow effect
);

        loginButton.setTextFill(javafx.scene.paint.Color.WHITE);
        loginButton.setOnAction(e -> loginAuthentication(usernameField,passwordField,primaryStage));

        Button signUpButton = new Button("Sign Up");
        signUpButton.setLayoutX(147);
        signUpButton.setLayoutY(290);
        signUpButton.setStyle("-fx-background-color: transparent; -fx-text-fill: #506A88; -fx-border-color: transparent; ");
        signUpButton.setFont(Font.font(10));
        signUpButton.setOnAction(e -> showSignUpInterface(primaryStage));

        //  Hyperlink for login as admin - idk if its right to use hyperlink might change later
        Button adminLoginButton = new Button("Login as Admin");
        adminLoginButton.setLayoutX(119);
        adminLoginButton.setLayoutY(444);
        adminLoginButton.setStyle("-fx-background-color: transparent; -fx-text-fill: black; -fx-border-color: transparent; ");
        adminLoginButton.setFont(Font.font(14));
        adminLoginButton.setOnAction(e -> showAdminInterface(primaryStage));
        //Image icon for titl
        ImageView userIcon = new ImageView(getClass().getResource("/com/schoolproject/movie_rentaldashboard/home_ui_navbar_icons/man.png").toExternalForm());;
        userIcon.setLayoutX(125);
        userIcon.setLayoutY(25);
        userIcon.setFitHeight(100);
        userIcon.setFitWidth(100);


        //show password
        ImageView hiddenPassIcon = new ImageView(getClass().getResource("/com/schoolproject/movie_rentaldashboard/home_ui_navbar_icons/eye.png").toExternalForm());;
        hiddenPassIcon.setLayoutX(260);
        hiddenPassIcon.setLayoutY(263);
        hiddenPassIcon.setFitHeight(24);
        hiddenPassIcon.setFitHeight(24);
        hiddenPassIcon.setVisible(false);

        ImageView showPassIcon = new ImageView(getClass().getResource("/com/schoolproject/movie_rentaldashboard/home_ui_navbar_icons/hidden.png").toExternalForm());;
        showPassIcon.setLayoutX(260);
        showPassIcon.setLayoutY(263);
        showPassIcon.setFitHeight(24);
        showPassIcon.setFitHeight(24);

        //Image for username txtfield
        ImageView userNameIcon = new ImageView(getClass().getResource("/com/schoolproject/movie_rentaldashboard/home_ui_navbar_icons/id-card.png").toExternalForm());;
        userNameIcon.setLayoutX(65);
        userNameIcon.setLayoutY(213);
        userNameIcon.setFitHeight(25);
        userNameIcon.setFitWidth(25);

        //Image for passwordfield
        ImageView passwordIcon = new ImageView(getClass().getResource("/com/schoolproject/movie_rentaldashboard/home_ui_navbar_icons/key.png").toExternalForm());;
        passwordIcon.setLayoutX(65);
        passwordIcon.setLayoutY(262);
        passwordIcon.setFitWidth(25);
        passwordIcon.setFitHeight(25);

        //textfield for show password
        TextField showtextField = new TextField();
        showtextField.setVisible(false);
        showtextField.setLayoutX(101);
        showtextField.setLayoutY(262);
        showtextField.setStyle("-fx-background-color: #abd1c6;");

        //implementing the show password
        showPassIcon.setOnMouseClicked(e -> toggleOnPasswordVisibility(passwordField,showPassIcon,hiddenPassIcon,showtextField));
        hiddenPassIcon.setOnMouseClicked(e -> toggleOffPasswordVisibility(passwordField,showPassIcon,hiddenPassIcon,showtextField));


        rightAnchorPane.getChildren().addAll(usernameField, passwordField, loginButton, adminLoginButton, loginTitle,userIcon,userNameIcon,passwordIcon,logo,
                                            signUpButton,hiddenPassIcon,showPassIcon,showtextField);

        // Setting right AnchorPane in BorderPane
        root.setRight(rightAnchorPane);


        Scene scene = new Scene(root);

        scene.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.ENTER) {
                loginButton.fire(); // Fire the login button action
            }
        });
        // Creating Scene and set it to Stage

        primaryStage.setScene(scene);
        primaryStage.setTitle("User Login");
        primaryStage.show();
    }



    private void toggleOnPasswordVisibility(PasswordField passwordField, ImageView showPassIcon, ImageView hiddenPassIcon, TextField showtextField) {
        System.out.println("toggle On");

        showtextField.setText(passwordField.getText());
        passwordField.setVisible(false);
        showtextField.setVisible(true);

        hiddenPassIcon.setVisible(true);
        showPassIcon.setVisible(false);

    }

    private void toggleOffPasswordVisibility(PasswordField passwordField, ImageView showPassIcon, ImageView hiddenPassIcon,TextField showtextField) {
        System.out.println("toggle off");


        passwordField.setText(showtextField.getText());
                showtextField.setVisible(false);
                passwordField.setVisible(true);

                showPassIcon.setVisible(true);
                hiddenPassIcon.setVisible(false);
    }

    private void loginAuthentication(TextField usernameField, PasswordField passwordField, Stage primaryStage){
        UserFunctions verifyLogin = new UserFunctions();
        String username = usernameField.getText();
        String password = passwordField.getText();

        if(username.equals("admin")&&password.equals("password")){
            new ApplicationRental("home_screen.fxml");
            primaryStage.close();
        } else if (verifyLogin.verifyPassword(username,password)) {

            new ApplicationRental("home_screen.fxml");
            display_profileController profileController = new display_profileController();
            profileController.displayBasicInfo(username);
            profileController.displayContactInfo(username);
            primaryStage.close();


        } else {
            JOptionPane.showMessageDialog(null, "Incorrect user or password. Try Again.");
            usernameField.setText("");
            passwordField.setText("");
        }


    }



    private void showAdminInterface(Stage primaryStage) {
        new AdminLogin(primaryStage);
    }

    private void showSignUpInterface(Stage primaryStage) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("display_SignUp.fxml"));
            AnchorPane signUpScreen = loader.load();
            display_SignUpController controller = loader.getController();
            controller.setPrimaryStage(primaryStage); // Pass the primaryStage to the controller


            // Optionally, you can set up the controller or pass any required parameters

            Scene scene = new Scene(signUpScreen);
            primaryStage.setScene(scene);
            primaryStage.setTitle("Sign Up");
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}


