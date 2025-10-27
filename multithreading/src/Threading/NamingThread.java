package Threading;

public class NamingThread {

    public static void main(String[] args) {

        Runnable runnable = ()->{
            //Here we can use that name
            System.out.println("Hello world " + Thread.currentThread().getName());

            //FYI: Thread.sleep() will add delay to its execution
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        };

        //Here we set out the thread name
        Thread thread=new Thread(runnable, "Thread Name");

        thread.start();
    }
}
