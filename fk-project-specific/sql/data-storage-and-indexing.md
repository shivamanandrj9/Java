When a table is created, it depends on the engine on how the data is being stored.

In InnoDB(MySQL), first a B+ tree is created based on primary key and the leaf node(some physical address) stores all the data of that particular row. If no explicit PK, InnoDB picks a unique NOT NULL key, else a hidden row id.

In some engines, the B+ tree are there but the actual data is stored somewhere in the heap and the leaf node only stores the pointers.

Note: If in B+ tree, the leaf is storing the whole row data it is called clustered. 
For the other cases like the leaf is storing the heap location or (secondary key, primary key(to again do the lookup on the clustered index)), it is called non - clustered.


In InnoDB, there is one clustered index per table. For the other index, we have non-clustered index where the leaf stores (secondary_key, primary_key).



