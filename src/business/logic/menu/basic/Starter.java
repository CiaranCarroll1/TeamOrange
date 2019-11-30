package business.logic.menu.basic;

import business.logic.menu.IMenuItem;
import business.logic.menu.IMenuItem;

public class Starter implements IMenuItem{
    
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
