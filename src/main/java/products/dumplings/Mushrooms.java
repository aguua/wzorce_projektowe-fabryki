package products.dumplings;


import java.util.Arrays;

public class Mushrooms extends Dumplings {
    public Mushrooms(){
        name = "Mushrooms and  Cabbage";
        price = 18.50;
        doughType = DoughType.BOILED;
        ingredients = Arrays.asList("mushrooms", "onion", "cabbage");
        sauce = "fried onion in oil";
    }
}
