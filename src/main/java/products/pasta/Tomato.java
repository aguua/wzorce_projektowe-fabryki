package products.pasta;

import java.util.Arrays;

public class Tomato extends Pasta {
    public Tomato(){
        name = "Tomato";
        price = 20.00;
        pastaType = PastaType.TAGIATELLE;
        ingredients = Arrays.asList("tomato sauce", "olive", "garlic", "basil");
    }
}
