package methodfactory;

import products.Product;
import products.dumplings.*;

import java.io.Serializable;

public class DumplingsFactory implements MethodFactory, Serializable{
    private static DumplingsFactory instance;

    private DumplingsFactory() {}

    public static  DumplingsFactory getInstance() {
        if (instance == null) {
            synchronized (DumplingsFactory.class){
                if (instance == null){
                    instance = new DumplingsFactory();
                }
            }
        }
        return instance;
    }

    @Override
    public Product getProduct(String type) {
        switch (type.toLowerCase()){
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

    @Override
    public String orderProduct(String type) {
        return getProduct(type).order();
    }

}
