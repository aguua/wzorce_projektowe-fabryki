
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class TestSingleton {

    private Singleton s1;
    private Singleton s2;

    @BeforeEach
    public void setUp() {
        s1 = Singleton.getInstance();
        s2 = Singleton.getInstance();
    }

    @Test
    public void  testSimpleSingleton() {
        assertEquals(s1, s2);
        assertEquals(s1.hashCode(), s2.hashCode());
    }

    @Test
    public void testManySingletons() {
        HashSet<Integer> singletons = new HashSet<>();
        for (int i = 0; i < 1000; i++) {
            Singleton s1 = Singleton.getInstance();
            Singleton s2 = Singleton.getInstance();
            singletons.add(s1.hashCode());
            singletons.add(s2.hashCode());
        }
        assertEquals(singletons.size(), 1);
    }

    @AfterEach
    public void tearDown(){
        s1 = null;
        s2 = null;
    }

}
