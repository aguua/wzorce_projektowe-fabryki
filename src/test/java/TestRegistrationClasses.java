import products.Product;
import products.dumplings.Salmon;
import products.pasta.Bolognese;
import products.pasta.Carbonara;
import products.pizza.Italiana;

import org.junit.jupiter.api.Test;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.TearDown;
import static org.hamcrest.core.IsInstanceOf.instanceOf;
import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import registrationclass.NoReflectionFactory;
import registrationclass.ReflectionFactory;
import java.lang.reflect.InvocationTargetException;



public class TestRegistrationClasses {

    NoReflectionFactory factory1;
    ReflectionFactory factory2;

    @Setup
    public void setUp(){
       factory1 = NoReflectionFactory.getInstance();
       factory2 = ReflectionFactory.getInstance();
    }

    @Test
    public void testExceptionForNotRegisteredProductNoReflection() {
        NoReflectionFactory factory = NoReflectionFactory.getInstance();
        assertThrows(IllegalArgumentException.class, () -> {
            factory.getProduct("Carbonara");
        });
    }

    @Test
    public void testOrderAllProductsNoReflection() {
        NoReflectionFactory factory = NoReflectionFactory.getInstance();
        factory.registerType("salmon", Salmon::new);
        factory.registerType("italiana", Italiana::new);
        factory.registerType("Bolognese", Bolognese::new);

        Product dumplings = factory.getProduct("salmon");
        Product pasta = factory.getProduct("Bolognese");
        Product pizza = factory.getProduct("italiana");

        assertThat(dumplings, instanceOf(Salmon.class));
        assertThat(pasta, instanceOf(Bolognese.class));
        assertThat(pizza, instanceOf(Italiana.class));

        assertEquals(dumplings.getName(), "Salmon");
        assertEquals(pasta.getName(), "Bolognese");
        assertEquals(pizza.getName(), "Italiana");
    }


    //Test Reflection Factory

    @Test
    public void testExceptionForNotRegisteredProductReflection() {
        ReflectionFactory factory = ReflectionFactory.getInstance();
        assertThrows(IllegalArgumentException.class, () -> {
            factory.getProduct("Carbonara");
        });
    }

    @Test
    public void testRegisterProduct() throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        ReflectionFactory factory = ReflectionFactory.getInstance();
        assertThrows(IllegalArgumentException.class, () -> {
            factory.getProduct("Carbonara");
        });

        factory.registerProduct("Carbonara", Carbonara.class);
        Product pasta = factory.getProduct("Carbonara");

        assertEquals(pasta.getName(), "Carbonara");
    }


    @Test
    public void testOrderAllProductsReflection() throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        ReflectionFactory factory = ReflectionFactory.getInstance();

        Product dumplings = factory.getProduct("salmon");
        Product pasta = factory.getProduct("Bolognese");
        Product pizza = factory.getProduct("italiana");

        String actualMessageDum = dumplings.order();
        String actualMessagePasta = pasta.order();
        String actualMessagePizza = pizza.order();
        String expectedDumplingsMessage = "Ordered Salmon dumplings.";
        String expectedPizzaMessage = "Ordered Italiana pizza.";
        String expectedPastaMessage = "Ordered Bolognese pasta.";


        assertThat(dumplings, instanceOf(Salmon.class));
        assertThat(pasta, instanceOf(Bolognese.class));
        assertThat(pizza, instanceOf(Italiana.class));

        assertEquals(expectedPastaMessage, actualMessagePasta);
        assertEquals(expectedPizzaMessage, actualMessagePizza);
        assertEquals(expectedDumplingsMessage, actualMessageDum);
    }

    @TearDown
    public void tearDown(){
        factory1 = null;
        factory2 = null;
    }



}