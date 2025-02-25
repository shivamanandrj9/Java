package Threading;

import static java.lang.Thread.sleep;

public class Daemon {
    public static void main(String[] args) throws InterruptedException {

        Runnable runnable = () -> {
          for(int i=0;i<5;i++){
              System.out.println("Running");
              try {
                  sleep(1000);
              } catch (InterruptedException e) {
                  throw new RuntimeException(e);
              }
          }
        };

        Thread t1=new Thread(runnable);
        t1.setDaemon(true); //this will make this thread stop once the main method stops otherwise main will wait until this thread is done with its execution.
        t1.start();

        sleep(2000); //2 baar hi chal paega
    }
}
