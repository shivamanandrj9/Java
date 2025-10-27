package Threading.synchronizedd;

public class Stack<T> {
    private T[] array;
    private int ptr;
    private int capacity;
    private Object lock;

    Stack(int capacity){
        this.array=(T[]) new Object[capacity];
        this.ptr=-1;
        this.capacity=capacity;
        lock=new Object();
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
        synchronized (lock){
            if(ptr+1>=capacity){
                System.out.println("Capacity Full");
                return;
            }
            ptr++;
            try {Thread.sleep(1000);} catch (Exception e) {};
            this.array[ptr]=value;
            System.out.println("Inserted "+value+" at "+ptr);
        }
    }

    synchronized void pop() {
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

/*
I have used synchronized(lock) at one place and synchronized void method name at other. This is just for understanding. This will not solve the current problem because there are two different locks. First is on Object lock, second on Object this. So they will anyway work independently. Solution here is to use single lock.
 */
