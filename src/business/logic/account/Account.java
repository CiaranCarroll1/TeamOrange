package business.logic.account;

public class Account {
    private int phoneNumber;
    private String forename;
    private String surname;
    private String level;
    private int mealCount;
    
    public Account(int phoneNumber, String forename, String surname)
    {
        this.phoneNumber = phoneNumber;
        this.forename = forename;
        this.surname = surname;
        this.level = level;
        this.mealCount = mealCount;
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
    
    public void setLevel(String level)
    {
        this.level = level;
    }
    
    public void setMealCount(int mealCount)
    {
        this.mealCount = mealCount;
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
    
    public String getLevel()
    {
        return level;
    }
    
    public int getMealCount()
    {
        return mealCount;
    }
    
    @Override
    public String toString()
    {
        String result = forename + "," + surname + "," + phoneNumber;    

        return result;
    }
}