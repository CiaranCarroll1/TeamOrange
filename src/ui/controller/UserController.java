package ui.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import ui.view.Views;

public class UserController extends ViewController implements Initializable {

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }
    
    @FXML
    private void createUserClicked(ActionEvent event) throws IOException { //user clicked butten for create
            loadView(event, Views.CreateUser); 
    }
    
    @FXML
    private void editUserClicked(ActionEvent event) throws IOException {
            loadView(event, Views.ViewUsers);                   //loads a list of all users in database
    }
    
    @FXML
    private void logOutClicked(ActionEvent event) throws IOException {
            loadView(event, Views.Login);                //on all screens throughout code used to log out
    }
    
    @FXML
    private void backClicked(ActionEvent event) throws IOException {
            loadView(event, Views.MainMenu); //returns the user back a layer to the main menu
    }
}
