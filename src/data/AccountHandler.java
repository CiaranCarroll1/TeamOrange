/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import business.logic.account.Account;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class AccountHandler {
    File accountFile;
    
    public AccountHandler() {
        this.accountFile = new File("Accounts.txt");
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
	String[] split;
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
    
    public void addAccount(Account anAccount) throws FileNotFoundException 
    {
        ArrayList<Account> accounts = getAccounts();
        accounts.add(anAccount);
        writeAccounts(accounts);
    }
    
    public void writeAccounts(ArrayList<Account> accounts) throws FileNotFoundException
    {	
        PrintWriter OutFile = new PrintWriter(accountFile);
	for(Account i: accounts)
	{
            OutFile.println(i.toString());
	}
	OutFile.close();
    }
}
