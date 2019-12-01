package business.service;

import business.logic.account.Account;
import data.AccountHandlerSingleton;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class AccountService {
    
    ArrayList<Account> accounts;
    ArrayList<Integer> phoneNumbers;
    AccountHandlerSingleton handler = new AccountHandlerSingleton();
    
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
    
    public boolean alreadyRegistered(int phoneNumber) throws FileNotFoundException
    {
        boolean valid = false;
        phoneNumbers = handler.getPhoneNumbers();
        
        if(phoneNumbers.indexOf(phoneNumber) >= 0)
            valid = true;

        return valid;
    }
    
    public void registerAccount(Account anAccount) throws FileNotFoundException
    {
        handler.addAccount(anAccount);
    }
}
