

package ui.controller; 
import business.logic.account.Account;
import business.logic.user.User;
import business.service.AccountService;
import business.service.UserService;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.HBox;
import ui.view.Views;
import static ui.view.Views.Account;

/*
public class EditAccountController extends ViewController implements Initializable {

    
    @FXML private ScrollPane list;
    private Account account;
    private AccountService service;
    private ArrayList<Account> accounts;
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        list.setContent(new VBox());
        service = new AccountService();
        try {
            updateList();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(EditAccountController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
    
    @FXML
    private void returnBack(ActionEvent event) throws IOException {
        loadView(event, Views.Account); 
    }

    private void updateList() throws FileNotFoundException
    {
	VBox UserView = (VBox) list.getContent();
	UserView.getChildren().clear();
        accounts = service.getAllUsers();

        for(Account acount: accounts)
	{
            
            HBox row = new HBox();
            row.setPadding(new Insets(0, 0, 5, 0));
            row.setSpacing(40);

            Button editUserAccount = new Button("Edit Account");

            row.getChildren().addAll(
            new Label(account.getForename() + "\t" + "\t"),
                editUserAccount);
            UserView.getChildren().add(row);
            
	}
    }
}

    
    
    */

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import ui.view.Views;
import javafx.scene.layout.VBox;





/**
 * FXML Controller class
 *
 */
public class EditAccountController extends ViewController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    @FXML private ScrollPane list;
    private Account account;
    private AccountService service;
    private ArrayList<Account> accounts;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        list.setContent(new VBox());
        service = new AccountService();
        updateList();
    }    
    
    @FXML
    private void returnBack(ActionEvent event) throws IOException {
        loadView(event, Views.Account); 
    }

    private void updateList() {
        
        VBox UserView = (VBox) list.getContent();
	UserView.getChildren().clear();
        accounts = service.getAccounts();
        /*
        for(Account account: accounts)
	{
            
            HBox row = new HBox();
            row.setPadding(new Insets(0, 0, 5, 0));
            row.setSpacing(40);

            Button editUserAccount = new Button("Edit Account");

            row.getChildren().addAll(
            new Label(account.getForename() + "\t" + "\t"),
                editUserAccount);
            UserView.getChildren().add(row);
            
	}
        */
    }

}