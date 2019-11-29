package business.service;

import business.logic.user.User;
import data.UserHandler;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class LoginService {
    
    ArrayList<User> users;
    UserHandler handler = new UserHandler();
    
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
