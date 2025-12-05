package Threading.ThreadStates;

public class SpyThread {
    public static void main(String[] args) throws InterruptedException {
        Thread childThread = new Thread(() -> {
            try {
                Thread.sleep(2000); // Sleep for 2 seconds
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "Child-Thread");




        Thread mainThread = Thread.currentThread();

        /*
        The Spy Thread (Observes Main)
        This we have done just to see the state of the main thread, because if a thread is waiting then it cannot print its state during the execution. Paradox. Usko rok ke usi ko bol rahe ki bhai state print kar
         */
        Thread spyThread = new Thread(() -> {
            try {
                Thread.sleep(500); // Wait for main to reach join()
                // THIS is where we catch Main being WAITING
                System.out.println("Spy reporting: Main thread state is -> " + mainThread.getState());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        childThread.start();
        spyThread.start();

        // 3. Main thread joins child
        // Main will pause here for ~2 seconds. The Spy will catch it.
        childThread.join();

        System.out.println("Main thread finished join, now: " + mainThread.getState());

    }

}
