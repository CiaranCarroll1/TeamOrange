package ui.controller;

import business.logic.menu.Main;
import business.logic.order.Order;
import business.service.OrderService;
import javafx.geometry.Insets;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import ui.view.Views;
import business.logic.menu.IMenuItem;

public class CreateOrderController extends ViewController implements Initializable {
    
    @FXML private Label price;
    @FXML private ScrollPane list;
    private Order customerOrder;
    private OrderService service;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        list.setContent(new VBox());
        service = new OrderService();
        customerOrder = new Order(123, 1, 1);
    }
    
    @FXML
    private void submitOrderClicked(ActionEvent event) throws IOException {
        service.newOrder(customerOrder);
        loadView(event, Views.Order);
    }
    
    @FXML
    private void cancelOrderClicked(ActionEvent event) throws IOException {
        loadView(event, Views.Order);
    }
    
     @FXML
    private void addChicken(ActionEvent event) throws IOException {
        customerOrder.addMenuItem(new Main());
        updateList();
    }
    
    @FXML
    private void addBeef(ActionEvent event) throws IOException {
        customerOrder.addMenuItem(new Main());
        updateList();
    }
    
    @FXML
    private void addBacon(ActionEvent event) throws IOException {
        customerOrder.addMenuItem(new Main());
        updateList();
    }
    
    private void updateList()
    {
	VBox itemView = (VBox) list.getContent();
	itemView.getChildren().clear();

        for(IMenuItem item: customerOrder.getOrderItems())
	{
            HBox row = new HBox();
            row.setPadding(new Insets(0, 0, 5, 0));
            row.setSpacing(20);
            // Add button to remove row 		
            Button removeItem = new Button("-");
            removeItem.setOnAction(event ->
            {
		// Remove MenuItem from list
		customerOrder.removeItem(item);
                updateList();
            });

            row.getChildren().addAll(
            new Label(item.getName()),
            new Label(String.format("€ %.2f", item.getCost())),
            removeItem
            );
            itemView.getChildren().add(row);
	}
        
        price.setText(String.format("%.2f", customerOrder.getPrice()));
    }
    
    public void receiveOrder(Order customerOrder)
    {
        this.customerOrder = customerOrder;
    }
    
}
