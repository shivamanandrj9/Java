package GO4.behavioral.chain.of.responsibility.atm.example;

public class ThousandHandler extends Handler{
    ThousandHandler(int value){
        super(value);
    }

    @Override
    public void dispense(int amount) {
        if(amount<=0){
            return;
        }

        int possibleByDenomination = amount/1000;
        int available = getLeft();
        int toDispense = Math.min(possibleByDenomination, available);
        int dispensedAmount = toDispense * 1000;
        int remainder = amount - dispensedAmount;

        if(toDispense>0){
            System.out.println("1000 x "+toDispense);
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
