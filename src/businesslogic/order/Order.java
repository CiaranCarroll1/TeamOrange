package businesslogic.order;

import businesslogic.accounts.Account;
import java.util.ArrayList;

public class Order {
    
    private Account customer;
    private ArrayList<MenuItem> orderItems;
    private int orderNumber;
    private int tableNumber;
    private int totalPrice;
    
    Order(int orderNumber, int tableNumber)
    {
        orderItems = new ArrayList<>();
        this.orderNumber = orderNumber;
        this.tableNumber = tableNumber;
        this.totalPrice = 0;
    }
    
    public void setTableNumber(int tableNumber)
    {
        this.tableNumber = tableNumber;
    }
    
    public void setOrderNumber(int orderNumber)
    {
        this.orderNumber = orderNumber;
    }
    
    public int getTableNumber()
    {
        return tableNumber;
    }
    
    public int getOrderNumber()
    {
        return orderNumber;
    }
    
    public void addMenuItem(MenuItem item)
    {
        this.orderItems.add(item);
    }
    
    public ArrayList<MenuItem> getOrderItems()
    {
        return orderItems;
    }
}
