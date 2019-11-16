package business.service;

import business.logic.user.User;
import data.DataHandler;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class LoginModel {
    
    ArrayList<User> users;
    DataHandler handler = new DataHandler();
    
    public boolean validateLogin(String username, String password) throws FileNotFoundException
    {
        boolean valid = false;
        
        users = handler.getUsers();
        
        for(User u: users)
        {
            if(u.getUsername().equals(username))
                if(u.getPassword().equals(password))
                    valid = true;
        }

        return valid;
    }
    
}
