package GO4.behavioral.observer.stock;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Stock aapl = new Stock("AAPL");

        Portfolio portfolioObserver=new Portfolio();
        UI uiObserver = new UI();

        aapl.register(portfolioObserver);
        aapl.register(uiObserver);

        Double[] prices={172.0, 172.5, 173.9};

        for(Double p: prices){
            System.out.println("Setting price as " + p);
            aapl.setPrice(p);
            Thread.sleep(2000);
        }

    }

}
