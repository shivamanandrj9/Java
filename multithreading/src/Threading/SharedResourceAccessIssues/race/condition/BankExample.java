package Threading.SharedResourceAccessIssues.race.condition;

public class BankExample {
    public static void main(String[] args) {
        Account a=new Account();
        a.balance=100;
        Runnable runnable = ()->{
            depositAmount(500,a);
        };

        Thread thread1=new Thread(runnable);
        thread1.start();
        Thread thread2=new Thread(runnable);
        thread2.start();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {

        }

        System.out.println(a.balance);
    }

    static void depositAmount(int value, Account acc){
        int current_value=acc.balance;
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {

        }
        current_value=current_value+value;
        acc.balance=current_value;
    }
}

class Account{
    String accountId;
    Integer balance;
}
