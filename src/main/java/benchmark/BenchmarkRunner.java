package benchmark;

import abstractfactory.ItalianRestaurant;
import abstractfactory.Restaurant;
import methodfactory.DumplingsFactory;
import methodfactory.MethodFactory;
import methodfactory.PastaFactory;
import methodfactory.PizzaFactory;
import org.openjdk.jmh.infra.Blackhole;
import products.dumplings.Salmon;
import products.pasta.Bolognese;
import products.pizza.Italiana;
import registrationclass.NoReflectionFactory;
import registrationclass.ReflectionFactory;
import simplefactory.SimpleFactory;

import org.openjdk.jmh.annotations.*;


/* Benchmark Modes:
Throughput 	Measures the number of operations per second, meaning the number of times per second your benchmark method could be executed.
Average Time 	Measures the average time it takes for the benchmark method to execute (a single execution).
Sample Time 	Measures how long time it takes for the benchmark method to execute, including max, min time etc.
Single Shot Time 	Measures how long time a single benchmark method execution takes to run. This is good to test how it performs under a cold start (no JVM warm up).
All 	Measures all of the above.
*/

import java.lang.reflect.InvocationTargetException;


@State(Scope.Thread)
public class BenchmarkRunner {
    public static void main(String[] args) throws Exception {
        org.openjdk.jmh.Main.main(args);
    }


    //SIMPLE FACTORY
    private static final  SimpleFactory simpleFactory =  SimpleFactory.getInstance();

    //METHOD FACTORY
    private static final MethodFactory factoryDum = DumplingsFactory.getInstance();
    private static final MethodFactory factoryPasta = PastaFactory.getInstance();
    private static final MethodFactory factoryPizza = PizzaFactory.getInstance();

    //ABSTRACT FACTORY
    private static final Restaurant restaurant = new Restaurant(ItalianRestaurant.getInstance());

    //REGISTRATION WITH REFLECTION
    private static final ReflectionFactory reflectionFactory = ReflectionFactory.getInstance();

    //REGISTRATION WITHOUT REFLECTION
    private static final NoReflectionFactory noReflectionfactory = NoReflectionFactory.getInstance();

    @Setup(Level.Invocation)
    public void doSetup() {
        noReflectionfactory.registerType("salmon", Salmon::new);
        noReflectionfactory.registerType("italiana", Italiana::new);
        noReflectionfactory.registerType("Bolognese", Bolognese::new);
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    public void testSimpleFactory(Blackhole blackhole){
            String dumplingsMess = simpleFactory.orderDumplings("salmon");
            String pastaMess = simpleFactory.orderPasta("Bolognese");
            String pizzaMess = simpleFactory.orderPizza("Capriciosa");

            blackhole.consume(dumplingsMess);
            blackhole.consume(pastaMess);
            blackhole.consume(pizzaMess);
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    public void testMethodFactory(Blackhole blackhole){
            String dumplingsMess = factoryDum.orderProduct("salmon");
            String pastaMess =  factoryPasta.orderProduct("Bolognese");
            String pizzaMess =  factoryPizza.orderProduct("Capriciosa");

            blackhole.consume(dumplingsMess);
            blackhole.consume(pastaMess);
            blackhole.consume(pizzaMess);
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    public void testAbstractFactory(Blackhole blackhole){
            String dumplingsMess = restaurant.getPizza().order();
            String pastaMess =  restaurant.getPasta().order();
            String pizzaMess =  restaurant.getDumplings().order();

            blackhole.consume(dumplingsMess);
            blackhole.consume(pastaMess);
            blackhole.consume(pizzaMess);
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    public void testReflectionFactory(Blackhole blackhole) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
            String dumplingsMess = reflectionFactory.orderProduct("salmon");
            String pastaMess =  reflectionFactory.orderProduct("Bolognese");
            String pizzaMess =  reflectionFactory.orderProduct("italiana");

            blackhole.consume(dumplingsMess);
            blackhole.consume(pastaMess);
            blackhole.consume(pizzaMess);
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    public void testNoReflectionFactory(Blackhole blackhole){
            String dumplingsMess = noReflectionfactory.orderProduct("salmon");
            String pastaMess =  noReflectionfactory.orderProduct("Bolognese");
            String pizzaMess =  noReflectionfactory.orderProduct("italiana");

            blackhole.consume(dumplingsMess);
            blackhole.consume(pastaMess);
            blackhole.consume(pizzaMess);
    }

}

