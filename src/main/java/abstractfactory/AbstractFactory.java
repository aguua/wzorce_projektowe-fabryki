package abstractfactory;

import products.dumplings.Dumplings;
import products.pasta.Pasta;
import products.pizza.Pizza;

public interface AbstractFactory {
    Pizza orderPizza();
    Pasta orderPasta();
    Dumplings orderDumplings();
}
