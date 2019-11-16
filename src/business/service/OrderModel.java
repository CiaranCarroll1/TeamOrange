package business.service;

import business.logic.order.Order;
import data.DataHandler;
import java.io.FileNotFoundException;

public class OrderModel {
    
    DataHandler handler = new DataHandler();
    
    public void newOrder(Order order) throws FileNotFoundException
    {
        handler.addNewOrder(order);
    }
    
}
