
public class Singleton  {
    private static Singleton uniqueInstance;
    private String testString = "default";

    protected Singleton() {}

    public static Singleton getInstance() {
        if (uniqueInstance == null) {
            uniqueInstance = new Singleton();
        }
        return uniqueInstance;
    }

    public String getTestString() { return testString;}
    public void setTestString(String testString){ this.testString = testString;}

}

