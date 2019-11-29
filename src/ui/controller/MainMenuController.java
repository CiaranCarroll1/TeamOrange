package ui.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import ui.view.Views;

public class MainMenuController extends ViewController implements Initializable {

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }
    
    @FXML
    private void AccountClicked(ActionEvent event) throws IOException {
            loadView(event, Views.Account); 
    }
    
    @FXML
    private void OrderClicked(ActionEvent event) throws IOException {
            loadView(event, Views.Order); 
    }
    
    @FXML
    private void UserClicked(ActionEvent event) throws IOException {
            loadView(event, Views.User); 
    }
    
    @FXML
    private void logOutClicked(ActionEvent event) throws IOException {
            loadView(event, Views.Login);
    }  
}
