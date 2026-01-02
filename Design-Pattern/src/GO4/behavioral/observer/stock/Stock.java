package GO4.behavioral.observer.stock;

import java.util.ArrayList;
import java.util.List;

public class Stock implements Subject<PriceUpdate>{

    List<Observer<PriceUpdate>> subscriber;
    PriceUpdate priceUpdate;
    Double price;
    String symbol;

    public void setPrice(Double newPrice){
        this.price=newPrice;
        priceUpdate=new PriceUpdate(symbol,price);
        notifyObservers();
    }

    public Stock(String symbol){
        this.subscriber=new ArrayList<>();
        this.symbol=symbol;
        this.price=0d;
    }

    @Override
    public void register(Observer<PriceUpdate> o) {
        subscriber.add(o);
    }

    @Override
    public void unregister(Observer<PriceUpdate> o) {
        subscriber.remove(o);
    }

    @Override
    public void notifyObservers() {
        for(Observer<PriceUpdate> o: subscriber){
            o.update(priceUpdate);
        }
    }
}
