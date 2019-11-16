package business.logic.account;

public class Account {
    private int phoneNumber;
    private String forename;
    private String surname;
    //private Level;
    
    public Account(int phoneNumber, String forename, String surname)
    {
        this.phoneNumber = phoneNumber;
        this.forename = forename;
        this.surname = surname;
        //this.level = level;
    }
    
    public void setphoneNumber(int phoneNumber)
    {
        this.phoneNumber = phoneNumber;
    }
    
    public void setForename(String forename)
    {
        this.forename = forename;
    }
    
    public void setSurname(String surname)
    {
        this.surname = surname;
    }
    
    public int getPhoneNumber()
    {
        return phoneNumber;
    }
    
    public String getForename()
    {
        return forename;
    }
    
    public String getSurname()
    {
        return surname;
    }
    
    @Override
    public String toString()
    {
        String result = forename + "," + surname + "," + phoneNumber;    

        return result;
    }
}