package data;

import business.logic.order.Order;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UserHandlerSingleton implements IDataHandler{
    private static UserHandlerSingleton connector;
    
    public static UserHandlerSingleton getInstance() 
    {    
        if (connector==null)  
        {  
            connector = new  UserHandlerSingleton();  
        }  
        return connector;  
    }
    
    private static File getConnection()
    {  
        File con = new File("Users.txt");  
        return con;  

    }  
    
    @Override
    public ArrayList<String> getData() // returns all data as a stinrg....all user data from the tect file
    {
        File con = connector.getConnection();
        
        ArrayList<String> strings = new ArrayList<>();
        String lineFromFile;
        try {
            Scanner in = new Scanner(con);
            while(in.hasNext())
            {
                lineFromFile = in.nextLine();
                strings.add(lineFromFile);
            }   
            in.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(OrderHandlerSingleton.class.getName()).log(Level.SEVERE, null, ex);
        }
        return strings;
    }
    
    @Override
    public void updateData(ArrayList<String> lines) // used to update the user text file with details
    {	
        File con = connector.getConnection();
        
        PrintWriter OutFile = null;
        try {
            OutFile = new PrintWriter(con);
            for(String i: lines)
            {
                OutFile.println(i.toString());
            }   OutFile.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(OrderHandlerSingleton.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            OutFile.close();
        }
    }
}
