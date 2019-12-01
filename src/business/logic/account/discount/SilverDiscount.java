package business.logic.account.discount;

public class SilverDiscount implements IDiscount{
    
    @Override
    public String getName()
    {
        return "Bronze";
    }
    
    @Override
    public double getDiscount()
    {
        return 0.90;
    }
}
