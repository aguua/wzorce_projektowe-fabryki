package registrationclass;

import products.Product;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class NoReflectionFactory {
    private static NoReflectionFactory instance;
    private Map<String, Supplier<? extends Product>> registeredSuppliers = new HashMap<>();

    private NoReflectionFactory() {
    }

    public static NoReflectionFactory getInstance() {
        if (instance == null)
            instance = new NoReflectionFactory();
        return instance;
    }

    public void registerType(String type, Supplier<? extends Product> supplier) {
        registeredSuppliers.put(type, supplier);
    }

    public Product getProduct(String type) {
        Supplier<? extends Product> supplier = registeredSuppliers.get(type);
        return supplier != null ? supplier.get() : null;
    }
}
