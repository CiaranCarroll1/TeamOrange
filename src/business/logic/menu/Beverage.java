package business.logic.menu;

public class Beverage implements MenuItem{
    
    @Override
    public String getName()
    {
        return "Beverage";
    }
    
    @Override
    public double getCost()
    {
        return 2.0;
    }
    
}