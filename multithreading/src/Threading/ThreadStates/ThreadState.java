package Threading.ThreadStates;

public class ThreadState {
    public static void main(String[] args) throws InterruptedException {
        Thread thread=new Thread(()->{
            try{
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        },"States");

        //The state is Thread.State.NEW -> This means thread is created
        System.out.println(thread.getState());

        thread.start();

        //The state is Thread.State.RUNNABLE -> This means thread is in runnable state and is now left to JVM for its execution
        System.out.println(thread.getState());

        /*
        Now it can be in
        Thread.State.TIMED_WAITING -> It will leave this stage only when
        1) notify by another thread
        2) timer expired
        3) Thread.sleep(someTime)

        whichever happens first

        It can also be in Thread.State.WAITING -> Here we are waiting for another thread to notify or waiting for the join completion of another target thread(targetThread.join());
         */


        while(true){
            System.out.println(thread.getState());
            /*
            Once the execution is done, it will be in TERMINATED state forever. Until JVM cleans that thread by Garbage collection once the reference to it is removed by a program.
             */
            if(thread.getState()==Thread.State.TERMINATED) break;
        }


        System.out.println("Main thread " + Thread.currentThread().getState());
        thread.join();
        System.out.println("Main thread " + Thread.currentThread().getState());


        /*

        Another state is Thread.State.BLOCKED, here the Thread is waiting to acquire a lock.
         */
    }
}
