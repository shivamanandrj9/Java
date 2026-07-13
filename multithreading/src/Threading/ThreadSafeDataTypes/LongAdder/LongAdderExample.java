package Threading.ThreadSafeDataTypes.LongAdder;

import java.util.concurrent.atomic.LongAdder;

public class LongAdderExample {
    public static void main(String[] args) {
        /*
        1. When to use it?
        -> When the write is very frequent and while reading you can manage eventual consistency.

        2. Design
        -> So normal AtomicInteger/AtomicLong works on CAS. 
        -> In LongAdder, we have
            -> Volatile Long Base
            -> Volatile Long[] cells
        -> So when a .add(x) request comes in. It goes to the Base to add it via CAS, 
            -> If it is a success, its fine. 
            -> If it fails, unlike AtomicLong, it won't retry, but hash threadProbe(Random integer assigned to a thread) to find a cell to update via CAS
                -> if it is a success, its fine.
                -> If it fails, it will advanced the threadProbe(get a new random integer) and try with another cell. If after some number of times(generally 3),It still keeps failing, it will increase the cell size (maximum it can reach to number of cores) and try again. Even after increasing te cell array size, it keeps colliding, it continues to do rehashing and CAS until it success.

        -> During  the read, the base and cells are iterated and summed up to give the value. It might be caught in between and multiple threads are updating their cells.
         */


        LongAdder val=new LongAdder();

        // Adding a value
        val.add(10);
        val.add(-5);

        //Fetching a value
        System.out.println(val.sum());

        //Reseting the value
        Long beforeResetValue=val.sumThenReset();
        System.out.println(beforeResetValue);
        System.out.println(val.sum());
        
    }
}
