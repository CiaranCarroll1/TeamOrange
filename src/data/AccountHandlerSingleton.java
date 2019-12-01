package data;

import business.logic.account.Account;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class AccountHandlerSingleton implements IDataHandler{
    
    private static AccountHandlerSingleton connector;
    
    
    public static AccountHandlerSingleton getInstance() 
    {    
        if (connector==null)  
        {  
            connector = new  AccountHandlerSingleton();  
        }  
        return connector;  
    }
    
    private static File getConnection()
    {  
        File con = new File("Accounts.txt");  
        return con;  

    }
    
    public ArrayList<Integer> getPhoneNumbers() throws FileNotFoundException
    {
        
        
        File con = connector.getConnection();
        
        ArrayList<Integer> phoneNumbers = new ArrayList<>();
        String lineFromFile;
	String[] split;
	
	Scanner in = new Scanner(con);
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
	File con = connector.getConnection();
	Scanner in = new Scanner(con);
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
        File con = connector.getConnection();
        PrintWriter OutFile = new PrintWriter(con);
	for(Account i: accounts)
	{
            OutFile.println(i.toString());
	}
	OutFile.close();
    }

    @Override
    public ArrayList<String> getData() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateData(ArrayList<String> strings) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
