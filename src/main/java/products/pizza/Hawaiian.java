package products.pizza;

import java.util.Arrays;

public class Hawaiian  extends Pizza {
    public Hawaiian  () {
        name = "Hawaiian";
        price = 22.00;
        vegan = false;
        ingredients = Arrays.asList("cheese", "ananas", "ham", "onion");
    }
}
