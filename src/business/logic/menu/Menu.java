package business.logic.menu;

import business.logic.menu.beverage.Beer;
import business.logic.menu.beverage.Coke;
import business.logic.menu.beverage.Fanta;
import business.logic.menu.dessert.Cheesecake;
import business.logic.menu.dessert.Icecream;
import business.logic.menu.dessert.Pudding;
import business.logic.menu.main.Salad;
import business.logic.menu.main.Salmon;
import business.logic.menu.main.Steak;
import business.logic.menu.starter.Ribs;
import business.logic.menu.starter.Soup;
import business.logic.menu.starter.Wings;
import java.util.ArrayList;

public class Menu {
    private ArrayList<IMenuItem> starters = new ArrayList<>();
    private ArrayList<IMenuItem> mains = new ArrayList<>();
    private ArrayList<IMenuItem> desserts = new ArrayList<>();
    private ArrayList<IMenuItem> beverages = new ArrayList<>();
    
    public ArrayList<IMenuItem> getStarters()
    {
        starters.add(new Soup());
        starters.add(new Ribs());
        starters.add(new Wings());
         
        return starters;
    }
    
    public ArrayList<IMenuItem> getMains()
    {
        mains.add(new Steak());
        mains.add(new Salmon());
        mains.add(new Salad());
         
        return mains;
    }
    
    public ArrayList<IMenuItem> getDesserts()
    {
        desserts.add(new Cheesecake());
        desserts.add(new Pudding());
        desserts.add(new Icecream());
         
        return desserts;
    }
    
    public ArrayList<IMenuItem> getBeverages()
    {
        beverages.add(new Coke());
        beverages.add(new Fanta());
        beverages.add(new Beer());
         
        return beverages;
    }
}
