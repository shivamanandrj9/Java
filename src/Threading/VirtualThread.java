package Threading;


import java.util.ArrayList;
import java.util.List;

public class VirtualThread {
    public static void main(String[] args) throws InterruptedException {

        List<Thread> myThreads=new ArrayList<>();

        Runnable runnable = () -> {
          for(int i=0;i<10;i++)
          {
              System.out.println(Thread.currentThread().getName() + " " + i);
          }
        };

        for(int i=0;i<100;i++)
        {
            Thread thread = Thread.ofVirtual().name(Integer.toString(i)).unstarted(runnable);
            myThreads.add(thread);
        }

        for(int i=0;i<100;i++)
        {

            myThreads.get(i).start();

        }

        for(int i=0;i<100;i++)
        {

            myThreads.get(i).join();

        }

    }
}
