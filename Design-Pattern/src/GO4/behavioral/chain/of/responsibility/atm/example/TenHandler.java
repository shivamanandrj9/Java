package GO4.behavioral.chain.of.responsibility.atm.example;

public class TenHandler extends Handler{
    TenHandler(int left) {
        super(left);
    }

    @Override
    public void dispense(int amount) {
        if(amount<=0){
            return;
        }

        int possibleByDenomination = amount/10;
        int available = getLeft();
        int toDispense = Math.min(possibleByDenomination, available);
        int dispensedAmount = toDispense * 10;
        int remainder = amount - dispensedAmount;

        if(toDispense>0){
            System.out.println("10 x "+toDispense);
            setLeft(available - toDispense);
        }

        if(remainder>0){
            if(this.next!=null){
                this.next.dispense(remainder);
            } else {
                System.out.println("Cannot dispense remaining amount: "+remainder);
            }
        }
    }
}
