package abstractfactory;

import products.dumplings.Dumplings;
import products.pasta.Pasta;
import products.pizza.Pizza;

public class Restaurant {
    private AbstractFactory abstractFactory;

    public Restaurant(AbstractFactory abstractFactory) {
        this.abstractFactory = abstractFactory;
    }

    public Pizza orderPizza() {
        return abstractFactory.orderPizza();
    }

    public Pasta orderPasta() {
        return abstractFactory.orderPasta();
    }

    public Dumplings orderDumplings() {
        return abstractFactory.orderDumplings();
    }
}