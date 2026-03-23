1. For the non functional requirement, think about these

CAP + Some use case based things like in uber (1:1 matching etc).

Now Partition Tolerance we always need, so don't talk about that. Instead for P think about the performance like Low Latency, Scalability, Availability



2. Low Latency
   1. Caching
   2. Unncessary reads or writes happening at DB

3. Scalability 
   1. How much qps is expected (DAU/10^5) ?
   2. Think in terms of each component. Can we decouple server based on responsibility?
   3. Spawning multiple instance based on which component is heavy lifting.
   4. Sharding (For DB's mostly)

4. Availability
   1. Replicas
   2. 