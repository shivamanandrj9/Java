package structural.decorator;

public class Main {
    public static void main(String[] args) {
        BasePizza pizza = new Mushroom(new ExtraCheese(new Base1Pizza()));
        System.out.println(pizza.getCost());
    }
}
