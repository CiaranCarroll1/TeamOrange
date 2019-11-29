package business.service;

import business.logic.order.Order;
import data.OrderHandler;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class OrderService {
    
    OrderHandler handler = new OrderHandler();
    
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
