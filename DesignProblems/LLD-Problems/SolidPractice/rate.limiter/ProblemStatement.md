# Design a distributed rate limiter #

A rate limiter controls how many requests a client can make within a specific timeframe.
It acts like a traffic controller for your API - allowing, for example, 100 requests per minute from a user then rejecting excess requests with a HTTP 429 "Too many request" response. Rate limiters prevent abuse, protect your servers from bein overwhelmed by bursts of traffic, and ensure fair usage across all users.

# Functional requirements #

1. A layer for upcoming request that returns true or false if a request is not breaching the rate. The rules should be configurable.
2. The layer should identify user specific context, either via userId, IP, API Key or some other parameters.
3. Returns proper error with the response code, after how much time it will be active. 


# Scale #
1. 100 M DAU
2. 1 M rps

# Non Functional Requirements #

``
Think in terms of CAP first. Make meaning of the C,A and P for this context and see which can be sacrificed
``

P (Partition Tolerance) -> Let's say there were 2 nodes and we were allowing 100 req/sec but due to some fault it is no longer connected and now each node is unaware of the other and might allow 100 req/sec per node resulting in 200 req/sec. This will have effect on the other downstream/upstream systems. So we want it.


C (Consistency) -> If a config changes happen for the rate limiter, every distributed system should be consistent with that.

A (Availability) -> Each node has always this rate limiter on no matter what.


For the rate limiter, we choose A,P.


1. We choose A and P
2. low latency

# Core Entities #

``We will extract out the core entites from the above``

1. RateLimiterRequestDTO - {id, privilege}
2. User - {id, tokensLeft, lastRequestTime, lastTokenRefreshTime}
3. RateLimiterResponseDTO - {ResponseCode, resetTime}
4. Rules - {allowedRequestPerSec, ...}


# Where should Rate Limiter live in our arch #

![Screenshot 2025-12-25 at 2.22.32 PM.png](imgs/Screenshot%202025-12-25%20at%202.22.32%E2%80%AFPM.png)

Client -> The reason of not doing this is that if the rate limiter is at the client end then the backend call can be spoofed and our system can be taken down

Microservice instances -> Let's say alice request went to 1 and bob request went to 2. How will they sync? 

![Screenshot 2025-12-25 at 2.30.42 PM.png](imgs/Screenshot%202025-12-25%20at%202.30.42%E2%80%AFPM.png)

Why not this?
This will make the rate limiter service as isolated and will add extra latency overhead.


Hence, we choose to keep it very close to the layer that is at the edge, which is the gateway. There can be multiple gateway instances each running this lightweight ratelimiter process.

# which algorithm will the rate-limiter will be running ? #

![Screenshot 2025-12-25 at 2.42.47 PM.png](imgs/Screenshot%202025-12-25%20at%202.42.47%E2%80%AFPM.png)

So here, we keep hashmap for every user. Let a request came in at from alice at 12:00:34 then we will check how many total request are there currently for 12:00:00, if this is at the limit, we return false otherwise true and increment it. 

---
FYI:
The industry standard for the db choice for the rate limiter is redis. Because it is fast and also we get support of TTL.
---

The cleanup happens using this Redis TTL only. while creating the key i.e. 12:00:00, we set its TTL to 60 sec. 

Problem:
The boundary problem let's say alice sends 100 request at 12:00:59 and then again 100 request at 12:01:00. This will end up having 200 req/in just 2 sec.


---------
![Screenshot 2025-12-25 at 2.51.51 PM.png](imgs/Screenshot%202025-12-25%20at%202.51.51%E2%80%AFPM.png)

Here a min-heap is used. So for each user, we have a heap. Each request is stored in the heap as single unit, not collectively. So if there are 5 req at 12:00:05 then 5 objects of 12:00:05 is stored.
When a request comes in, it adds to this heap and it will start taking out the top of the heap which does not lie in the 60 sec range. Finally it calculates the heap size and on that basis comparing to threshold it decide to allow or not. 
This logic does not have to rely on the redis TTL.


Problem: This heap can grow a lot, let's say 5000 req comes in a min. We need to add it. to the heap, although we are going to reject many of them.

---
![Screenshot 2025-12-27 at 1.10.14 PM.png](imgs/Screenshot%202025-12-27%20at%201.10.14%E2%80%AFPM.png)


so it stores 2 counter per user, previous minute's total request and current minute's request uptil now. When a request comes in. It calculates the expected request for this minute. it takes the percentage of time left in the current minute and takes that percentage of request from the previous minute and add to the current total request. Then makes the decision. It does not store the rejected request

Problem:
This is an approximation. Let's say for the previous minute, all the 100 req came in at the last sec then for the next minute, if even small number of burst request comes in, some of them get rejected due to this approximation.

Think about 60 req per minute. 

---
![Screenshot 2025-12-27 at 1.15.31 PM.png](imgs/Screenshot%202025-12-27%20at%201.15.31%E2%80%AFPM.png)

Here for each user, we have a bucket. Now this bucket holds the count of token. The logic works like this.

1. A req came in. First we check a) last refil time b) current token count
2. Now based on the configured rate of refil and the time diff, we update this current token count uptil the bucket limit.
3. if this count is greater than 0, we accept the request.
4. We update a and b.

Now this will require atomic operation hence we take lock on a and b and releases it after the write.

---
Deep dive

![Screenshot 2025-12-27 at 1.27.34 PM.png](imgs/Screenshot%202025-12-27%20at%201.27.34%E2%80%AFPM.png)


So the process runs in the gateway and we use redis to the store the user the user info. We do sharding for fast retrival where each user lies in one of the shards.

![Screenshot 2025-12-27 at 1.30.30 PM.png](imgs/Screenshot%202025-12-27%20at%201.30.30%E2%80%AFPM.png)

so HMGET "alice:bucket" <- key
gives the field tokens and last_refill.


![Screenshot 2025-12-27 at 1.35.48 PM.png](imgs/Screenshot%202025-12-27%20at%201.35.48%E2%80%AFPM.png)

These are headers sent by the Server back to the Client in the HTTP response.

For the Token Bucket.

X-RateLimit-Remaining is the current updated count of tokens in the bucket.
X-RateLimit-Reset 

![Screenshot 2025-12-27 at 1.40.22 PM.png](imgs/Screenshot%202025-12-27%20at%201.40.22%E2%80%AFPM.png)

---

Fail Open -> When rate limiter is not working, all the request get acception
Fail Close -> When rate limiter is not working, all the request get rejected.

We generally choose the second one. Or we can have alternative fallback simple logic.

---
Will it be good to queue the request rather than failing.
For user facing application -> No, because the user might retry while waiting and this will make the queue grow.
For the intra service application -> Yes.

--- 
![Screenshot 2025-12-27 at 1.45.16 PM.png](imgs/Screenshot%202025-12-27%20at%201.45.16%E2%80%AFPM.png)
We can integrate Zookeepre(etc) for any config changes.









