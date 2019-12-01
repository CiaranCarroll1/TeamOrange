package business.logic.order;

import business.logic.account.Account;
import java.util.ArrayList;
import business.logic.menu.IMenuItem;
import business.logic.order.state.ActiveState;
import business.logic.order.state.CompletedState;
import business.logic.order.state.OrderState;

public class Order{
    
    private Account account;
    private int orderNumber;
    private int tableNumber;
    private OrderState state;
    private double totalPrice;
    private ArrayList<IMenuItem> orderItems;
    
    public Order(Account account, int orderNumber, int tableNumber)
    {
        this.account = account;
        this.orderNumber = orderNumber;
        this.tableNumber = tableNumber;
        this.totalPrice = 0.0;
        this.state = new ActiveState();
        orderItems = new ArrayList<>();
    }
    
    public Order(Account account, int orderNumber, int tableNumber, double totalPrice, int status)
    {
        this.account = account;
        this.orderNumber = orderNumber;
        this.tableNumber = tableNumber;
        this.totalPrice = totalPrice;
        if(status == 0)
            this.state = new ActiveState();
        else
            this.state = new CompletedState();
        orderItems = new ArrayList<>();
    }
    
    public void setAccount(Account account)
    {
        this.account = account;
    }
    
    public Account getAccount()
    {
        return account;
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
    
    public void changeState()
    {
        state.change(this);
    }
    
    public void setState(OrderState state)
    {
        this.state = state;
    }
    
    public int getState()
    {
        return state.getStatus();
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
        String result = account.getPhoneNumber() + "," + orderNumber + "," + tableNumber + "," + totalPrice + "," + state.getStatus();    
        
        for(IMenuItem i: orderItems)
            result += "," + i.getName();
        return result;
    }
}
