package products.dumplings;

import java.util.Arrays;

public class Russian  extends Dumplings {
    public Russian(){
        name = "Russian";
        price = 14.50;
        doughType = DoughType.BOILED;
        ingredients = Arrays.asList("cottage cheese", "potatoes", "onion");
        sauce = "lard with cracklings";
    }
}
