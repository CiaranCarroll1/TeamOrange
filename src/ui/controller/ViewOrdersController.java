package ui.controller;

import business.logic.order.Order;
import business.logic.payment.PayStrategy;
import business.service.OrderService;
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
    private OrderService service;
    private ArrayList<Order> orders;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        list.setContent(new VBox());
        service = new OrderService();
        updateList();
    }
    
    @FXML
    private void goBack(ActionEvent event) throws IOException {
        loadView(event, Views.Order); 
    }
    
    private void updateList()
    {
	VBox orderView = (VBox) list.getContent();
	orderView.getChildren().clear();
        orders = service.getOrders();

        for(Order order: orders)
	{
            if(order.getStatus() == 0)
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
                    service.completeOrder(order);
                    try {
                        loadViewAndSendPrice(event, order.getPrice());
                    } catch (IOException ex) {
                        Logger.getLogger(ViewOrdersController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                });

                row.getChildren().addAll(
                new Label(order.getOrderNumber() + "\t"),
                new Label(order.getTableNumber() + "\t"),
                    editOrder,
                    completeOrder);
                orderView.getChildren().add(row);
            }
	}
    }
}
