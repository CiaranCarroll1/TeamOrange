package ui.controller;

import business.service.LoginService;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import ui.view.Views;

public class LoginController extends ViewController implements Initializable {
    
    @FXML private TextField username;
    @FXML private PasswordField password;
    private boolean validLogin = false;
    private LoginService service;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        service = new LoginService();
    }
    
    @FXML
    private void loginClicked(ActionEvent event) throws IOException {
        Alert a = new Alert(Alert.AlertType.NONE);
        
        String uname = username.getText();
        String pword = password.getText();
        if(service.validateLogin(uname,pword))
        {
            loadView(event, Views.MainMenu);
        }
        else
        {
            username.setText("");
            password.setText("");
            a.setAlertType(Alert.AlertType.ERROR);
            a.setContentText("Invalid Login"); 
            a.show(); 
        }
        
    }
    
}
