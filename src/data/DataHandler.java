package data;

import businesslogic.accounts.Account;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class DataHandler {
    File accountFile;

    public DataHandler() {
        this.accountFile = new File("Accounts.txt");
    }
    
    public void addAccount(Account anAccount) throws FileNotFoundException 
    {
        ArrayList<Account> accounts = getAccounts();
        accounts.add(anAccount);
        writeAccounts(accounts);
    }
    
    public ArrayList<Integer> getPhoneNumbers() throws FileNotFoundException
    {
        ArrayList<Integer> phoneNumbers = new ArrayList<>();
        String lineFromFile;
	String[] split;
	
	Scanner in = new Scanner(accountFile);
        while(in.hasNext())
        {
            lineFromFile = in.nextLine();
            split = lineFromFile.split(",");
            phoneNumbers.add(Integer.parseInt(split[2]));
        }
        in.close();
		
	return phoneNumbers;
    }
    
    public ArrayList<Account> getAccounts() throws FileNotFoundException
    {
        ArrayList<Account> accounts = new ArrayList<>();
        String lineFromFile, forename, surname, phoneNumber;
	String[] split = new String[3];
	Account anAccount;
		
	Scanner in = new Scanner(accountFile);
        while(in.hasNext())
        {
            lineFromFile = in.nextLine();
            split = lineFromFile.split(",");
            forename = split[0];
            surname = split[1];
            phoneNumber = split[2];
            anAccount = new Account(Integer.parseInt(phoneNumber), forename, surname);
            accounts.add(anAccount);
	}	
        in.close();
		
	return accounts;	
    }
    
    public void writeAccounts(ArrayList<Account> accounts) throws FileNotFoundException
    {	
        String result = "";
        Account anAccount;

        PrintWriter OutFile = new PrintWriter(accountFile);
	for(int i = 0; i < accounts.size(); i++)
	{
            result = "";
            anAccount = accounts.get(i);
            result += anAccount.getForename() + ",";
            result += anAccount.getSurname() + ",";
            result += anAccount.getId();
            OutFile.println(result);
		}
		OutFile.close();
    }
}
