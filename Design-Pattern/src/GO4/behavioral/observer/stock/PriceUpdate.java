package GO4.behavioral.observer.stock;

//This is our contract
//You can use a marker interface to bind it contract and use <T extends contract> everywhere to bind it.

public class PriceUpdate {
    public String symbol;
    public Double price;

    public PriceUpdate(String symbol, Double price) {
        this.symbol = symbol;
        this.price = price;
    }
}
