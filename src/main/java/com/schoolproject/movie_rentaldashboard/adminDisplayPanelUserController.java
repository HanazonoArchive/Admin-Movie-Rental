package com.schoolproject.movie_rentaldashboard;

import com.almasb.fxgl.cutscene.Cutscene;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import com.schoolproject.movie_rentaldashboard.dao.mysql.*;
import com.schoolproject.movie_rentaldashboard.model.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import javax.swing.*;

public class adminDisplayPanelUserController implements Initializable {

    public static String log;

    @FXML
    private Button UserDelete_Button;

    @FXML
    private TableView<Customer> UserInfoTable;

    @FXML
    private Button UserLoad_Button;

    @FXML
    private Button UserSave_Button;

    @FXML
    private TableView<Rental> UserRentsTable;

    @FXML
    private TableColumn<Customer, String> customerId;

    @FXML
    private TableColumn<Customer, String> username;

    @FXML
    private TableColumn<Customer, String> firstName;

    @FXML
    private TableColumn<Customer, String> lastName;

    @FXML
    private TableColumn<Customer, String> contactNumber;

    @FXML
    private TableColumn<Customer, String> email;

    @FXML
    private TableColumn<Customer, String> address;

    @FXML
    private AnchorPane display_panel;

    @FXML
    private TextField tfContactNo;

    @FXML
    private TextField tfEmail;

    @FXML
    private TextField tfName;

    @FXML
    private TextField tfUserID;

    @FXML
    private TextField tfUsername;

    @FXML
    private TableColumn<Rental, String> rentalId;

    @FXML
    private TableColumn<Rental, String> movie;

    @FXML
    private TableColumn<Rental, String> rentalDate;

    @FXML
    private TableColumn<Rental, String> returnDate;

    @FXML
    private TableColumn<Rental, String> returned;

    @FXML
    private TableColumn<Rental, String> rentalFee;

    private ObservableList<Customer> customerObservableList = FXCollections.observableArrayList();

    private ObservableList<Rental> rentalObservableList = FXCollections.observableArrayList();

    public void setScreenDisplay(AnchorPane homeDisplay) {
        homeDisplay.getChildren().setAll(display_panel);
    }

    @FXML
    void HandlesClicks(ActionEvent event) {
        if(event.getSource() == UserLoad_Button){
            LoadSelectedUserInfo();
            LoadUserMovieData();
            displayAllCustomerData();
        } else if (event.getSource() == UserDelete_Button){
            removeUserAndCustomerData();
            displayAllCustomerData();
        } else if (event.getSource() == UserSave_Button) {
            displayAllCustomerData();
        } else {
            // Logger
            log = "";
            PrintLog(log);
        }
    }

    public void LoadSelectedUserInfo(){
        // Logger
        log = "Action: Clicked -> ID: LoadSelectedUser -> Class: adminDisplayPanelUserController -> Status: Success";
        PrintLog(log);

        Customer SelectedUser = UserInfoTable.getSelectionModel().getSelectedItem();
        if(SelectedUser != null){
            tfUserID.setText(String.valueOf(SelectedUser.getCustomerId()));
            tfUsername.setText(SelectedUser.getUser().getUsername());
            //tfPassword.setText(SelectedUser.getPassword());
            tfName.setText(SelectedUser.getFirstName() + " " + SelectedUser.getLastName());
            tfContactNo.setText(SelectedUser.getContactNumber());
            tfEmail.setText(SelectedUser.getEmail());
        } else {
            tfUserID.clear();
            tfUsername.clear();
            tfName.clear();
            tfContactNo.clear();
            tfEmail.clear();

            System.err.println("Error: No User selected to load");
        }
    }

