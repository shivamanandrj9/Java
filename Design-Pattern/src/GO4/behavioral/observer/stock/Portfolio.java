package GO4.behavioral.observer.stock;

public class Portfolio implements Observer<PriceUpdate>{
    @Override
    public void update(PriceUpdate data) {
        System.out.println("Recalculating the holdings");
    }
}
