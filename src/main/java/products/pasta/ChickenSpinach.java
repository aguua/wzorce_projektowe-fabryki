package products.pasta;

import java.util.Arrays;

public class ChickenSpinach extends Pasta {
    public ChickenSpinach(){
        name = "Chicken & Spinach";
        price = 29.00;
        pastaType = PastaType.PENNE;
        ingredients = Arrays.asList("chicken", "spinach", "cream", "onion");
    }
}
