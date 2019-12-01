package ui.controller;

import business.logic.user.User;
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
import javafx.scene.layout.VBox;
import ui.view.Views;

public class ViewUsersController extends ViewController implements Initializable {
    
    @FXML private ScrollPane list;
    private User user;
    private UserService service;
    private ArrayList<User> users;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        list.setContent(new VBox());
        service = new UserService();
        try {
            updateList();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ViewUsersController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @FXML
    private void goBack(ActionEvent event) throws IOException {
        loadView(event, Views.User); 
    }
    
    private void updateList() throws FileNotFoundException
    {
	VBox UserView = (VBox) list.getContent();
	UserView.getChildren().clear();
        users = service.getAllUsers();

        for(User user: users)
	{
            
                HBox row = new HBox();
                row.setPadding(new Insets(0, 0, 5, 0));
                row.setSpacing(40);
                
                Button editUserAccount = new Button("Edit User Account");
                
                row.getChildren().addAll(
                new Label(user.getUsername() + "\t" + "\t"),
                    editUserAccount);
                UserView.getChildren().add(row);
            
	}
    }
}
