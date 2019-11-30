package ui.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import ui.view.Views;

public class OrderController extends ViewController implements Initializable {

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }
    
    @FXML
    private void createOrderClicked(ActionEvent event) throws IOException {
            loadView(event, Views.OrderDetails); 
    }
    
    @FXML
    private void viewOrdersClicked(ActionEvent event) throws IOException {
            loadView(event, Views.ViewOrders); 
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
