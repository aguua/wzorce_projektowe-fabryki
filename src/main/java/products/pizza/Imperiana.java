package products.pizza;

import java.util.Arrays;

public class Imperiana extends Pizza {
    public Imperiana() {
        name = "Imperiana";
        price = 28.50;
        vegan = false;
        ingredients = Arrays.asList("cheese", "tomato",  "ham", "chicken", "salami", "onion");
    }
}
