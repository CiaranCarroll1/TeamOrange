package business.logic.menu.beverage;

import business.logic.menu.IMenuItem;

public class Beer implements IMenuItem {
    
    @Override
    public String getName()
    {
        return "Beer";
    }
    
    @Override
    public double getCost()
    {
        return 5.0;
    }
}
