package products.dumplings;

import java.util.Arrays;

public class Strawberries  extends Dumplings {
    public Strawberries(){
        name = "Strawberries";
        price = 15.90;
        doughType = DoughType.BOILED;
        ingredients = Arrays.asList("strawberries", "sugar");
        sauce = "sweet cream";
    }
}
