package products.pizza;

import products.Product;

import java.util.List;

public abstract class Pizza extends Product {

    protected boolean vegan;
    protected List<String> ingredients;

    @Override
    public String order() { return ("Ordered " + this.name + " pizza.");
    }
}
