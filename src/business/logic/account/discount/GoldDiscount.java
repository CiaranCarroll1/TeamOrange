package business.logic.account.discount;

public class GoldDiscount implements IDiscount{
    
    @Override
    public String getName()
    {
        return "Gold";
    }
    
    @Override
    public double getDiscount()
    {
        return 0.80;
    }
}
