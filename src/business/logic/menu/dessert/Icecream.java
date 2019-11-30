package business.logic.menu.dessert;

import business.logic.menu.IMenuItem;

public class Icecream implements IMenuItem {
    
    @Override
    public String getName()
    {
        return "Icecream";
    }
    
    @Override
    public double getCost()
    {
        return 5.0;
    }
}
