package business.logic.menu.main;

import business.logic.menu.IMenuItem;

public class Salad implements IMenuItem {
    
    @Override
    public String getName()
    {
        return "Salad";
    }
    
    @Override
    public double getCost()
    {
        return 11.00;
    }
}
