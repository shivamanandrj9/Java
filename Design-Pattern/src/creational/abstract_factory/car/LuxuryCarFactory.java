package creational.abstract_factory.car;

public class LuxuryCarFactory implements AbstractFactory {
    @Override
    public Car createHatchback() {
        return new LuxuryHatchbackVariant();
    }
    @Override
    public Car createSedan() {
        return new LuxurySedanVariant();
    }
    @Override
    public Car createSUV() {
        return new LuxurySUVVariant();
    }
}

