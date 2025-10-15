## Flow of database management ##

Level 1: Our Code
1. Our code talks to hibernate in terms of objects and classes.
2. There are annotations and methods that are provided by hibernate(ORM).
3. The JPA(Java Persistence API) annotations that is used in the code has its implementation provided by hibernate only. JPA annotations are defined by JPA and implemented by our provider(Hibernate).

Level 2: Hibernate
1. This maps the code to correct sql query and passes to JDBC
2. It translates object changes into SQL and defers sending SQL until “flush.”
3. It also maintains the persistence context(See below)

Level 3: JDBC Driver
1. Uses MySQL Protocol to pass the SQL to the MySQL Server(This is our DBMS).

Level 4: MySQL Server
1. Parses/optimizes SQL
2. enforces permissions
3. coordinates transactions
4. Dispatches operations to the Engine which is actually managing the database

Level 5: Storage Engine (InnoDB by default for MySQL server 8.0)
1. Actually stores data;
2. reads/writes disk
3. implements ACID


## Hibernate and Persistence Context ##

There are 3 caches maintained 
1. L1 : This is maintained per session and is cleared once the session/transaction is completed. It is also called the persistence context.
2. L2 : This is maintained by session factory and is shared across sessions.
3. Query Cache : Stores the queryId and its result for fast serving the query. It relies on L2 for the actual state.

Whenever a query(create, update, read) is triggered from the code for an object for the first time. The object's state is stored in the L1 cache for this session. Any changes that we do in the same transaction is on the L1 cache where we change its state. 
At the end of transaction we flush this to MySQL and hibernate generates the query looking at the final and initial state of that object. now MySQL commits to the database.

---
FYI:
1 session can have multiple transaction. 

Transactionality boundary is decided according to our need of ACID.

Within each transaction, there can be multiple flushes but the commit will be at the end of transaction.

Flush executes SQL within the current (still-open) transaction — changes are not durable and may not be visible to other transactions depending on isolation. Commit finalizes at the DB, making the changes durable and releasing locks. Rollback undoes flushed changes.

---

## Transaction Isolation Level ##





## SQL Lock Types ##








## Hibernate Specific ##

1) The commiting happens in this order Insert, Update and then Delete
2) The select query whenever in the code has the context of what happens above by having a snapshot and updating that whenever it goes through any insert, update delete.

