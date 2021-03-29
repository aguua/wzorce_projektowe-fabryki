import org.junit.jupiter.api.Test;

import static org.hamcrest.core.IsInstanceOf.instanceOf;
import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import products.dumplings.Dumplings;
import products.dumplings.Salmon;
import products.pasta.Bolognese;
import products.pasta.Pasta;
import products.pizza.Capriciosa;
import products.pizza.Pizza;
import simplefactory.SimpleFactory;

import java.util.HashSet;

public class TestSimpleFactory {

    private SimpleFactory factory;
    @BeforeEach
    public void setUp() {
        factory =  SimpleFactory.getInstance();
    }
    @Test
    public void testFactoryIsSingleton() {
        HashSet<Integer> singletons = new HashSet<>();
        for (int i = 0; i < 100; i++) {
            SimpleFactory singleton = SimpleFactory.getInstance();
            SimpleFactory singleton2 = SimpleFactory.getInstance();
            singletons.add(singleton.hashCode());
            singletons.add(singleton2.hashCode());
        }
        assertEquals(1, singletons.size());
    }

    @Test
    public void testOrderPizza() {
        Pizza pizza = factory.getPizza("Capriciosa");
        String expectedMessage = "Ordered Capriciosa pizza.";
        assertEquals(expectedMessage, pizza.order());
    }

    @Test
    public void testOrderPasta() {
        Pasta pasta = factory.getPasta("Bolognese");
        String expectedMessage = "Ordered Bolognese pasta.";
        assertEquals(expectedMessage, pasta.order());
    }

    @Test
    public void testOrderDumplings() {
        Dumplings dumplings = factory.getDumpling("salmon");
        String expectedMessage = "Ordered Salmon dumplings.";
        assertEquals(expectedMessage, dumplings.order());
    }

    @Test
    public void testOrderAllProducts() {
        Dumplings dumplings = factory.getDumpling("salmon");
        Pasta pasta = factory.getPasta("Bolognese");
        Pizza pizza = factory.getPizza("Capriciosa");

        String expectedDumplingsMessage = "Ordered Salmon dumplings.";
        String expectedPizzaMessage = "Ordered Capriciosa pizza.";
        String expectedPastaMessage = "Ordered Bolognese pasta.";

        assertEquals(expectedPastaMessage, pasta.order());
        assertEquals(expectedPizzaMessage, pizza.order());
        assertEquals(expectedDumplingsMessage, dumplings.order());
    }

    @Test
    public void testProductClasses() {
        Dumplings dumplings = factory.getDumpling("salmon");
        Pasta pasta = factory.getPasta("Bolognese");
        Pizza pizza = factory.getPizza("Capriciosa");

        assertThat(dumplings, instanceOf(Salmon.class));
        assertThat(pasta, instanceOf(Bolognese.class));
        assertThat(pizza, instanceOf(Capriciosa.class));
    }

    @AfterEach
    public void tearDown(){
        factory = null;
    }
}

