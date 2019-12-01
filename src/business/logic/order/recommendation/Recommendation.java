package business.logic.order.recommendation;

import business.logic.menu.IMenuItem;
import business.logic.menu.Menu;
import java.util.ArrayList;
import java.util.Random;

public class Recommendation {
    private ArrayList<IMenuItem> starters;
    private ArrayList<IMenuItem> mains;
    private ArrayList<IMenuItem> desserts;
    
    public ArrayList<IMenuItem> getRecommendation()
    {
        ArrayList<IMenuItem> items = new ArrayList<>();
        Menu menu = new Menu();
        starters = menu.getStarters();
        mains = menu.getMains();
        desserts = menu.getDesserts();
        
        Random rand = new Random();

        int randomNum;       
        
        randomNum = rand.nextInt((2) + 1);
        items.add(starters.get(randomNum));
        randomNum = rand.nextInt((2) + 1);
        items.add(mains.get(randomNum));
        randomNum = rand.nextInt((2) + 1);
        items.add(desserts.get(randomNum));
        
        return items;
    }
}
