package ui.controller;

import business.logic.account.Account;
import business.logic.order.Order;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import ui.view.Views;

public abstract class ViewController  {
    
    protected void loadView(ActionEvent event, Views view) throws IOException
    {
        Parent viewParent = FXMLLoader.load(getClass().getResource(view.getValue()));
        Scene viewScene = new Scene(viewParent);
            
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
            
        window.setScene(viewScene);
        window.show();
    }
    
    protected void loadViewAndSendOrder(ActionEvent event, Order order) throws IOException
    {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(Views.CreateOrder.getValue()));
        Parent viewParent = loader.load();
        Scene viewScene = new Scene(viewParent);
             
        CreateOrderController orderController = loader.getController();
        orderController.receiveOrder(order);
 
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
            
        window.setScene(viewScene);
        window.show();
    }
    
    protected void loadViewAndSendDetails(ActionEvent event, int accountNumber, int tableNumber) throws IOException
    {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(Views.CreateOrder.getValue()));
        Parent viewParent = loader.load();
        Scene viewScene = new Scene(viewParent);
             
        CreateOrderController orderController = loader.getController();
        orderController.receiveDetails(accountNumber, tableNumber);
 
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
            
        window.setScene(viewScene);
        window.show();
    }
    
    protected void loadViewAndSendPrice(ActionEvent event, double price) throws IOException
    {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(Views.Payment.getValue()));
        Parent viewParent = loader.load();
        Scene viewScene = new Scene(viewParent);
             
        PaymentController paymentController = loader.getController();
        paymentController.receiveOrder(price);
 
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
            
        window.setScene(viewScene);
        window.show();
    }
}