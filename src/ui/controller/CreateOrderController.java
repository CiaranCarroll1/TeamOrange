package ui.controller;

import business.logic.menu.Beverage;
import business.logic.menu.Dessert;
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
import business.logic.menu.MenuItem;
import business.logic.menu.Starter;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.Window;

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
        
        Alert a = new Alert(Alert.AlertType.NONE);
        a.setAlertType(Alert.AlertType.CONFIRMATION);
        a.setContentText("Order submitted"); 
        a.show();
        
        loadView(event, Views.Order);
        
        /*
        final Stage dialog = new Stage();
                dialog.initModality(Modality.APPLICATION_MODAL);
        Window primaryStage = null;
                dialog.initOwner(primaryStage);
                VBox dialogVbox = new VBox(20);
                dialogVbox.getChildren().add(new Text("This is a Dialog"));
                Scene dialogScene = new Scene(dialogVbox, 300, 200);
                dialog.setScene(dialogScene);
                dialog.show();
        */
    }
    
    @FXML
    private void cancelOrderClicked(ActionEvent event) throws IOException {
        loadView(event, Views.Order);
    }
    
    @FXML
    private void addStarter(ActionEvent event) throws IOException {
        customerOrder.addMenuItem(new Starter());
        updateList();
    }
    
     @FXML
    private void addMain(ActionEvent event) throws IOException {
        customerOrder.addMenuItem(new Main());
        updateList();
    }
    
    @FXML
    private void addDessert(ActionEvent event) throws IOException {
        customerOrder.addMenuItem(new Dessert());
        updateList();
    }
    
    @FXML
    private void addBeverage(ActionEvent event) throws IOException {
        customerOrder.addMenuItem(new Beverage());
        updateList();
    }
    
    private void updateList()
    {
	VBox itemView = (VBox) list.getContent();
	itemView.getChildren().clear();

        for(MenuItem item: customerOrder.getOrderItems())
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
        updateList();
    }
    
}
