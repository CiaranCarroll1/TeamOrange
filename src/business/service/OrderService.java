package business.service;

import business.logic.menu.factory.MenuItemFactory;
import business.logic.order.Order;
import data.OrderHandler;
import java.util.ArrayList;

public class OrderService {
    
    OrderHandler handler = new OrderHandler();
    
    public void newOrder(Order order)
    {
        ArrayList<String> lines = handler.getData();
        lines.add(order.toString());
        
        handler.updateData(lines);
    }

    public ArrayList<Order> getOrders() {
        ArrayList<String> orderStrings = handler.getData();
        
        ArrayList<Order> Orders = new ArrayList<>();
        String lineFromFile;
        int customerPhoneNumber, orderNumber, tableNumber;
        double totalPrice;
        String[] split;
        Order anOrder;
        MenuItemFactory factory = new MenuItemFactory();
        
        for(String line: orderStrings)
            {
                split = line.split(",");
                customerPhoneNumber = Integer.parseInt(split[0]);
                orderNumber = Integer.parseInt(split[1]);
                tableNumber = Integer.parseInt(split[2]);
                totalPrice = Double.parseDouble(split[3]);
                
                anOrder = new Order(customerPhoneNumber,orderNumber,tableNumber,totalPrice);
                
                for(int i = 4; i < split.length; i++)
                {
                    anOrder.addMenuItem(factory.getMenuItem(split[i]));
                }
                Orders.add(anOrder);
            }
        
        return Orders;
    }
    
    public void completeOrder(Order order)
    {
        
    }
}
