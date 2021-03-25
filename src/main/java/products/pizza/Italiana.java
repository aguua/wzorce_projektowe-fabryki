package products.pizza;

import java.util.Arrays;

public class Italiana extends Pizza {
        public  Italiana () {
            name = "Italiana";
            price = 25.00;
            vegan = true;
            ingredients = Arrays.asList("cheese", "mozzarella", "tomatos", "bazil");
        }
    }
