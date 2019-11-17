package ui.controller;

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
        FXMLLoader loader = new FXMLLoader(getClass().getResource(Views.Order.getValue()));
        Parent viewParent = loader.load();
        Scene viewScene = new Scene(viewParent);
             
        OrderController orderController = loader.getController();
        orderController.receiveOrder(order);
 
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
            
        window.setScene(viewScene);
        window.show();
    }
}