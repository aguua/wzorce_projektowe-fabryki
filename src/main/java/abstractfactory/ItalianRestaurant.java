package abstractfactory;

import products.dumplings.Dumplings;
import products.dumplings.Salmon;
import products.pasta.Carbonara;
import products.pasta.Pasta;
import products.pizza.Italiana;
import products.pizza.Pizza;

public class ItalianRestaurant implements AbstractFactory  {
    private static ItalianRestaurant instance;

    private ItalianRestaurant() {
    }

    public static synchronized ItalianRestaurant getInstance() {
        if (instance == null) {
            instance = new ItalianRestaurant();
        }
        return instance;
    }

    @Override
    public Pizza getPizza() {
        return new Italiana();
    }

    @Override
    public Pasta getPasta() { return new Carbonara();}

    @Override
    public Dumplings getDumplings() { return new Salmon(); }
}
