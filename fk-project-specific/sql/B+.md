## Rough Logic (If time then read about it) ##

Assume a table with primary key id and rows with ids:
[5, 10, 12, 21, 33, 41, 60, 75]
Internal node (non-leaf) might have separator keys like:
[20 | 40 | 70]
This creates child ranges:
Child 1: (-∞, 20]
Child 2: (20, 40]
Child 3: (40, 70]
Child 4: (70, +∞)
Leaf pages (each holds many sorted entries):
Leaf A (for (-∞,20]): rows id 5, 10, 12
Leaf B (for (20,40]): rows id 21, 33
Leaf C (for (40,70]): rows id 41, 60
Leaf D (for (70,+∞)): rows id 75
In InnoDB clustered index:
**Each leaf entry (e.g., id=33) contains the entire row (all columns), and a leaf page holds multiple such rows.**