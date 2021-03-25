package methodfactory;

import products.Product;
import products.pizza.*;

import java.io.Serializable;

public class PizzaFactory extends MethodFactory implements Serializable {
    private static PizzaFactory instance;

    private PizzaFactory() {}

    public static  PizzaFactory getInstance() {
        if (instance == null) {
            synchronized (PizzaFactory.class){
                if (instance == null){
                    instance = new PizzaFactory();
                }
            }
        }
        return instance;
    }

    @Override
    public Product getProduct(String type) {
        switch (type.toLowerCase()) {
            case "capriciosa":
                return new Capriciosa();
            case "hawaiian":
                return new Hawaiian();
            case "imperiana":
                return new Imperiana();
            case "margharita":
                return new Margharita();
            case "italiana":
                return new Italiana();
            default:
                throw new UnsupportedOperationException("No such a pizza in the menu!");
        }
    }
}
