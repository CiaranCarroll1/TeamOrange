package business.service;

import business.logic.account.Account;
import business.logic.account.discount.DiscountFactory;
import business.logic.account.discount.IDiscount;
import data.AccountHandlerSingleton;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class AccountService {
    
    ArrayList<Account> accounts;
    ArrayList<Integer> phoneNumbers;
    AccountHandlerSingleton handler = AccountHandlerSingleton.getInstance();
    
    public ArrayList<Account> getAccounts()
    {
        DiscountFactory factory = new DiscountFactory();
        ArrayList<String> lines = handler.getData();
        ArrayList<Account> accounts = new ArrayList<>();
        String lineFromFile, forename, surname, phoneNumber, mealCount;
        IDiscount discount;
	String[] split;
	Account anAccount;

        for(String i: lines)
        {
            lineFromFile = i;
            split = lineFromFile.split(",");
            forename = split[0];
            surname = split[1];
            phoneNumber = split[2];
            mealCount = split[3];
            discount = factory.getDiscount(split[4]);
            anAccount = new Account(Integer.parseInt(phoneNumber), forename, surname, Integer.parseInt(mealCount), discount);
            accounts.add(anAccount);
	}	
		
	return accounts;	
    }
    
    public boolean validName(String name)
    {
        boolean valid = false;    
        String namePattern = "[a-zA-Z]+";
        
        if(name.matches(namePattern))
            valid = true;
        
        return valid;
    }
    
     public boolean validPhoneNumber(String phoneNumber)
    {
        boolean valid = false;
        String pnPattern = "[0-9]+";
        
        if(phoneNumber.matches(pnPattern))
            valid = true;
        
        return valid;
    }
     
    public ArrayList<Integer> getPhoneNumbers()
    {
        ArrayList<String> lines = handler.getData();
        ArrayList<Integer> phoneNumbers = new ArrayList<>();
        String lineFromFile;
	String[] split;
	
        for(String i: lines)
        {
            lineFromFile =i;
            split = lineFromFile.split(",");
            phoneNumbers.add(Integer.parseInt(split[2]));
        }
		
	return phoneNumbers;
    }
    
    public boolean alreadyRegistered(int phoneNumber)
    {
        boolean valid = false;
        phoneNumbers = getPhoneNumbers();
        
        if(phoneNumbers.indexOf(phoneNumber) >= 0)
            valid = true;

        return valid;
    }
    
    
    
    public void registerAccount(Account account)
    {
        boolean old = false;
        
        ArrayList<Account> accounts = getAccounts();
        accounts.add(account);
        ArrayList<String> lines = new ArrayList<>();
        
        for(Account i: accounts)
        {
            lines.add(i.toString());
        }
        
        handler.updateData(lines);
    }
    
    public void newOrder(Account account)
    {
        ArrayList<Account> accounts = getAccounts();
        ArrayList<String> lines = new ArrayList<>();
        
        for(Account i: accounts)
        {
            if(account.getPhoneNumber() == i.getPhoneNumber())
            {
                i.addMealCount();
                lines.add(i.toString());
            }
            else
                lines.add(i.toString());
        }
    
        handler.updateData(lines);
    }
    
    public Account getAccount(int customerPhoneNumber)
    {
        ArrayList<Account> accounts = getAccounts();
        Account account = new Account(0, "0", "0");
        
        for(Account i: accounts)
        {
            if(customerPhoneNumber == i.getPhoneNumber())
                account = i;
        }
        return account;
    }
    
}
