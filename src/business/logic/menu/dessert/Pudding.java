package business.logic.menu.dessert;

import business.logic.menu.IMenuItem;

public class Pudding implements IMenuItem {
    
    @Override
    public String getName()
    {
        return "Pudding";
    }
    
    @Override
    public double getCost()
    {
        return 8.0;
    }
}
