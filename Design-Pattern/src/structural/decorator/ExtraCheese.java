package structural.decorator;

public class ExtraCheese extends Topping{

    public ExtraCheese(BasePizza basePizza){
        super(basePizza);
    }

    public int getCost(){
        return super.basePizza.getCost()+10;
    }
}
