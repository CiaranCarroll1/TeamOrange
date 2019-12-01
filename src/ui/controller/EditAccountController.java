/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import ui.view.Views;






/**
 * FXML Controller class
 *
 */
public class EditAccountController extends ViewController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    private void returnBack(ActionEvent event) throws IOException {
        loadView(event, Views.Account); 
    }

    
    
    
    
}
