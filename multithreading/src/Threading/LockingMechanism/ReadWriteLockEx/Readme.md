1. Multiple thread can read but no one can write
2. While writing no other thread will read or write.

In Fair, we strictly follow the FIFO and club the reads
In Unfair, 

If there is a writer thread at the start of the queue, either this thread or another barged in write thread will be processed, not any read thread. Rest anyone can barge anytime not adhering to the queue.

