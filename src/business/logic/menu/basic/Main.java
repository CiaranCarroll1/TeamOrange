package business.logic.menu.basic;

import business.logic.menu.IMenuItem;

public class Main implements IMenuItem{
    
    @Override
    public String getName()
    {
        return "Main";
    }
    
    @Override
    public double getCost()
    {
        return 13.50;
    }
}
