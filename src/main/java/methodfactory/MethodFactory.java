package methodfactory;

import products.Product;

// zaleta  usuwamy tu sprzezenie pomiedzy implementacja produktu a jego zastosowaniem
public abstract  class MethodFactory {
    public abstract Product getProduct(String type);
    public String orderProduct(String type) {
            return getProduct(type).order();
        }
}

