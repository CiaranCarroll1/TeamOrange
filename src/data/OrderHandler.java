package data;

import business.logic.order.Order;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class OrderHandler {
    File orderFile;
    
    public OrderHandler() {
        this.orderFile = new File("ActiveOrders.txt");
    }
    
    public ArrayList<Order> getActiveOrders() throws FileNotFoundException
    {
        ArrayList<Order> activeOrders = new ArrayList<>();
        String lineFromFile;
        int customerPhoneNumber, orderNumber, tableNumber, totalPrice;
	String[] split;
	Order anOrder;
		
	Scanner in = new Scanner(orderFile);
        while(in.hasNext())
        {
            lineFromFile = in.nextLine();
            split = lineFromFile.split(",");
            customerPhoneNumber = Integer.parseInt(split[0]);
            orderNumber = Integer.parseInt(split[1]);
            tableNumber = Integer.parseInt(split[2]);
            totalPrice = Integer.parseInt(split[3]);
            
            anOrder = new Order(customerPhoneNumber,orderNumber,tableNumber,totalPrice);
            
            for(int i = 4; i < split.length; i++)
            {
                
            }
            activeOrders.add(anOrder);
	}	
        in.close();
		
	return activeOrders;
    }
    
    public void addNewOrder(Order order) throws FileNotFoundException
    {
        ArrayList<Order> orders = getActiveOrders();
        orders.add(order);
        writeOrders(orders);
    }
            
    public void writeOrders(ArrayList<Order> orders) throws FileNotFoundException
    {	
        PrintWriter OutFile = new PrintWriter(orderFile);
	for(Order i: orders)
	{
            OutFile.println(i.toString());
	}
	OutFile.close();
    }
}
