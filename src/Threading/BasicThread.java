package Threading;

public class BasicThread {


    public static void main(String[] args) {


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

        Thread thread1 = new Thread(runnable,"This thread ");
        thread1.start();

        Thread thread2 = new Thread(runnable, "This thread 2 ");
        thread2.start();

        System.out.println("This is the main thread");
    }

}
