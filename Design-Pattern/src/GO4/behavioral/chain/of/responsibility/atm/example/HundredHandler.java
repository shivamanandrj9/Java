package GO4.behavioral.chain.of.responsibility.atm.example;

public class HundredHandler extends Handler{

    HundredHandler(int left) {
        super(left);
    }


    @Override
    public void dispense(int amount) {
        if(amount<=0){
            return;
        }

        int possibleByDenomination = amount/100;
        int available = getLeft();
        int toDispense = Math.min(possibleByDenomination, available);
        int dispensedAmount = toDispense * 100;
        int remainder = amount - dispensedAmount;

        if(toDispense>0){
            System.out.println("100 x "+toDispense);
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
