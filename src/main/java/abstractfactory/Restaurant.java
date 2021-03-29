package abstractfactory;

import products.dumplings.Dumplings;
import products.pasta.Pasta;
import products.pizza.Pizza;

public class Restaurant {
    private AbstractFactory abstractFactory;

    public Restaurant(AbstractFactory abstractFactory) {
        this.abstractFactory = abstractFactory;
    }

    public Pizza getPizza() { return abstractFactory.getPizza(); }

    public Pasta getPasta() {
        return abstractFactory.getPasta();
    }

    public Dumplings getDumplings() {
        return abstractFactory.getDumplings();
    }

    }
