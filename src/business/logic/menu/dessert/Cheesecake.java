package business.logic.menu.dessert;

import business.logic.menu.IMenuItem;

public class Cheesecake implements IMenuItem {
    
    @Override
    public String getName()
    {
        return "Cheesecake";
    }
    
    @Override
    public double getCost()
    {
        return 7.50;
    }
}
