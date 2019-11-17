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
        // TODO
    }
    
    @FXML
    private void createAccountClicked(ActionEvent event) throws IOException {
            loadView(event, Views.CreateAccount); 
    }
    
    @FXML
    private void createOrderClicked(ActionEvent event) throws IOException {
            loadView(event, Views.Order); 
    }
    
    @FXML
    private void viewOrdersClicked(ActionEvent event) throws IOException {
            loadView(event, Views.ViewOrders); 
    }
    
    @FXML
    private void logOutClicked(ActionEvent event) throws IOException {
            loadView(event, Views.Login);
    }
    
}
