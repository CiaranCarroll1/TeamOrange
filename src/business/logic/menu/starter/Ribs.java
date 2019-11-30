package business.logic.menu.starter;

import business.logic.menu.IMenuItem;

public class Ribs implements IMenuItem{
    
    @Override
    public String getName()
    {
        return "Ribs";
    }
    
    @Override
    public double getCost()
    {
        return 6.0;
    }
}
