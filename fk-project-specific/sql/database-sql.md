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

Some code part is sent to the DB and becomes part of transaction immediately while some become part of transaction after the commit.

Patterns to identify if it becomes part of transaction as soon as the code line got executed:
1. The query is returning something (update me row count, all the select queries)
2. Select for update, share
3. specifically mentioned like .executeUpdate()

---
FYI:
1 session can have multiple transaction. 

Transactionality boundary is decided according to our need of ACID.

Within each transaction, there can be multiple flushes(DB tak pahuchana) for that transaction but the commit will be at the end of transaction. Once the flushes are done, we issue commit in our code and the hibernate delegates commit to the MySQL and is then commited by the DB engine.

Flush executes SQL within the current (still-open) transaction.
Hibernate sends SQL and the DB applies the changes inside the current, still‑open transaction. The new state lives in the database’s transactional structures (not in Hibernate caches).
Changes are not durable and may not be visible to other transactions depending on isolation. Commit finalizes at the DB, making the changes durable and releasing locks. Rollback undoes flushed changes.



---

## Violations ##

### Dirty Read ###

A transaction reads data written by another transaction that has not committed yet.

### Non-repeatable reads ###

Within one transaction, re-reading the same row returns a different value because another transaction committed an update in between.

### Phantom reads ###

Re-executing the same range query returns a different set of rows because another transaction inserted/deleted rows matching the range.

## Transaction Isolation Level ##

Now consider two transactions happening, we have isolation level on the basis of which we decide which actions are getting isolated within two separate transactions.

Isolation level can be set at global, session, transaction level.

### Read Committed ###

Only allows commited values to be read. If T1 changes some value mid transaction and T2 tries to read it, it will read only the older value until T1 is committed.



### Read Uncommitted ### 

Allows uncommited values to be read between two transaction.



### Repeatable Read ### 

Guarantees that within a transaction, reading the same row(s) twice returns the same values (no non‑repeatable reads)

    If T2’s first SELECT happens after T1 commits, T2 sees T1’s updated value.
    If T2’s first SELECT happened before T1 commits, T2 will not see T1’s change in later plain SELECTs within the same transaction.



### Serializable ### 
Whatever rows or ranges T1 touches (read or write), InnoDB takes next-key locks on them; until T1 ends, T2 cannot UPDATE/DELETE those rows, cannot INSERT new rows into those ranges, and any read that would touch them must wait.

### Textbook (ANSI SQL) view

| Isolation level    | Dirty reads | Non-repeatable reads | Phantom reads |
|---|---|---|---|
| READ UNCOMMITTED   | Allowed     | Allowed              | Allowed       |
| READ COMMITTED     | Not allowed | Allowed              | Allowed       |
| REPEATABLE READ    | Not allowed | Not allowed          | Allowed       |
| SERIALIZABLE       | Not allowed | Not allowed          | Not allowed   |

### InnoDB (MySQL) practical behavior

| Isolation level    | Dirty reads | Non-repeatable reads | Phantom reads                                                   |
|---|---|---|-----------------------------------------------------------------|
| READ UNCOMMITTED   | Allowed     | Allowed              | Allowed                                                         |
| READ COMMITTED     | Not allowed | Allowed              | Allowed                                                         |
| REPEATABLE READ    | Not allowed | Not allowed          | Not allowed (for the same predicate) (because of next key lock) |
| SERIALIZABLE       | Not allowed | Not allowed          | Not allowed                                                     |








## Hibernate Specific ##

1) The commiting happens in this order Insert, Update and then Delete
2) The select query whenever in the code has the context of what happens above by having a snapshot and updating that whenever it goes through any insert, update delete.

