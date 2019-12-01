package ui.controller;

import business.logic.account.Account;
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
import business.service.AccountService;
import java.util.ArrayList;
import javafx.scene.control.TextField;
import ui.view.Views;
import static ui.view.Views.Account;

public class OrderDetailsController extends ViewController implements Initializable {

    @FXML private TextField phoneNo;
    @FXML private TextField tableNo;
    @FXML private Label rec1;
    @FXML private Label rec2;
    @FXML private Label rec3;
    private OrderService service;
    private AccountService aService;
    private Recommendation recommend= new Recommendation();
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        service = new OrderService();
        aService = new AccountService();
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
                Account account = aService.getAccount(pn);
                if(account.getPhoneNumber() != 0)
                    loadViewAndSendDetails(event, pn, tn);
                else
                {
                    phoneNo.setText("");
                    a.setAlertType(Alert.AlertType.ERROR);
                    a.setContentText("Account does not exist!"); 
                    a.show();
                }
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
