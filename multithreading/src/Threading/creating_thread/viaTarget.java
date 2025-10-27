package Threading.creating_thread;

public class viaTarget {
    public static void main(String[] args) {

        //You can create a separate class implementing runnable interface but use lambda for better practice
        Runnable runnable = () -> {
            for(int i=0;i<10;i++){
                System.out.println("Hello world " + i);
            }
        };

        //This constructor will set the target = runnable;
        Thread thread=new Thread(runnable);

        thread.start();

    }
}
