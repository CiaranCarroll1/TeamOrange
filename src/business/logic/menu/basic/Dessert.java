package business.logic.menu.basic;

import business.logic.menu.IMenuItem;

public class Dessert implements IMenuItem{
    
    @Override
    public String getName()
    {
        return "Dessert";
    }
    
    @Override
    public double getCost()
    {
        return 8.50;
    }
    
}
