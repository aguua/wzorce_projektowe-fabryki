package registrationclass;

import products.Product;
import products.dumplings.Salmon;
import products.pasta.Bolognese;
import products.pizza.Italiana;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;


public class ReflectionFactory {

    private static ReflectionFactory instance;
    private Map<String, Class<? extends Product>> registeredTypes = new HashMap() {{
        put("salmon", Salmon.class);
        put("italiana", Italiana.class);
        put("Bolognese", Bolognese.class);
    }};
    private ReflectionFactory() {
    }

    public static ReflectionFactory getInstance() {
        if (instance == null)
            instance = new ReflectionFactory();
        return instance;
    }

    public void registerProduct(String type, Class<? extends Product> _class) {
        registeredTypes.put(type, _class);
    }

    public Product getProduct(String type) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class<?> clazz = registeredTypes.get(type);
        if (clazz == null){
            throw new IllegalArgumentException();
        }
        Constructor productConstructor = clazz.getDeclaredConstructor();
        return (Product) productConstructor.newInstance(new Object[]{});
    }

    public String orderProduct(String type) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        return getProduct(type).order();
    }
}

