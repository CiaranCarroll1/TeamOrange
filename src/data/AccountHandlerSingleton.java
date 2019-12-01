package data;

import business.logic.account.Account;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AccountHandlerSingleton implements IDataHandler{
    
    private static AccountHandlerSingleton connector;
    
    
    public static AccountHandlerSingleton getInstance() 
    {    
        if (connector==null)  
        {  
            connector = new  AccountHandlerSingleton();  
        }  
        return connector;  
    }
    
    private static File getConnection()
    {  
        File con = new File("Accounts.txt");  
        return con;  

    }
    
    @Override
    public ArrayList<String> getData()
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
    public void updateData(ArrayList<String> lines)
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