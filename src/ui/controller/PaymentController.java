package ui.controller;

import business.logic.order.Order;
import business.logic.payment.PayByCard;
import business.logic.payment.PayByCash;
import business.logic.payment.PayContext;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import ui.view.Views;

public class PaymentController extends ViewController implements Initializable {

    private PayContext payContext;
    private double price;
    private Alert a;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        payContext = new PayContext();
        a = new Alert(Alert.AlertType.CONFIRMATION);
    } 
    
    @FXML
    private void payByCash(ActionEvent event) throws IOException {
        payContext.setPaymentStrategy(new PayByCash());
        payContext.pay(price);
        a.setContentText("Payment by cash completed!"); 
        a.show();
        loadView(event, Views.ViewOrders); 
    }
    
    @FXML
    private void payByCard(ActionEvent event) throws IOException {
        payContext.setPaymentStrategy(new PayByCard());
        payContext.pay(price);
        a.setContentText("Payment by card completed!"); 
        a.show();
        loadView(event, Views.ViewOrders); 
    }
    
    public void receiveOrder(double price)
    {
        this.price = price;
    }
    
}
