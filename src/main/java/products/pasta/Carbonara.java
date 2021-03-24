package products.pasta;


import java.util.Arrays;

public class Carbonara extends Pasta {
    public Carbonara(){
        name = "Carbonara";
        price = 23.50;
        pastaType = PastaType.TAGIATELLE;
        ingredients = Arrays.asList("bacon", "eggs", "parmesan", "garlic");
    }
}
