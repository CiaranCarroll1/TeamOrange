package business.service;

import business.logic.order.Order;
import business.logic.user.User;
import business.logic.order.state.ActiveState;
import business.logic.user.User;
import data.UserHandlerSingleton;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class UserService {
    
    UserHandlerSingleton handler = UserHandlerSingleton.getInstance();

    public ArrayList<User> getUsers() {
           ArrayList<String> userStrings = handler.getData();
           ArrayList<User> Users = new ArrayList<>();
        String lineFromFile, username, password, forename, surname;
        int phoneNumber;
	String[] split;
	User aUser;

      for(String line: userStrings)
            {
                split = line.split(",");
                username = split[0];
                password = split[1];
                phoneNumber = Integer.parseInt(split[2]);
                forename = split[3];
                surname = split[4];
                
                aUser = new User(username,password,phoneNumber,forename,surname);
                
                
                Users.add(aUser);
            }
		
	return Users;	
    }
   
    public ArrayList<Integer> getPhoneNumbers() throws FileNotFoundException
    {
         ArrayList<String> userStrings = handler.getData();
         ArrayList<Integer> pnumbers = new ArrayList<>();
        String lineFromFile;
        int phoneNumber;
	String[] split;
	User aUser;

      for(String line: userStrings)
            {
                split = line.split(",");
                phoneNumber = Integer.parseInt(split[2]);

                pnumbers.add(phoneNumber);
            }
		
	return pnumbers;	
    }
    
      public void addUser(User aUser) throws FileNotFoundException 
    {
        ArrayList<User> users = getUsers();
        users.add(aUser);
        ArrayList<String> lines = new ArrayList<>();
        
        users.forEach((i) -> {
            lines.add(i.toString());
        });
        
        handler.updateData(lines);
    }

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
        ArrayList<Integer> phoneNumbers = getPhoneNumbers();
        
        if(phoneNumbers.indexOf(phoneNumber) >= 0)
            valid = true;

        return valid;
    }
     
       public boolean validateLogin(String username, String password) throws FileNotFoundException
    {
        boolean valid = false;
        ArrayList<User> users;
        
        users = getUsers();
        
        for(User u: users)
        {
            if(u.getUsername().equals(username))
                if(u.getPassword().equals(password))
                    valid = true;
        }

        return valid;
    }
}
