package business.service;

import business.logic.order.Order;
import data.DataHandler;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class OrderModel {
    
    DataHandler handler = new DataHandler();
    
    public void newOrder(Order order) throws FileNotFoundException
    {
        handler.addNewOrder(order);
    }

    public ArrayList<Order> getActiveOrders() throws FileNotFoundException {
        return handler.getActiveOrders();
    }
    
    public void completeOrder(Order order)
    {
        
    }
}
