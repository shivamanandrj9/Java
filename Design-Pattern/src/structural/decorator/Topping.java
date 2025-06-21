package structural.decorator;

public abstract class Topping extends BasePizza{
    BasePizza basePizza;

    public Topping(BasePizza basePizza){
        this.basePizza=basePizza;
    }
}
