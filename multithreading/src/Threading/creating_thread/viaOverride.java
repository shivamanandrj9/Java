package Threading.creating_thread;

public class viaOverride {
    public static void main(String[] args) {
        Thread thread = new Overriden();
        thread.start();
    }

}

class Overriden extends Thread{
    @Override
    public void run(){
        for(int i=0;i<10;i++){
            System.out.println("Hello world "+i);
        }
    }
}
