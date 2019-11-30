package business.logic.menu.starter;

import business.logic.menu.IMenuItem;

public class Wings implements IMenuItem{
    
    @Override
    public String getName()
    {
        return "Wings";
    }
    
    @Override
    public double getCost()
    {
        return 5.0;
    }
}
