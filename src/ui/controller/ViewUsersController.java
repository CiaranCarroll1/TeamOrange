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
    private ArrayList<User> users; //stores user data as an array list of their data type
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        list.setContent(new VBox());
        service = new UserService(); //connection to user service
        try {
            updateList();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ViewUsersController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @FXML
    private void goBack(ActionEvent event) throws IOException {
        loadView(event, Views.User);  //sends user back a layer
    }
    
    private void updateList() throws FileNotFoundException //updates the lsit displayed of users
    {
	VBox UserView = (VBox) list.getContent();
	UserView.getChildren().clear();
        users = service.getUsers();

        for(User user: users)
	{
            
                HBox row = new HBox();
                row.setPadding(new Insets(0, 0, 5, 0));
                row.setSpacing(40);
                
                Button editUserAccount = new Button("Edit User Account"); //yet to be implemented....used to edit specific user
                



                row.getChildren().addAll(
                new Label(user.getUsername() + "\t" + "\t"), // labels will contain a singler user and its username
                    editUserAccount);
                UserView.getChildren().add(row);
            
	}
    }
}
