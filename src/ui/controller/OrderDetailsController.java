package ui.controller;

import business.logic.order.recommendation.Recommendation;
import business.service.OrderService;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import business.logic.menu.IMenuItem;
import java.util.ArrayList;
import javafx.scene.control.TextField;
import ui.view.Views;

public class OrderDetailsController extends ViewController implements Initializable {

    @FXML private TextField phoneNo;
    @FXML private TextField tableNo;
    @FXML private Label rec1;
    @FXML private Label rec2;
    @FXML private Label rec3;
    private OrderService service;
    private Recommendation recommend= new Recommendation();
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        service = new OrderService();
        ArrayList<IMenuItem> items = recommend.getRecommendation();
        rec1.setText(items.get(0).getName());
        rec2.setText(items.get(1).getName());
        rec3.setText(items.get(2).getName());
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
