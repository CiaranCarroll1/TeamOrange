package data;

import business.logic.account.Account;
import business.logic.order.Order;
import business.logic.user.User;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class DataHandler {
    File accountFile;
    File userFile;
    File orderFile;

    public DataHandler() {
        this.accountFile = new File("Accounts.txt");
        this.userFile = new File("Users.txt");
        this.orderFile = new File("ActiveOrders.txt");
    }
    
    public ArrayList<Integer> getPhoneNumbers() throws FileNotFoundException
    {
        ArrayList<Integer> phoneNumbers = new ArrayList<>();
        String lineFromFile;
	String[] split;
	
	Scanner in = new Scanner(accountFile);
        while(in.hasNext())
        {
            lineFromFile = in.nextLine();
            split = lineFromFile.split(",");
            phoneNumbers.add(Integer.parseInt(split[2]));
        }
        in.close();
		
	return phoneNumbers;
    }
    
    public ArrayList<Account> getAccounts() throws FileNotFoundException
    {
        ArrayList<Account> accounts = new ArrayList<>();
        String lineFromFile, forename, surname, phoneNumber;
	String[] split;
	Account anAccount;
		
	Scanner in = new Scanner(accountFile);
        while(in.hasNext())
        {
            lineFromFile = in.nextLine();
            split = lineFromFile.split(",");
            forename = split[0];
            surname = split[1];
            phoneNumber = split[2];
            anAccount = new Account(Integer.parseInt(phoneNumber), forename, surname);
            accounts.add(anAccount);
	}	
        in.close();
		
	return accounts;	
    }
    
    public void addAccount(Account anAccount) throws FileNotFoundException 
    {
        ArrayList<Account> accounts = getAccounts();
        accounts.add(anAccount);
        writeAccounts(accounts);
    }
    
    public void writeAccounts(ArrayList<Account> accounts) throws FileNotFoundException
    {	
        PrintWriter OutFile = new PrintWriter(accountFile);
	for(Account i: accounts)
	{
            OutFile.println(i.toString());
	}
	OutFile.close();
    }
    
    public ArrayList<User> getUsers() throws FileNotFoundException
    {
        ArrayList<User> users = new ArrayList<>();
        String lineFromFile, username, password;
	String[] split;
	User aUser;
		
	Scanner in = new Scanner(userFile);
        while(in.hasNext())
        {
            lineFromFile = in.nextLine();
            split = lineFromFile.split(",");
            username = split[0];
            password = split[1];
            aUser = new User(username, password);
            users.add(aUser);
	}	
        in.close();
		
	return users;	
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
