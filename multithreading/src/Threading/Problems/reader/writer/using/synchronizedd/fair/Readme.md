We don't want to starve any request

Solution:
First thing comes in mind is FIFO via queue.
But we can further optimize it by processing all the reads in batch.