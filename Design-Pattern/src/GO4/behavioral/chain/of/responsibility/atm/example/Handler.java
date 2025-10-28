package GO4.behavioral.chain.of.responsibility.atm.example;

public abstract class Handler {
    private int left;
    protected Handler next;

    Handler(int left){
        this.left=left;
    }

    public void setNext(Handler next){
        this.next=next;
    }

    protected int getLeft(){
        return left;
    }

    protected void setLeft(int left){
        this.left = left;
    }

    public abstract void dispense(int amount);
}
