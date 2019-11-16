package ui.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

public class MainMenuController extends ViewController implements Initializable {

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    
    @FXML
    private void createAccountClicked(ActionEvent event) throws IOException {
            loadScreen(event, "/ui/view/createaccount.fxml"); 
    }
    
    @FXML
    private void createOrderClicked(ActionEvent event) throws IOException {
            loadScreen(event, "/ui/view/createorder.fxml"); 
    }
    
    @FXML
    private void logOutClicked(ActionEvent event) throws IOException {
            loadScreen(event, "/ui/view/login.fxml");
    }
    
}
