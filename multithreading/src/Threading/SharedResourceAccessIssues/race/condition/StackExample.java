package Threading.SharedResourceAccessIssues.race.condition;

public class StackExample {
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

class Stack<T> {
    private T[] array;
    private int ptr;
    private int capacity;

    Stack(int capacity){
        this.array=(T[]) new Object[capacity];
        this.ptr=-1;
        this.capacity=capacity;
    }

    T front() {
        try {Thread.sleep(1000);} catch (Exception e) {};
        if(ptr<0){
            System.out.println("Stack is empty");
            return null;
        }
        return array[ptr];
    }

    void push(T value) {
        if(ptr+1>=capacity){
            System.out.println("Capacity Full");
            return;
        }
        ptr++;
        try {Thread.sleep(1000);} catch (Exception e) {};
        this.array[ptr]=value;
        System.out.println("Inserted "+value+" at "+ptr);
    }

    void pop() {
        try {Thread.sleep(100);} catch (Exception e) {};
        if(ptr<0){
            System.out.println("Nothing to pop");
            return;
        }

        array[ptr]=null;
        System.out.println("Popped "+array[ptr]+" at "+ptr);
        ptr--;
    }
}
