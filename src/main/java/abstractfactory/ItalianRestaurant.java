package abstractfactory;

import products.dumplings.Dumplings;
import products.dumplings.Russian;
import products.dumplings.Salmon;
import products.pasta.Carbonara;
import products.pasta.Pasta;
import products.pasta.Tomato;
import products.pizza.Capriciosa;
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
    public Pizza orderPizza() {
        return new Italiana();
    }

    @Override
    public Pasta orderPasta() { return new Carbonara();}

    @Override
    public Dumplings orderDumplings() { return new Salmon(); }
}
