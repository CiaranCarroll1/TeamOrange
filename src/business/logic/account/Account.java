package business.logic.account;

import business.logic.account.discount.BronzeDiscount;
import business.logic.account.discount.GoldDiscount;
import business.logic.account.discount.IDiscount;
import business.logic.account.discount.SilverDiscount;

public class Account {
    private int phoneNumber;
    private String forename;
    private String surname;
    private IDiscount discount;
    private int mealCount;
    
    public Account(int phoneNumber, String forename, String surname)
    {
        this.phoneNumber = phoneNumber;
        this.forename = forename;
        this.surname = surname;
        this.mealCount = 0;
        this.discount = new BronzeDiscount();
    }
    
    public Account(int phoneNumber, String forename, String surname, int mealCount, IDiscount discount)
    {
        this.phoneNumber = phoneNumber;
        this.forename = forename;
        this.surname = surname;
        this.mealCount = mealCount;
        this.discount = discount;
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
    
    public void setDiscount(IDiscount discount)
    {
        this.discount = discount;
    }
    
    public void addMealCount()
    {
        mealCount++;
        
        if(mealCount >= 10)
        {
            setDiscount(new GoldDiscount());
        }
        else if(mealCount >= 5)
        {
            setDiscount(new SilverDiscount());
        }
        else
        {
            //Do nothing
        }
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
    
    public double getDiscount()
    {
        return discount.getDiscount();
    }
    
    public int getMealCount()
    {
        return mealCount;
    }
    
    @Override
    public String toString()
    {
        String result = forename + "," + surname + "," + phoneNumber + "," + mealCount + "," + discount.getName();

        return result;
    }
}