package Threading;

public class BasicThread {


    public static void main(String[] args) {

        /*
        Class Runnable is a functional interface that only has once method that need to be overrided i.e. run method. So we create any class that implements this functional interface and override its run method. Or we can use lambda function as we have done below.
         */

        Runnable runnable = () -> {
            for (int i = 0; i < 5; i++) {
                System.out.println("Hello from " + Thread.currentThread().getName() + i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };

        //This is a platform thread. This is a non-daemon thread
        Thread thread1 = new Thread(runnable,"This thread ");
        thread1.start();

        Thread thread2 = new Thread(runnable, "This thread 2 ");
        thread2.start();

        System.out.println("This is the main thread");
    }

}
