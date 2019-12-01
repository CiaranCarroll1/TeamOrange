package business.logic.account.discount;

public class SilverDiscount implements IDiscount{
    
    @Override
    public String getName()
    {
        return "Silver";
    }
    
    @Override
    public double getDiscount()
    {
        return 10.0;
    }
}
