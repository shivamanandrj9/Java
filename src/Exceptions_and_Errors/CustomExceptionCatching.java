package Exceptions_and_Errors;

public class CustomExceptionCatching {
    public static void main(String[] args){
        BankAccount bankAccount=new BankAccount(1000);
        try{
            bankAccount.withdraw(1001);
        }
        catch (InsufficientBalanceException e){
            System.out.println(e);
        }
    }
}

class BankAccount{

    private int balance;

    public BankAccount(int balance){
        this.balance=balance;
    }

    public void withdraw(int amount) throws InsufficientBalanceException{
        if(amount>balance){
            throw new InsufficientBalanceException("Insufficient Balance");
        }
        balance-=amount;
    }
}

class InsufficientBalanceException extends Exception{

    public InsufficientBalanceException(String message){
        super(message);
    }
}

