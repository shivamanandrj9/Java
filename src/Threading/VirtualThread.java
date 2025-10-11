//package Threading;
//
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class VirtualThread {
//    public static void main(String[] args) throws InterruptedException {
//
//        List<Thread> myThreads=new ArrayList<>();
//
//        Runnable runnable = () -> {
//          for(int i=0;i<10;i++)
//          {
//              System.out.println(Thread.currentThread().getName() + " " + i);
//          }
//        };
//
//        for(int i=0;i<100;i++)
//        {
//            //By default these threads are daemon(i.e main will not wait for this before closing). To make it daemon. We must join it. So the main will wait for those thread jinke liye join call kiya hai main me.
////            Thread thread = Thread.ofVirtual().name(Integer.toString(i)).unstarted(runnable);
////            myThreads.add(thread);
//        }
//
//        for(int i=0;i<100;i++)
//        {
//
//            myThreads.get(i).start();
//
//        }
//
//        for(int i=0;i<100;i++)
//        {
//
//            myThreads.get(i).join();
//
//        }
//
//    }
//}
