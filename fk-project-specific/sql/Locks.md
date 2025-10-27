## Next-Key and Gap Lock ##

1. This lock is put on the index. For a query, the locks are only put on the indexes that are getting utilised in that particular query.

2. How it happens

So there can be two types on indexing (unique, non-unique)

Unique -> key on the basis of indexing is done contains (1 key -> 1 row). Ex: Primary key indexing. For the unique ones, the row which is being queried are the only locks on which the locks are being taken. Because, whenever you want to insert something, we know that the index key will be unique and there won't be any phantom reads etc if we run the same query to either get the same row or ranges.

Non-Unique -> (1 key -> multiple rows). The next key lock explained below is actually for this type of case

Now let's say the keys are

[5,10, 17, 30, 100].

The key gap ranges are defined as
(-inf, 5], (5, 10], (10, 17], (17, 30], (30, 100], (100, inf)

Now there are two cases.

1) single row query (id=30) -> it will lock all the rows with id=30 and also lock the gaps -> this key lies in (17, 30]. So it will lock the keys ((17,30) + 30)
2) range row query (id > 6 & id<20) -> ranges covered are (5, 10], (10, 17], (17, 20]. -> locks are taken on them




FYI:

Single row query (id = 30)
If using a full unique index: record lock on 30 only (neither gap nor next-key).
If non-unique index: this is a next-key lock on (17, 30].

Range query (id > 6 AND id < 20)
Next-key locks on (5, 10] and (10, 17]
Plus a final gap lock on (17, 30) to cover the open end (not (17, 20), because 20 doesn’t exist; InnoDB locks up to the next index key).


## Shared Lock and Exclusive Lock ##

Shared lock (S): Many readers can hold it; blocks writers.
Exclusive lock (X): Only one holder; blocks readers and writers.

| Existing | Requesting S | Requesting X |
|---|---|---|
| S | Allowed | Blocked |
| X | Blocked | Blocked |


Insert, update, delete -> X next-key/gap lock
read -> S next-key/gap lock 
read(for update) -> X next-key/gap lock 


## Optimistic and Pessimistic Lock ##

S/X are low-level lock modes. By default, plain SELECTs in MVCC don’t lock, while writes take X locks (often on index ranges via next‑key/gap). If you use locking reads (FOR UPDATE(X) / FOR SHARE(S)), the read phase also takes S/X locks.

They don’t protect read-to-write reasoning or rows that don’t yet exist. 
For example, we use select to get info of some row/s and then we are making decision in between based on the value and then doing some write based on this. So while writing S/X will take lock on the newly written or updated row. If there are two transaction doing the same for example

```
-- Tx A
START TRANSACTION;
SELECT * FROM doctors WHERE on_call = true;   -- sees {alice,bob}
-- decides "I'll go off; Bob will still be on"
UPDATE doctors SET on_call=false WHERE name='alice';
COMMIT;

-- Tx B (concurrent)
START TRANSACTION;
SELECT * FROM doctors WHERE on_call = true;   -- also sees {alice,bob} (snapshot)
-- decides "I'll go off; Alice will still be on"
UPDATE doctors SET on_call=false WHERE name='bob';
COMMIT;

```

This will cause both to be false.

This will generally happen in below cases
1. Your correctness depends on a predicate/aggregate across multiple rows.
2. You must ensure the state you read stays valid until you write.
3. You must block phantom inserts/updates into a range you reasoned about.

Now there are two ways to solve this,
1. Optimistic
2. Pessimistic (Pe -> Pehle hi lock)

### Optimistic ###
We allow concurrent work, then at update time the statement includes an extra WHERE (e.g., version/timestamp) to validate nothing changed.
The write statement have some extra where condition to check the changed states(the version we read -> The current version while updating). If it mismatches we throw exception. 

This is useful when we expect the issue happening less frequently and don't want to add extra overhead in locking etc

### Pessimistic ###
We acquire S/X lock(on a specific row or next-key/gap) the moment we read something. In sql terms (SELECT * FROM table WHERE ... FOR UPDATE) 

This ensures what we read stays valid until we write

If we set isolation level to SERIALIZABLE in MySql(InnoDB), it automatically enforces the pessimistic locking by adding locks when reading. 



Most can be solved either way, but the optimistic solution must validate a shared thing (constraint/guard/counter/version) in a single atomic step and be ready to retry. Some cases on MySQL are much simpler with pessimistic range locks.













