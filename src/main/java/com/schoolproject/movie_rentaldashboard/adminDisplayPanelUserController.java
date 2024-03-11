package com.schoolproject.movie_rentaldashboard;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

public class adminDisplayPanelUserController implements Initializable {

    public static String log;

    @FXML
    private Button UserDelete_Button;

    @FXML
    private TableView<UserInfoClass> UserInfoTable;

    @FXML
    private Button UserLoad_Button;

    @FXML
    private Button UserSave_Button;

    @FXML
    private TableView<UserClass> UserTable;

    @FXML
    private TableColumn<UserClass, String> colContactNo;

    @FXML
    private TableColumn<UserClass, String> colEmail;

    @FXML
    private TableColumn<UserClass, String> colNameUser;

    @FXML
    private TableColumn<UserClass, String> colUserID;

    @FXML
    private TableColumn<UserInfoClass, String> colUserMovieDate;

    @FXML
    private TableColumn<UserInfoClass, String> colUserMovieDateRented;

    @FXML
    private TableColumn<UserInfoClass, String> colUserMovieName;

    @FXML
    private TableColumn<UserInfoClass, String> colUserMovieRentedDays;

    @FXML
    private TableColumn<UserClass, String> colUserPassword;

    @FXML
    private TableColumn<UserClass, String> colUsername;

    @FXML
    private AnchorPane display_panel;

    @FXML
    private TextField tfContactNo;

    @FXML
    private TextField tfEmail;

    @FXML
    private TextField tfName;

    @FXML
    private TextField tfPassword;

    @FXML
    private TextField tfUserID;

    @FXML
    private TextField tfUsername;

    @FXML
    private TableColumn<UserClass, String> colRefUserID;

    private ObservableList<UserClass> userClassList = FXCollections.observableArrayList();

    private ObservableList<UserInfoClass> userInfoClassList = FXCollections.observableArrayList();

    public void setScreenDisplay(AnchorPane homeDisplay) {
        homeDisplay.getChildren().setAll(display_panel);
    }

    @FXML
    void HandlesClicks(ActionEvent event) {
        if(event.getSource() == UserLoad_Button){
            AddingUserMovieSQL();
            LoadSelectedUser();
            LoadUserMovieData();
        } else if (event.getSource() == UserDelete_Button){
            DeleteSelectedUser();
        } else if (event.getSource() == UserSave_Button) {
            SaveChanges();
        } else {
            // Logger
            log = "";
            PrintLog(log);
        }
    }

    public void LoadSelectedUser(){
        // Logger
        log = "Action: Clicked -> ID: LoadSelectedUser -> Class: adminDisplayPanelUserController -> Status: Success";
        PrintLog(log);

        UserClass SelectedUser = UserTable.getSelectionModel().getSelectedItem();
        if(SelectedUser != null){
            tfUserID.setText(SelectedUser.getUserID());
            tfUsername.setText(SelectedUser.getUsername());
            tfPassword.setText(SelectedUser.getPassword());
            tfName.setText(SelectedUser.getName());
            tfContactNo.setText(SelectedUser.getContactNo());
            tfEmail.setText(SelectedUser.getEmail());
        } else {
            tfUserID.clear();
            tfUsername.clear();
            tfPassword.clear();
            tfName.clear();
            tfContactNo.clear();
            tfEmail.clear();

            System.err.println("Error: No User selected to load");
        }
    }

    public void DeleteSelectedUser(){
        // Logger
        log = "Action: Clicked -> ID: DeleteSelectedUser -> Class: adminDisplayPanelUserController -> Status: Success";
        PrintLog(log);

        // Selected User
        UserClass SelectedUser = UserTable.getSelectionModel().getSelectedItem();

        if(SelectedUser != null){
            UserTable.getItems().remove(SelectedUser);
            userClassList.remove(SelectedUser);

            //Logger
            log = "Deleted: A Selected User";
            PrintLog(log);
        } else {
            System.err.println("Error: No User selected for deletion");
        }
    }
    
    public void SaveChanges(){
        // Logger
        log = "";
        PrintLog(log);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // User Data
        colUserID.setCellValueFactory(new PropertyValueFactory<>("userID"));
        colUsername.setCellValueFactory(new PropertyValueFactory<>("username"));
        colUserPassword.setCellValueFactory(new PropertyValueFactory<>("password"));
        colNameUser.setCellValueFactory(new PropertyValueFactory<>("name"));
        colContactNo.setCellValueFactory(new PropertyValueFactory<>("contactNo"));
        colEmail.setCellValueFactory(new PropertyValueFactory<>("email"));

        // User Info Data
        colUserMovieName.setCellValueFactory(new PropertyValueFactory<>("userInfoMovie"));
        colUserMovieDate.setCellValueFactory(new PropertyValueFactory<>("userInfoMovieDate"));
        colUserMovieRentedDays.setCellValueFactory(new PropertyValueFactory<>("userInfoMovieRentedDays"));
        colUserMovieDateRented.setCellValueFactory(new PropertyValueFactory<>("userInfoMovieRentedDate"));
        colRefUserID.setCellValueFactory(new PropertyValueFactory<>("userInfoMovieRefID"));

        AddingUserSQL();
    }

    public void LoadUserMovieData(){
        UserClass selectedUser = UserTable.getSelectionModel().getSelectedItem();

        if(selectedUser != null) {
            UserInfoTable.getItems().clear();

            String selectedUserID = selectedUser.getUserID();

            // Loop through userInfoClassList to find matching movie data
            for(UserInfoClass userInfo : userInfoClassList) {
                // Check if the user ID matches with colUserInfoRefID
                if(userInfo.getUserInfoMovieRefID().equals(selectedUserID)) {
                    // Add the matching movie data to the UserInfoTable
                    UserInfoTable.getItems().add(userInfo);
                }
            }
        } else {
            System.err.println("Error: No user selected to load movie data");
        }
    }

    public void AddingUserSQL(){
        // Test Data
        UserClass addUser = new UserClass("1","Hanazono","password","Jay Mark V Agsoy","09551004950", "hanazonodatabase@gmail.com");
        userClassList.add(addUser);
        UserTable.getItems().add(addUser);
    }

    public void AddingUserMovieSQL(){
        // Test Data
        UserInfoClass MovieData1 = new UserInfoClass("Your Name", "03/26/2016", "Unlimited","04/21/2023", "1");
        UserInfoClass MovieData2 = new UserInfoClass("Beyond the boundary", "03/26/2016", "Unlimited","04/21/2023", "1");
        UserInfoClass MovieData3 = new UserInfoClass("Silent Voice", "03/26/2016", "Unlimited","04/21/2023", "1");
        userInfoClassList.addAll(MovieData1, MovieData2,MovieData3);
    }

    public void PrintLog(String log){
        System.out.println(log);
    }

}
