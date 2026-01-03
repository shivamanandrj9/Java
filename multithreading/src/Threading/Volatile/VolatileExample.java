package Threading.Volatile;

public class VolatileExample {
    static boolean flag=false;

    static void changeFlag(){
        flag=true;
        System.out.println("Changed");
    }

    static void printFlag(){
        while(!flag){
            //fas gaya
        }
        System.out.println("Flag is now true");
    }

    public static void main(String[] args) {
        Thread t1=new Thread(()->{
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            changeFlag();
        });


        Thread t2=new Thread(()->printFlag());

        t1.start();
        t2.start();
    }
}

/*

This will never print this
System.out.println("Flag is now true");

This is because, it keeps on reading from the cache and since we are not using synchronized, it is unaware that it might be changed by other thread.

Volatile will make it always read from main memory.
So if there are multiple threads involved and not using thread safe by synchronized etc. Use volatile

static volatile boolean flag=false;

 */
