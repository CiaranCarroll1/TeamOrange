package business.logic.menu;

public class Main implements MenuItem{
    
    @Override
    public String getName()
    {
        return "Main";
    }
    
    @Override
    public double getCost()
    {
        return 13.50;
    }
}
