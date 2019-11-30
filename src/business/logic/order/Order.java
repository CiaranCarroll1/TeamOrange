package business.logic.order;

import java.util.ArrayList;
import business.logic.menu.IMenuItem;

public class Order{
    
    private int customerPhoneNumber;
    private int orderNumber;
    private int tableNumber;
    private int status;
    private double totalPrice;
    private ArrayList<IMenuItem> orderItems;
    
    public Order(int customerPhoneNumber, int orderNumber, int tableNumber)
    {
        this.customerPhoneNumber = customerPhoneNumber;
        this.orderNumber = orderNumber;
        this.tableNumber = tableNumber;
        this.totalPrice = 0.0;
        this.status = 0;
        orderItems = new ArrayList<>();
    }
    
    public Order(int customerPhoneNumber, int orderNumber, int tableNumber, double totalPrice, int status)
    {
        this.customerPhoneNumber = customerPhoneNumber;
        this.orderNumber = orderNumber;
        this.tableNumber = tableNumber;
        this.totalPrice = totalPrice;
        this.status = status;
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
    
    public void setStatus(int status)
    {
        this.status = status;
    }
    
    public int getStatus()
    {
        return status;
    }
    
    public void setPrice(double totalPrice)
    {
        this.totalPrice = totalPrice;
    }
    
    public double getPrice()
    {
        double price = 0;
        
        for(IMenuItem i: orderItems)
            price += i.getCost();
        
        return price;
    }
    
    public void addMenuItem(IMenuItem item)
    {
        this.orderItems.add(item);
    }
    
    public ArrayList<IMenuItem> getOrderItems()
    {
        return orderItems;
    }
    
    public void removeItem(IMenuItem item)
    {
        orderItems.remove(item);
    }
    
    public void updateItems(ArrayList<IMenuItem> orderItems)
    {
        this.orderItems = orderItems;
    }
    
    @Override
    public String toString()
    {
        String result = customerPhoneNumber + "," + orderNumber + "," + tableNumber + "," + totalPrice + "," + status;    
        
        for(IMenuItem i: orderItems)
            result += "," + i.getName();
        return result;
    }
}
