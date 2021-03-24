package products.pizza;

import java.util.Arrays;

public class Margharita  extends Pizza {
        public Margharita () {
            name = "Margharita";
            price = 19.00;
            vegan = true;
            ingredients = Arrays.asList("cheese");
        }
}
