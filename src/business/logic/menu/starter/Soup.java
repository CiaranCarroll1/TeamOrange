package business.logic.menu.starter;

import business.logic.menu.IMenuItem;

public class Soup implements IMenuItem {
    
    @Override
    public String getName()
    {
        return "Soup";
    }
    
    @Override
    public double getCost()
    {
        return 4.50;
    }
}
