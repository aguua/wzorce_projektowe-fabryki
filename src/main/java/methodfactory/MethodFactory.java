package methodfactory;

import products.Product;

// zaleta  usuwamy tu sprzezenie pomiedzy implementacja produktu a jego zastosowaniem
public interface MethodFactory {
    public abstract Product getProduct(String type);
    public String orderProduct(String type);
}

