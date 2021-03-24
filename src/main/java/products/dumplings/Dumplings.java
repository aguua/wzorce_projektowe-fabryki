package products.dumplings;

import products.Product;
import java.util.List;

public abstract class Dumplings extends Product {

    protected DoughType doughType;
    protected String sauce;
    protected List<String> ingredients;

    @Override
    public String order() { return ("Ordered " + this.name + " dumplings.");
    }
}
