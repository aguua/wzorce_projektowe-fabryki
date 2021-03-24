package products.pasta;

import products.Product;

import java.util.List;

public abstract class Pasta extends Product {

    protected PastaType pastaType;
    protected List<String> ingredients;

    @Override
    public String order() { return ("Ordered " + this.name + " pasta.");
    }
}
