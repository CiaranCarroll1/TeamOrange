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
                username = split[0];                            //take username from file
                password = split[1];                            //take passowrd from file
                phoneNumber = Integer.parseInt(split[2]);       //take phonenumber from file needs to be converted for data manipulation
                forename = split[3];                            // takes users forename from file
                surname = split[4];                             //takes users surname from file
                
                aUser = new User(username,password,phoneNumber,forename,surname);
                
                                                                //new user created.......more details to be implemented, address etc.
                
                
                Users.add(aUser);
            }
		
	return Users;	
    }
   
    public ArrayList<Integer> getPhoneNumbers() throws FileNotFoundException //used to get all registerd phone numbers as staff cannnot have the same
    {
         ArrayList<String> userStrings = handler.getData();
         ArrayList<Integer> pnumbers = new ArrayList<>();     //string of parsed data from file
        String lineFromFile;
        int phoneNumber;
	String[] split;
	User aUser;

      for(String line: userStrings)
            {
                split = line.split(",");
                phoneNumber = Integer.parseInt(split[2]);  //number is parsed for data manipulation in future

                pnumbers.add(phoneNumber);
            }
		
	return pnumbers;	
    }
    
      public void addUser(User aUser) throws FileNotFoundException   //used to add/create a new user
    {
        ArrayList<User> users = getUsers();
        users.add(aUser);
        ArrayList<String> lines = new ArrayList<>();
        
        users.forEach((i) -> {
            lines.add(i.toString());
        });
        
        handler.updateData(lines);  //sends data back to handler to update file
    }

    public boolean validName(String name)  //used when loggin in to see if it is an actual name not gibberish
    {
        boolean valid = false;    
        String namePat = "[a-zA-Z]+";
        
        if(name.matches(namePat))
            valid = true;
        
        return valid;
    }
    
     public boolean validPhoneNumber(String phoneNumber) //checks to see if the number is valid ie an actual phone number
    {
        boolean valid = false;
        String pnPattern = "[0-9]+";  //payttern for standard phone number in ireland
        
        if(phoneNumber.matches(pnPattern))
            valid = true;
        
        return valid;
    }
     public boolean alreadyRegistered(int phoneNumber) throws FileNotFoundException 
    {
        boolean valid = false;      
        ArrayList<Integer> phoneNumbers = getPhoneNumbers();  //checks available data to see if the user is already registered
        
        if(phoneNumbers.indexOf(phoneNumber) >= 0)
            valid = true;

        return valid;
    }
     
       public boolean validateLogin(String username, String password) throws FileNotFoundException //used for staf to login
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
