package abstractfactory;

import products.dumplings.Dumplings;
import products.dumplings.Russian;
import products.pasta.Pasta;
import products.pasta.Tomato;
import products.pizza.Capriciosa;
import products.pizza.Pizza;

public class PolishRestaurant implements AbstractFactory  {
    private static PolishRestaurant instance;

    private PolishRestaurant() {
    }

    public static synchronized PolishRestaurant getInstance() {
        if (instance == null) {
            instance = new PolishRestaurant();
        }
        return instance;
    }

    @Override
    public Pizza orderPizza() {
        return new Capriciosa();
    }

    @Override
    public Pasta orderPasta() { return new Tomato();}

    @Override
    public Dumplings orderDumplings() { return new Russian(); }
}
