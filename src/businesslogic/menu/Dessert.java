package businesslogic.menu;

public class Dessert implements MenuItem{
    
    @Override
    public String getName()
    {
        return "Dessert";
    }
    
    @Override
    public double getCost()
    {
        return 8.50;
    }
    
}
