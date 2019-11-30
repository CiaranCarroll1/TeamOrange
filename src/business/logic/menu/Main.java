package business.logic.menu;

public class Main implements IMenuItem{
    
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
