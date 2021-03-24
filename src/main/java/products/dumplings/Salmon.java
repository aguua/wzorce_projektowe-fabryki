package products.dumplings;

import java.util.Arrays;

public class Salmon extends Dumplings {
    public Salmon(){
        name = "Salmon";
        price = 23.50;
        doughType = DoughType.BACKED;
        ingredients = Arrays.asList("salmon", "onion", "cream", "dill");
        sauce = "basil butter with peanuts";
    }
}
