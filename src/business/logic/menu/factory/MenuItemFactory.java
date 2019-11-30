package business.logic.menu.factory;

import business.logic.menu.basic.Beverage;
import business.logic.menu.basic.Dessert;
import business.logic.menu.IMenuItem;
import business.logic.menu.basic.Starter;
import business.logic.menu.basic.Main;
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
            case "Soup":
                return new Soup();
            case "Wings":
                return new Wings();
            case "Ribs":
                return new Ribs();
            case "Steak":
                return new Steak();
            case "Salmon":
                return new Salmon();
            case "Salad":
                return new Salad();
            case "Cheesecake":
                return new Cheesecake();
            case "Pudding":
                return new Pudding();
            case "Icecream":
                return new Icecream();
            case "Coke":
                return new Coke();
            case "Fanta":
                return new Fanta();
            case "Beer":
                return new Beer();
            default:
                return null;
        }
    }
}
