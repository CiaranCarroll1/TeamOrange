package data;

import business.logic.user.User;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class UserHandler{
    File userFile;
    
    public UserHandler() {
        this.userFile = new File("Users.txt");
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
}