    public void LoadUserMovieData() {
        Customer selectedCustomer = UserInfoTable.getSelectionModel().getSelectedItem();

        if(selectedCustomer != null) {
            UserInfoTable.getItems().clear();
            MySQLRentalDAO e = new MySQLRentalDAO();
            List<Rental> rentals = e.getAllRentalsbyCustomerId(selectedCustomer.getCustomerId());
            rentalObservableList = FXCollections.observableList(rentals);

            // Debug: Print the number of rentals
            System.out.println("Number of rentals: " + rentals.size());

            // Debug: Print the contents of rentalObservableList
            rentalObservableList.forEach(System.out::println);

            UserRentsTable.setItems(rentalObservableList);
        } else {
            System.err.println("Error: No user selected to load movie data");
        }
    }

    public void removeUserAndCustomerData(){
        // Logger
        log = "Action: Clicked -> ID: DeleteSelectedUser -> Class: adminDisplayPanelUserController -> Status: Success";
        PrintLog(log);

        // Selected User
        Customer selectedCustomer = UserInfoTable.getSelectionModel().getSelectedItem();

        if(selectedCustomer != null){

            int confirmation = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this user and its data?", "Confirmation", JOptionPane.YES_NO_OPTION);

            if (confirmation == JOptionPane.YES_OPTION) {
                // User confirmed, proceed with deletion
                MySQLCustomerDAO e = new MySQLCustomerDAO();
                MySQLUserDAO f = new MySQLUserDAO();
                String username = selectedCustomer.getUser().getUsername();
                int customerId = selectedCustomer.getCustomerId();
                e.deleteCustomer(customerId);
                f.deleteUser(username);

                // Log the deletion
                log = "Action: Deleted User and Customer Data -> Username: " + selectedCustomer.getUser().getUsername() + " -> CustomerId: " + selectedCustomer.getCustomerId();
                PrintLog(log);
                // remove user and customer data log entry
                MySQLLogsDAO logger = new MySQLLogsDAO();
                String currentUser = "admin";

                LocalDateTime now = LocalDateTime.now();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                String formattedDateTime = now.format(formatter);
                Logs log = new Logs(formattedDateTime, "admin", currentUser, "delete", currentUser + " deleted user and user data - username: " + username + " customerId: " + customerId);
                logger.addLog(log);
            } else {
                // User canceled the deletion
                System.out.println("Deletion canceled.");
            }
        } else {
            System.err.println("Error: No User selected for deletion");
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // User Customer Data
        customerId.setCellValueFactory(new PropertyValueFactory<>("customerId"));
        username.setCellValueFactory(data -> {
            // Get the Customer object from the row data
            Customer customer = data.getValue();
            // Get the User object from the Customer object
            User user = customer.getUser();
            // Return the username from the User object directly
            return new SimpleStringProperty(user.getUsername());
        });
        //colUserPassword.setCellValueFactory(new PropertyValueFactory<>("password"));
        firstName.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        lastName.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        contactNumber.setCellValueFactory(new PropertyValueFactory<>("contactNumber"));
        email.setCellValueFactory(new PropertyValueFactory<>("email"));
        address.setCellValueFactory(new PropertyValueFactory<>("address"));

        // User Rent Data
        rentalId.setCellValueFactory(new PropertyValueFactory<>("rentalId"));
        movie.setCellValueFactory(data -> {
            Rental rental = data.getValue();
            Movie movie = rental.getMovie();
            return new SimpleStringProperty(movie.getTitle());
        });
        rentalDate.setCellValueFactory(new PropertyValueFactory<>("rentalDate"));
        returnDate.setCellValueFactory(new PropertyValueFactory<>("returnDate"));
        returned.setCellValueFactory(cellData -> {
            Boolean status = cellData.getValue().isReturned();
            String displayStatus = status ? "returned" : "on rent";
            return new SimpleStringProperty(displayStatus);
        });
        rentalFee.setCellValueFactory(new PropertyValueFactory<>("rentalFee"));

        displayAllCustomerData();
    }

    public void displayAllCustomerData(){
       MySQLCustomerDAO e = new MySQLCustomerDAO();
       List<Customer> customerListData = new ArrayList<>(e.getAllCustomers());
       customerObservableList = FXCollections.observableList(customerListData);
       UserInfoTable.setItems(customerObservableList);
    }

    public void PrintLog(String log){
        System.out.println(log);
    }

}
