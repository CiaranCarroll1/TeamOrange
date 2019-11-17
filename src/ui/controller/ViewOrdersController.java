package ui.controller;

import business.logic.menu.MenuItem;
import business.logic.order.Order;
import business.service.OrderModel;
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

public class ViewOrdersController extends ViewController implements Initializable {
    
    @FXML private ScrollPane list;
    private Order customerOrder;
    private OrderModel model;
    private ArrayList<Order> orders;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        list.setContent(new VBox());
        model = new OrderModel();
        orders = model.getActiveOrders();
        updateList();
    }
    
    @FXML
    private void cancelClicked(ActionEvent event) throws IOException {
        loadView(event, Views.MainMenu); 
    }
    
    private void updateList()
    {
	VBox orderView = (VBox) list.getContent();
	orderView.getChildren().clear();

        for(Order order: orders)
	{
            HBox row = new HBox();
            row.setPadding(new Insets(0, 0, 5, 0));
            row.setSpacing(20);
            
            Button editOrder = new Button("Edit");
            editOrder.setOnAction(event ->
            {
                try {
                    loadViewAndSendOrder(event, order);
                } catch (IOException ex) {
                    Logger.getLogger(ViewOrdersController.class.getName()).log(Level.SEVERE, null, ex);
                }
            });
            		
            Button completeOrder = new Button("Complete");
            completeOrder.setOnAction(event ->
            {
		orders.remove(order);
                model.completeOrder(order);
                updateList();
            });

            row.getChildren().addAll(
            new Label(String.valueOf(order.getOrderNumber())),
            editOrder,
            completeOrder
            );
            orderView.getChildren().add(row);
	}
    }
}