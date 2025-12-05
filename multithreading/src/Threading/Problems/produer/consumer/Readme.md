Problem statement:

The problem is how to make these two workers cooperate so that data is not lost or corrupted. You must solve three specific scenarios:

1. Buffer Full (Overflow): If the shelf is full, the Producer must stop and wait. They cannot add more cakes until the Consumer makes space.

2. Buffer Empty (Underflow): If the shelf is empty, the Consumer must stop and wait. They cannot take a cake that doesn't exist yet.

3. Simultaneous Access (Data Corruption): If both try to add and remove a cake at the exact same time, they might crash into each other (corrupt the data structure). Only one person can touch the shelf at a time.

Imagine a queue as shelf and implement it.