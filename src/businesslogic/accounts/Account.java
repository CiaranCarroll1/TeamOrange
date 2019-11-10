package businesslogic.accounts;

public class Account {
    private int id;
    private String forename;
    private String surname;
    //private Level;
    
    public Account(int id, String forename, String surname)
    {
        this.id = id;
        this.forename = forename;
        this.surname = surname;
        //this.level = level;
    }
    
    public void setId(int id)
    {
        this.id = id;
    }
    
    public void setForename(String forename)
    {
        this.forename = forename;
    }
    
    public void setSurname(String surname)
    {
        this.surname = surname;
    }
    
    public int getId()
    {
        return id;
    }
    
    public String getForename()
    {
        return forename;
    }
    
    public String getSurname()
    {
        return surname;
    }
}