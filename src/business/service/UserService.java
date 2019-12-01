package business.service;

import business.logic.user.User;
import data.UserHandler;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class UserService {
    
    ArrayList<User> users;
    ArrayList<Integer> phoneNumbers;
    UserHandler handler = new UserHandler();
    
    public boolean validName(String name)
    {
        boolean valid = false;    
        String namePat = "[a-zA-Z]+";
        
        if(name.matches(namePat))
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
    
    public void registerUser(User aUser) throws FileNotFoundException
    {
        handler.addUser(aUser);
    }
    public ArrayList<User> getAllUsers() throws FileNotFoundException
    {
    
    users = handler.getUsers();
    
    return users;
    }
    
}
