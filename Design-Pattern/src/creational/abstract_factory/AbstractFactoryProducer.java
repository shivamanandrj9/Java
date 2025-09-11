package creational.abstract_factory;

public class AbstractFactoryProducer {
    public static AbstractFactory getFactoryInstance(String value){
        if(value.equalsIgnoreCase("Economic")){
            return new EconomicCarFactory();
        } else if(value.equalsIgnoreCase("Luxury")){
            return new LuxuryCarFactory();
        }
        throw new IllegalArgumentException("Unknown factory type: " + value);
    }
}
