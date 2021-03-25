import methodfactory.DumplingsFactory;
import methodfactory.MethodFactory;
import methodfactory.PastaFactory;
import methodfactory.PizzaFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import products.Product;
import products.dumplings.Dumplings;
import products.dumplings.Salmon;
import products.pasta.Bolognese;
import products.pasta.Pasta;
import products.pizza.Capriciosa;
import products.pizza.Pizza;
import simplefactory.SimpleFactory;

import java.util.HashSet;

import static org.hamcrest.core.IsInstanceOf.instanceOf;
import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestMethodFactory {


    @Test
    public void testOrderPizza() {
        MethodFactory factory = PizzaFactory.getInstance();
        String actualMessage = factory.orderProduct("Capriciosa");
        String expectedMessage = "Ordered Capriciosa pizza.";
        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    public void testOrderPasta() {
        MethodFactory factory = PastaFactory.getInstance();
        String actualMessage = factory.orderProduct("Bolognese");
        String expectedMessage = "Ordered Bolognese pasta.";
        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    public void testOrderDumplings() {
        MethodFactory factory = DumplingsFactory.getInstance();
        String actualMessage = factory.orderProduct("salmon");
        String expectedMessage = "Ordered Salmon dumplings.";
        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    public void testOrderAllProducts() {
        MethodFactory factoryDum = DumplingsFactory.getInstance();
        MethodFactory factoryPasta = PastaFactory.getInstance();
        MethodFactory factoryPizza = PizzaFactory.getInstance();

        String actualMessageDum = factoryDum.orderProduct("salmon");
        String actualMessagePasta = factoryPasta.orderProduct("Bolognese");
        String actualMessagePizza = factoryPizza.orderProduct("italiana");

        String expectedDumplingsMessage = "Ordered Salmon dumplings.";
        String expectedPizzaMessage = "Ordered Italiana pizza.";
        String expectedPastaMessage = "Ordered Bolognese pasta.";

        assertEquals(expectedPastaMessage, actualMessagePasta);
        assertEquals(expectedPizzaMessage, actualMessagePizza);
        assertEquals(expectedDumplingsMessage, actualMessageDum);
    }

    @Test
    public void testProductClasses() {
        MethodFactory factoryDum = DumplingsFactory.getInstance();
        MethodFactory factoryPasta = PastaFactory.getInstance();
        MethodFactory factoryPizza = PizzaFactory.getInstance();

        Product dumplings = factoryDum.getProduct("salmon");
        Product pasta = factoryPasta.getProduct("Bolognese");
        Product pizza = factoryPizza.getProduct("Capriciosa");

        assertThat(dumplings, instanceOf(Salmon.class));
        assertThat(pasta, instanceOf(Bolognese.class));
        assertThat(pizza, instanceOf(Capriciosa.class));
    }


}

