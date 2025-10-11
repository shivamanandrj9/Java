package creational.abstract_factory.car;

public interface AbstractFactory {
    Car createHatchback();
    Car createSedan();
    Car createSUV();
}

