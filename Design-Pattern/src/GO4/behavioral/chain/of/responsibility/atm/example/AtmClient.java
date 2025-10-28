package GO4.behavioral.chain.of.responsibility.atm.example;

public class AtmClient {

    public static void main(String[] args) {
        TenHandler tenHandler=new TenHandler(100);
        HundredHandler hundredHandler= new HundredHandler(100);
        ThousandHandler thousandHandler = new ThousandHandler(100);

        thousandHandler.setNext(hundredHandler);
        hundredHandler.setNext(tenHandler);

        thousandHandler.dispense(3230);
    }
}
