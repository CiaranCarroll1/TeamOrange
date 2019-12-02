

package ui.controller; 
import business.logic.account.Account;

import business.service.AccountService;
import java.util.ArrayList;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.HBox;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import ui.view.Views;
import javafx.scene.layout.VBox;


public class EditAccountController extends ViewController implements Initializable {

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
        
        for(Account account: accounts)
	{
            
        HBox row = new HBox();
        row.setPadding(new Insets(0, 0, 5, 0));
        row.setSpacing(40);

        Button editUserAccount = new Button("Edit User Account");

        row.getChildren().addAll(
        new Label(account.getForename() + "\t" + "\t"),
            editUserAccount);
        UserView.getChildren().add(row);
	}
        
    }

}