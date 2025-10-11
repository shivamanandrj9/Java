package creational.abstract_factory.car;

public class Main {
    public static void main(String[] args) {
        AbstractFactory economicFactory = AbstractFactoryProducer.getFactory("Economic");
        Car h1 = economicFactory.createHatchback();
        h1.drive();
        Car s1 = economicFactory.createSedan();
        s1.drive();
        Car suv1 = economicFactory.createSUV();
        suv1.drive();

        AbstractFactory luxuryFactory = AbstractFactoryProducer.getFactory("Luxury");
        Car h2 = luxuryFactory.createHatchback();
        h2.drive();
        Car s2 = luxuryFactory.createSedan();
        s2.drive();
        Car suv2 = luxuryFactory.createSUV();
        suv2.drive();
    }
}

