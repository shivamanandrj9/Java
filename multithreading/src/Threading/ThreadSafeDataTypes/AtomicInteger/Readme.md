So when we do 

Integer var=0;
var++;

the var++ looks like single line but internally it does this

Step 1: Read: The CPU fetches the value from memory (RAM) and loads it into a local Register.

Step 2: Modify: The CPU adds 1 to the value inside that register.

Step 3: Write: The CPU copies the new value from the register back to the memory address.


Now there might be race condition and data might corrupt. Let's say T1 and T2 both are doing this and T2 does step 3 after T1 does its step 3. This will just increment the var by 1.


So java have atomic variables that maintains the atomicity. It happens on CPU level by taking lock on that memory address.

