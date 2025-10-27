package Threading.synchronizedd;

public class Runner {
    public static void main(String[] args) {

        Stack<Integer> st = new Stack<>(1);
        Runnable runnable1=()-> {
            for(int i=0;i<100;i++){
                st.push(i);
            }
        };

        Runnable runnable2=()-> {
            for(int i=0;i<100;i++){
                st.pop();
            }
        };

        Thread thread1=new Thread(runnable1, "Thread1");
        Thread thread2=new Thread(runnable2, "Thread2");

        thread1.start();
        thread2.start();

    }
}
