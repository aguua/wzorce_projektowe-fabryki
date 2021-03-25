package methodfactory;

import products.Product;
import products.pasta.*;

import java.io.Serializable;

public class PastaFactory extends MethodFactory implements Serializable {
    private static PastaFactory instance;

    private PastaFactory() {}

    public static  PastaFactory getInstance() {
        if (instance == null) {
            synchronized (PastaFactory.class){
                if (instance == null){
                    instance = new PastaFactory();
                }
            }
        }
        return instance;
    }

    @Override
    public Product getProduct(String type) {
        switch (type.toLowerCase()) {
            case "bolognese":
                return new Bolognese();
            case "carbonara":
                return new Carbonara();
            case "chicken spinach":
            case "chickenspinach":
                return new ChickenSpinach();
            case "tomato":
                return new Tomato();
            default:
                throw new UnsupportedOperationException("No such a pasta in the menu!");
        }
    }
}
