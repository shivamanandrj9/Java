package GO4.creational.abstract_factory.car;

public class AbstractFactoryProducer {
    public static AbstractFactory getFactory(String type) {
        if (type.equalsIgnoreCase("Economic")) {
            return new EconomicCarFactory();
        } else if (type.equalsIgnoreCase("Luxury")) {
            return new LuxuryCarFactory();
        }
        throw new IllegalArgumentException("Unknown factory type: " + type);
    }
}

