package business.logic.menu.beverage;

import business.logic.menu.IMenuItem;

public class Fanta implements IMenuItem {
    
    @Override
    public String getName()
    {
        return "Fanta";
    }
    
    @Override
    public double getCost()
    {
        return 2.0;
    }
}
