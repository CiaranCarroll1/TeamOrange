package business.logic.user;

public class User {
    private String username;
    private String password;
    private int phoneNumber;
    private String forename;
    private String surname;
    
    public User(String username, String password, int phoneNumber, String forename, String surname)
    {
        this.username = username;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.forename = forename;
        this.surname = surname;
    }
    
    public String getUsername()
    {
        return username;
    }
    
    public String getPassword()
    {
        return password;
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
     public String setUsername(String newSurname)
    {   
        this.surname = newSurname;
        return username;
    }
    
    public String setPassword(String newPassword)
    {
        this.password = newPassword;
        return password;
    }
    public int setPhoneNumber(int newPhoneNumber)
    {
        this.phoneNumber = newPhoneNumber;
        return phoneNumber;
    }
    public String setForename(String newForename)
    {
        this.forename = newForename;
        return forename;
    }
    public String setSurname(String newSurname)
    {
        this.surname = newSurname;
        return surname;
    }
    
    @Override
    public String toString()
    {
        String result = username + "," + password + "," + phoneNumber + "," + forename + "," + surname;
        
        return result;
    }
}
