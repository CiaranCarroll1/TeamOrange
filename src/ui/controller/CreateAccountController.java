package ui.controller;

import business.logic.account.Account;
import business.service.AccountModel;
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

public class CreateAccountController extends ViewController implements Initializable {

    @FXML private TextField forename;
    @FXML private TextField surname;
    @FXML private TextField phoneNumber;
    private Account newAccount;
    private AccountModel model;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        model = new AccountModel();
    }
    
    @FXML
    private void createClicked(ActionEvent event) throws IOException
    {
        Alert a = new Alert(AlertType.NONE);
        
        try {
        String fname = forename.getText();
        String sname = surname.getText();
        int pnumber = Integer.parseInt(phoneNumber.getText()); 
        
        if(model.alreadyRegistered(pnumber))
        {
            forename.setText("");
            surname.setText("");
            phoneNumber.setText("");
            a.setAlertType(AlertType.ERROR);
            a.setContentText("That phone number is already attached to an account!"); 
            a.show();
        }
        else
        {
            newAccount = new Account(pnumber, fname, sname);
            model.registerAccount(newAccount);
            a.setAlertType(AlertType.CONFIRMATION);
            a.setContentText("New Account Created!"); 
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
        loadView(event, Views.MainMenu); 
    }
}
