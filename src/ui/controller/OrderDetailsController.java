package ui.controller;

import business.service.OrderService;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import ui.view.Views;

public class OrderDetailsController extends ViewController implements Initializable {

    @FXML private TextField phoneNo;
    @FXML private TextField tableNo;
    private OrderService service;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        service = new OrderService();
    }
    
    @FXML
    private void submitClicked(ActionEvent event) throws IOException {
        Alert a = new Alert(Alert.AlertType.NONE);
        
        try {
            int pn = Integer.parseInt(phoneNo.getText());
            int tn = Integer.parseInt(tableNo.getText());

            if(pn == 0)
            {
                loadViewAndSendDetails(event, pn, tn);
            }
            else
            {
                //if(service.accountExists(pn))
                    loadViewAndSendDetails(event, pn, tn);
                /*else
                {
                    phoneNumber.setText("");
                    a.setAlertType(Alert.AlertType.ERROR);
                    a.setContentText("Account does not exist!"); 
                    a.show();
                }
                */
            }
        }
         catch(NumberFormatException e)
        {
            a.setAlertType(Alert.AlertType.ERROR);
            a.setContentText("Invalid Details Entered!"); 
            a.show();
        }
    }
    
    @FXML
    private void backClicked(ActionEvent event) throws IOException {
        loadView(event, Views.Order);
    }
    
}
