package business.logic.account.discount;

public class BronzeDiscount implements IDiscount{
    
    @Override
    public String getName()
    {
        return "Bronze";
    }
    
    @Override
    public double getDiscount()
    {
        return 5.0;
    }
}
