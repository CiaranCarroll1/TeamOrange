package data;

import business.logic.order.Order;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class OrderHandler implements IDataHandler{
    File orderFile;
    
    public OrderHandler() {
        this.orderFile = new File("Orders.txt");
    }
    
    @Override
    public ArrayList<String> getData()
    {
        ArrayList<String> strings = new ArrayList<>();
        String lineFromFile;
        try {
            Scanner in = new Scanner(orderFile);
            while(in.hasNext())
            {
                lineFromFile = in.nextLine();
                strings.add(lineFromFile);
            }   
            in.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(OrderHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return strings;
    }
    
    @Override
    public void updateData(ArrayList<String> lines)
    {	
        PrintWriter OutFile = null;
        try {
            OutFile = new PrintWriter(orderFile);
            for(String i: lines)
            {
                OutFile.println(i.toString());
            }   OutFile.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(OrderHandler.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            OutFile.close();
        }
    }
}
