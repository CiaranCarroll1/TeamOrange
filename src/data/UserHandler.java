package data;

import business.logic.user.User;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
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
        String lineFromFile, username, password, forename, surname;
        int phoneNumber;
	String[] split;
	User aUser;
		
	Scanner in = new Scanner(userFile);
        while(in.hasNext())
        {
            lineFromFile = in.nextLine();
            split = lineFromFile.split(",");
            username = split[0];
            password = split[1];
            phoneNumber = Integer.parseInt(split[2]);
            forename = split[3];
            surname = split[4];
            aUser = new User(username, password, phoneNumber, forename, surname );
            users.add(aUser);
	}	
        in.close();
		
	return users;	
    }
     public ArrayList<Integer> getPhoneNumbers() throws FileNotFoundException
    {
        ArrayList<Integer> phoneNumbers = new ArrayList<>();
        String lineFromFile;
	String[] split;
	
	Scanner in = new Scanner(userFile);
        while(in.hasNext())
        {
            lineFromFile = in.nextLine();
            split = lineFromFile.split(",");
            phoneNumbers.add(Integer.parseInt(split[2]));
        }
        in.close();
		
	return phoneNumbers;
    }
      public void addUser(User aUser) throws FileNotFoundException 
    {
        ArrayList<User> users = getUsers();
        users.add(aUser);
        writeUsers(users);
    }
    
    public void writeUsers(ArrayList<User> users) throws FileNotFoundException
    {	
        PrintWriter OutFile = new PrintWriter(this.userFile);
	for(User i: users)
	{
            OutFile.println(i.toString());
	}
	OutFile.close();
    }
}
