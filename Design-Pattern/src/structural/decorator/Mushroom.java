package structural.decorator;

public class Mushroom extends Topping{
    public Mushroom(BasePizza basePizza){
        super(basePizza);
    }

    public int getCost(){
        return super.basePizza.getCost()+20;
    }
}
