package creational.abstract_factory;

public class EconomicCarFactory implements AbstractFactory{
    @Override
    public Car getCar(int budget){
        if(budget<1000000){
            return new EconomicCar1();
        } else {
            return new EconomicCar2();
        }
    }
}
