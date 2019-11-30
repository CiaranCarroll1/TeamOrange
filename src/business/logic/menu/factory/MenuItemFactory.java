package business.logic.menu.factory;

import business.logic.menu.Beverage;
import business.logic.menu.Dessert;
import business.logic.menu.IMenuItem;
import business.logic.menu.Starter;
import business.logic.menu.Main;

public class MenuItemFactory {
    public IMenuItem getMenuItem(String name) {
        switch(name)
        {
            case "Starter":
                return new Starter();
            case "Main":
                return new Main();
            case "Dessert":
                return new Dessert();
            case "Beverage":
                return new Beverage();
            default:
                return null;
        }
    }
}
