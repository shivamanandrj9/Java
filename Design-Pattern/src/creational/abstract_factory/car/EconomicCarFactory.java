package creational.abstract_factory.car;

public class EconomicCarFactory implements AbstractFactory {
    @Override
    public Car createHatchback() {
        return new EconomicHatchbackVariant();
    }
    @Override
    public Car createSedan() {
        return new EconomicSedanVariant();
    }
    @Override
    public Car createSUV() {
        return new EconomicSUVVariant();
    }
}

