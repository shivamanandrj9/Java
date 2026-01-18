This is the "magic" of the circular array. To understand "moving backward," you have to stop thinking of the array as a straight line and start thinking of it as a circle.

In an ArrayDeque, the head and tail pointers can be anywhere. They don't have to start at index 0.

The "Circular" Setup
Imagine an array with 8 slots (indices 0 to 7). Initially, the head and tail are both at index 0.

Step 1: addLast(A) (The Normal Way)
When you add to the back, the tail pointer moves forward (+1).

Element A is placed at index 0.

tail moves to index 1.

head is still at 0. Array: [A, _, _, _, _, _, _, _]

Step 2: addFirst(B) (The "Backward" Move)
Now, you want to put B at the front. The head is currently at index 0. To put something "before" the current head, the pointer needs to move "left."

But there is no index −1!

This is where the circular wrap-around happens. The head pointer jumps (wraps) to the very end of the array (index 7).

head moves from 0 → 7.

Element B is placed at index 7. Array: [A, _, _, _, _, _, _, B] (Note: B is logically "before" A in the Deque, even though its index is higher.)

Step 3: addFirst(C)
We want to add another element to the front. The head is at index 7.

head moves "backward" again: 7 → 6.

Element C is placed at index 6. Array: [A, _, _, _, _, _, C, B]

How it looks logically vs. physically
Even though the array looks messy, the Deque reads it from head to tail by wrapping around:

Logically (what you see): [C, B, A]

Physically (the internal array): Index 0:A ... Index 6:C, Index 7:B

The Math behind it
To make this happen instantly (O(1)) without if statements, Java uses a bitwise trick or a modulo operator:

head=(head−1) & (length−1)
If head is 0 and length is 8, this calculation results in 7. This is how it "jumps" to the end of the array in a single CPU cycle.

Why is this better than a normal array?
In a standard ArrayList, if you wanted to addFirst(), you would have to shift every single element to the right to make room at index 0. That is O(n).

In ArrayDeque, we just move a pointer and wrap around, making it O(1).

Would you like to see what happens when the head and tail pointers eventually meet (i.e., when the array is full)?