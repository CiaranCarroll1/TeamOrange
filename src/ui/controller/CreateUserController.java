package ui.controller;

import business.logic.user.User;
import business.service.UserService;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;
import ui.view.Views;

public class CreateUserController extends ViewController implements Initializable {

    @FXML private TextField username;
    @FXML private TextField password;
    @FXML private TextField phoneNumber;
    @FXML private TextField forename;
    @FXML private TextField surname;
    private User newUser;
    private UserService service;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        service = new UserService();
    }
    
    @FXML
    private void createClicked(ActionEvent event) throws IOException
    {
        Alert a = new Alert(AlertType.NONE);
        
        try {
            String uname = username.getText();
            String pword = password.getText();
            int pnumber = Integer.parseInt(phoneNumber.getText());
            String fname = forename.getText();
            String sname = surname.getText(); 

            if(service.alreadyRegistered(pnumber))
            {
                forename.setText("");
                surname.setText("");
                phoneNumber.setText("");
                username.setText("");
                password.setText("");
                a.setAlertType(AlertType.ERROR);
                a.setContentText("That phone number is already attached to user account account!"); 
                a.show();
            }
            else
            {
                newUser = new User(uname,pword,pnumber,fname,sname);
                service.registerUser(newUser);
                a.setAlertType(AlertType.CONFIRMATION);
                a.setContentText("New User Account Created!"); 
                a.show();

                loadView(event, Views.MainMenu);
            }
        }
         catch(NumberFormatException e)
        {
            a.setAlertType(AlertType.ERROR);
            a.setContentText("Invalid Phone Number Entered!"); 
            a.show();
        }
    }
    
    @FXML
    private void cancelClicked(ActionEvent event) throws IOException {
        loadView(event, Views.Account); 
    }
}
