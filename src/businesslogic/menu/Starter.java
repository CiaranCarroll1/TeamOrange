package businesslogic.menu;

import businesslogic.menu.MenuItem;

public class Starter implements MenuItem{
    
    @Override
    public String getName()
    {
        return "Starter";
    }
    
    @Override
    public double getCost()
    {
        return 5.0;
    }
}