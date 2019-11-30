package business.logic.menu.main;

import business.logic.menu.IMenuItem;

public class Salmon implements IMenuItem {
    
    @Override
    public String getName()
    {
        return "Salmon";
    }
    
    @Override
    public double getCost()
    {
        return 15.0;
    }
}
