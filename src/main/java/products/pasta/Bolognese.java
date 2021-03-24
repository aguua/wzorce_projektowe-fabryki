package products.pasta;

import java.util.Arrays;

public class Bolognese extends Pasta {
    public Bolognese(){
        name = "Bolognese";
        price = 24.00;
        pastaType = PastaType.SPAGETHI;
        ingredients = Arrays.asList("ground beef", "bacon", "celery", "onion", "carrot", "tomato sauce", "milk");
    }
}
