Plain SELECTs rely on the MVCC(Multi Version Concurrency Control) snapshot and do not take row or gap locks. MVCC affects consistent reads (plain SELECTs) only.


Any statement that can change data (INSERT, UPDATE, DELETE) takes exclusive row locks on affected rows; in Repeatable Read it may also take next‑key locks on searched ranges.

UPDATE/DELETE in InnoDB are “current/locking reads”: they see the latest row, wait on locks, and re-check the WHERE after the wait.