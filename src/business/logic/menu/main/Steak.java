package business.logic.menu.main;

import business.logic.menu.IMenuItem;

public class Steak implements IMenuItem {
    
    @Override
    public String getName()
    {
        return "Steak";
    }
    
    @Override
    public double getCost()
    {
        return 21.0;
    }
}
