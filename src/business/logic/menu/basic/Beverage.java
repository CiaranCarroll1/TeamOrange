package business.logic.menu.basic;

import business.logic.menu.IMenuItem;

public class Beverage implements IMenuItem{
    
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
