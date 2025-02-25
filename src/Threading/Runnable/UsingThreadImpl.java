package Threading.Runnable;

public class UsingThreadImpl {


    public static void main(String[] args) {
        //WAY 1
        //We can also create a seperate class that implements the Runnable interface and it overrides the run() method. But here we have used anonymous class.
        Runnable bullet1 = new Runnable(){
            @Override
            public void run(){
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("This is runnable 1");
            }
        };

        //WAY 2
        //Here we have used lambda. This is because the runnable is a functional interface and has only one method run that needs to be implemented. run() does not take any argument that's why ()->{}.
        Runnable bullet2 = () -> {
            System.out.println("This is runnable 2");
        };

        //Here we will see how to pass a parameter when we call the runnable
        //when we use WAY 1 and WAY 2, we have access to any variable that is present inside the main method. So we can directly use it.
        //But If we are creating a seperate class that implements the runnable interface and it overrides the run() method. What we can do is that we can create variables as properties of that class and create a constructor, to initialize those properties. This way we can consume those variable in that class's run() impl.
        String name = "Shivam Anand";
        Runnable bullet3 = () -> {
            System.out.println("This is runnable 3" + name);
        };

        //This is a platform thread, not the java virtual thread
        Thread gun1 = new Thread(bullet1);
        Thread gun2= new Thread(bullet2);

        //This is a virtual thread. This is a non-daemon thread by default.
        Thread gun3 = Thread.ofVirtual().unstarted(bullet3);

        gun1.start();
        gun2.start();
        gun3.start();

    }

}
