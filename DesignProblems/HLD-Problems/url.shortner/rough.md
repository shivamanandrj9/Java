Functional Requirements

1. Given a LongUrl -> shortCode
2. This shortCode should be unique
3. shortCode -> 301 to redirect with the longUrl
4. TTL associated to a url

Non Functional Requirements

1. Consistency -> Fine with eventual consistency
2. The system should be highly available
3. DAU = 1 M (40 % Write and 60 % Read)
4. Should have low latency (~200 ms)

Core Entities

1. Users
2. Urls




