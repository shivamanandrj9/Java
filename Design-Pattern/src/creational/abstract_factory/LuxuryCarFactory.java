package creational.abstract_factory;

public class LuxuryCarFactory implements AbstractFactory{

    @Override
    public Car getCar(int budget){
        if(budget<1000000){
            return new LuxuryCar1();
        } else {
            return new LuxuryCar2();
        }
    }


}
