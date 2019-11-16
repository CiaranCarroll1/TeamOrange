package ui.controller;

import business.service.LoginModel;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginController extends ViewController implements Initializable {
    
    @FXML private TextField username;
    @FXML private PasswordField password;
    private boolean validLogin = false;
    private LoginModel model;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        model = new LoginModel();
    }
    
    @FXML
    private void loginClicked(ActionEvent event) throws IOException {
        Alert a = new Alert(Alert.AlertType.NONE);
        
        String uname = username.getText();
        String pword = password.getText();
        if(model.validateLogin(uname,pword))
        {
            System.out.println("Valid login!");
            loadScreen(event, "/ui/view/mainmenu.fxml");
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
