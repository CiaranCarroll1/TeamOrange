package business.logic.menu.beverage;

import business.logic.menu.IMenuItem;

public class Coke implements IMenuItem {
    
    @Override
    public String getName()
    {
        return "Coke";
    }
    
    @Override
    public double getCost()
    {
        return 2.0;
    }
}
