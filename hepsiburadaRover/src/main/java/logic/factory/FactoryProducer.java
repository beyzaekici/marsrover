package logic.factory;

public class FactoryProducer {
    public static AbstractFactory getFactory(String choice) {
        if (choice.equalsIgnoreCase("rover")) {
            return new RoverFactory();
        }
        return null;
    }
}
