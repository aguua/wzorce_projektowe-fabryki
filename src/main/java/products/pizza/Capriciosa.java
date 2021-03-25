package products.pizza;

import java.util.Arrays;

public class Capriciosa extends Pizza {
    public Capriciosa(){
        name = "Capriciosa";
        price = 23.80;
        vegan = false;
        ingredients = Arrays.asList("chees", "ham", "mushrooms", "onion");
    }
}
