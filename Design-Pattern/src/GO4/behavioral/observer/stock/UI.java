package GO4.behavioral.observer.stock;

public class UI implements Observer<PriceUpdate>{

    @Override
    public void update(PriceUpdate data) {
        System.out.println("Showing the price changes to UI");
    }
}
