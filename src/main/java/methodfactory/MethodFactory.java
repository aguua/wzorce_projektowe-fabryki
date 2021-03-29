package methodfactory;

import products.Product;

public interface MethodFactory {
    public abstract Product getProduct(String type);
    public String orderProduct(String type);
}

