package products.dumplings;

import java.util.Arrays;

public class Wonton extends Dumplings {
    public Wonton(){
        name = "Wonton";
        price = 25.90;
        doughType = DoughType.FRIED;
        ingredients = Arrays.asList("minced pork", "white cabbage", "ginger", "garlic", "chives", "soy sauce");
        sauce = "sweet-sour";
    }
}
