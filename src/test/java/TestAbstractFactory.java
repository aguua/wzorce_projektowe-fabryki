import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import abstractfactory.ItalianRestaurant;
import abstractfactory.PolishRestaurant;
import abstractfactory.Restaurant;

import products.dumplings.Dumplings;
import products.pasta.Pasta;
import products.pizza.Pizza;

public class TestAbstractFactory {


    @Test
    public void testOrderInPolishRestaurant() {
        Restaurant restaurant = new Restaurant(PolishRestaurant.getInstance());
        Pizza pizza = restaurant.getPizza();
        Pasta pasta = restaurant.getPasta();
        Dumplings dumplings = restaurant.getDumplings();

        String expectedMessageDum = "Ordered Russian dumplings.";
        String expectedMessagePizza = "Ordered Capriciosa pizza.";
        String expectedMessagePasta = "Ordered Tomato pasta.";

        assertEquals(expectedMessagePizza, pizza.order());
        assertEquals(expectedMessagePasta, pasta.order());
        assertEquals(expectedMessageDum, dumplings.order());
    }

    @Test
    public void testOrderInItalianRestaurant() {
        Restaurant restaurant = new Restaurant(ItalianRestaurant.getInstance());
        Pizza pizza = restaurant.getPizza();
        Pasta pasta = restaurant.getPasta();
        Dumplings dumplings = restaurant.getDumplings();

        String expectedDumplingsMessage = "Ordered Salmon dumplings.";
        String expectedPizzaMessage = "Ordered Italiana pizza.";
        String expectedPastaMessage = "Ordered Carbonara pasta.";

        assertEquals(expectedPastaMessage, pasta.order());
        assertEquals(expectedPizzaMessage, pizza.order());
        assertEquals(expectedDumplingsMessage, dumplings.order());
    }
}
