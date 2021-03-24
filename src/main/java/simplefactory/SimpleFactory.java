package simplefactory;

import products.dumplings.*;
import products.pasta.*;
import products.pizza.*;

import java.io.Serializable;


public class SimpleFactory implements Serializable {
    private static SimpleFactory instance;

    private SimpleFactory() {
    }

    public static synchronized SimpleFactory getInstance() {
        if (instance == null) {
            instance = new SimpleFactory();
        }
        return instance;
    }

    public Pizza orderPizza(String type) {
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

    public Pasta orderPasta(String type) {
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

    public Dumplings orderDumpling(String type) {
        switch (type = type.toLowerCase()){
            case "mushrooms":
                return new Mushrooms();
            case "russian":
                return new Russian();
            case "salmon":
                return new Salmon();
            case "strawberries":
                return new Strawberries();
            case "wonton":
                return new Wonton();
            default:
                throw new UnsupportedOperationException("No such dumplings in the menu!");
        }
    }
}
