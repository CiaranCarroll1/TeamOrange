package business.logic.order;

import java.util.ArrayList;
import business.logic.menu.MenuItem;

public class Order{
    
    private int customerPhoneNumber;
    private int orderNumber;
    private int tableNumber;
    private double totalPrice;
    private ArrayList<MenuItem> orderItems;
    
    public Order(int customerPhoneNumber, double totalPrice)
    {
        this.customerPhoneNumber = customerPhoneNumber;
        this.totalPrice = totalPrice;
        orderItems = new ArrayList<>();
    }
    
    public Order(int customerPhoneNumber, int orderNumber, int tableNumber)
    {
        this.customerPhoneNumber = customerPhoneNumber;
        this.orderNumber = orderNumber;
        this.tableNumber = tableNumber;
        this.totalPrice = 0.0;
        orderItems = new ArrayList<>();
    }
    
    public Order(int customerPhoneNumber, int orderNumber, int tableNumber, double totalPrice)
    {
        this.customerPhoneNumber = customerPhoneNumber;
        this.orderNumber = orderNumber;
        this.tableNumber = tableNumber;
        this.totalPrice = 0.0;
        orderItems = new ArrayList<>();
    }
    
    public void setCustomerPhoneNumber(int customerPhoneNumber)
    {
        this.customerPhoneNumber = customerPhoneNumber;
    }
    
    public int getCustomerPhoneNumber()
    {
        return customerPhoneNumber;
    }
    
     public void setOrderNumber(int orderNumber)
    {
        this.orderNumber = orderNumber;
    }
    
      public int getOrderNumber()
    {
        return orderNumber;
    }
    
    public void setTableNumber(int tableNumber)
    {
        this.tableNumber = tableNumber;
    }
    
    public int getTableNumber()
    {
        return tableNumber;
    }
    
    public void setPrice(double totalPrice)
    {
        this.totalPrice = totalPrice;
    }
    
    public double getPrice()
    {
        double price = 0;
        
        for(MenuItem i: orderItems)
            price += i.getCost();
        
        return price;
    }
    
    public void addMenuItem(MenuItem item)
    {
        this.orderItems.add(item);
    }
    
    public ArrayList<MenuItem> getOrderItems()
    {
        return orderItems;
    }
    
    public void removeItem(MenuItem item)
    {
        orderItems.remove(item);
    }
    
    @Override
    public String toString()
    {
        String result = customerPhoneNumber + "," + orderNumber + "," + tableNumber + "," + totalPrice + ",";    
        
        for(MenuItem i: orderItems)
            result += "," + i.getName();
        return result;
    }
}
