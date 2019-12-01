package ui.controller;

import business.logic.account.Account;
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
import business.logic.menu.factory.MenuItemFactory;
import business.service.AccountService;
import javafx.scene.control.Alert;

public class CreateOrderController extends ViewController implements Initializable {
    
    @FXML private Label price;
    @FXML private Label discount;
    @FXML private Label finalPrice;
    @FXML private ScrollPane list;
    private Order customerOrder;
    private OrderService service;
    private AccountService aService;
    private int orderNumber, tableNumber;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        list.setContent(new VBox());
        service = new OrderService();
        aService = new AccountService();
    }
    
    @FXML
    private void submitOrderClicked(ActionEvent event) throws IOException {
        service.submitOrder(customerOrder);
        
        
        Alert a = new Alert(Alert.AlertType.NONE);
        a.setAlertType(Alert.AlertType.CONFIRMATION);
        a.setContentText("Order submitted"); 
        a.show();
        
        loadView(event, Views.Order);
        
    }
    
    @FXML
    private void cancelOrderClicked(ActionEvent event) throws IOException {
        loadView(event, Views.Order);
    }
    
    @FXML
    private void addMenuItemClicked(ActionEvent event) throws IOException {
        String val = ((Button)event.getSource()).getText();
        MenuItemFactory factory = new MenuItemFactory();
        customerOrder.addMenuItem(factory.getMenuItem(val));
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
            		
            Button removeItem = new Button("-");
            removeItem.setOnAction(event ->
            {
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
        
        double pri = customerOrder.getPrice();
        double dis = 0.0;
        double fin = 0.0;
        double disAmount = 0.0;
        if(customerOrder.getAccount().getPhoneNumber() != 0)
        {
            dis = customerOrder.getAccount().getDiscount();
            fin = pri * dis;
            disAmount = pri - fin;
        }
        
        
        price.setText(String.format("%.2f", pri));
        discount.setText(String.format("%.2f", disAmount));
        finalPrice.setText(String.format("%.2f", fin));
    }
    
    public void receiveOrder(Order customerOrder)
    {
        this.customerOrder = customerOrder;
        updateList();
    }
    
    public void receiveDetails(int accountNumber, int tableNumber)
    {
        int orderNumber = service.getNextOrderNumber();
        Account account = aService.getAccount(accountNumber);
        
        customerOrder = new Order(account, orderNumber, tableNumber);
        updateList();
    }
    
}
