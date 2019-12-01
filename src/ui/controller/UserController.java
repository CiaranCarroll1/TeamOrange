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
    private void createUserClicked(ActionEvent event) throws IOException {
            loadView(event, Views.CreateUser); 
    }
    
    @FXML
    private void editUserClicked(ActionEvent event) throws IOException {
            loadView(event, Views.ViewUsers);
    }
    
    @FXML
    private void logOutClicked(ActionEvent event) throws IOException {
            loadView(event, Views.Login);
    }
    
    @FXML
    private void backClicked(ActionEvent event) throws IOException {
            loadView(event, Views.MainMenu);
    }
}
