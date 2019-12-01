package business.service;

import business.logic.menu.factory.MenuItemFactory;
import business.logic.order.Order;
import business.logic.order.state.ActiveState;
import data.OrderHandlerSingleton;
import java.util.ArrayList;

public class OrderService {
    
    OrderHandlerSingleton handler = OrderHandlerSingleton.getInstance();
    
    public void submitOrder(Order order)
    {
        boolean old = false;
        
        ArrayList<Order> orders = getOrders();
        ArrayList<String> lines = new ArrayList<>();
        
        for(Order i: orders)
        {
            if(i.getOrderNumber() == order.getOrderNumber())
            {
                i.updateItems(order.getOrderItems());
                lines.add(i.toString());
                old = true;
            }
            else
                lines.add(i.toString());
        }
        
        if(!old)
            lines.add(order.toString());
        
        
        handler.updateData(lines);
    }

    public ArrayList<Order> getOrders() {
        ArrayList<String> orderStrings = handler.getData();
        
        ArrayList<Order> Orders = new ArrayList<>();
        String lineFromFile;
        int customerPhoneNumber, orderNumber, tableNumber, status;
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
                status = Integer.parseInt(split[4]);
                
                anOrder = new Order(customerPhoneNumber,orderNumber,tableNumber,totalPrice,status);
                
                for(int i = 5; i < split.length; i++)
                {
                    anOrder.addMenuItem(factory.getMenuItem(split[i]));
                }
                Orders.add(anOrder);
            }
        
        return Orders;
    }
    
    public void completeOrder(Order order)
    {
        ArrayList<Order> orders = getOrders();
        ArrayList<String> lines = new ArrayList<>();
        
        for(Order i: orders)
        {
            if(i.getOrderNumber() == order.getOrderNumber())
            {
                i.changeState();
                i.setOrderNumber(0);
            }
            lines.add(i.toString());
        }
        
        handler.updateData(lines);
    }
    
    public int getNextOrderNumber()
    {
        int number = 0;
        boolean found = false;
        ArrayList<Integer> orderNumbers = getOrderNumbers();
        
        for(int i = 1; !found; i++)
            if(!(orderNumbers.contains(i)))
            {
                number = i;
                found = true;
            }
        
        return number;
    }
    
    public ArrayList<Integer> getOrderNumbers()
    {
        ArrayList<Order> orders = getOrders();
        ArrayList<Integer> orderNumbers = new ArrayList<>();
        for(Order i: orders)
            orderNumbers.add(i.getOrderNumber());
        
        return orderNumbers;
    }
}
