For the user facing APIs, we can communicate a number of ~200 ms for the latency

---

Here along with URLs we have also mentioned the number of URLs we are dealing with because 1 user can create multiple URLs.

---

Here decoupling of service can be done for the read and the write.

---

301 -> Permanent Redirect
302 -> Temporary Redirect

This is a temporary shortening so we will send 302 in response

---

Different ways to generate a code
1. Random Base62 encoded string -> Any logic of generating random or any logic of hashing something will eventually end up checking for duplicacy in the database
2. Best solution -> User global counter in Redis. 
    Cons: This can be predictable
        Solution1: Tell user do not encode valuable information
        Solution2: We can use some secret key and XOR it with this counter.

---


Now we will see how we satisfied the NFRs

# Low Latency 

Seeing the DAU, we will calculate the request per second

10^8 / 10^5(Number of seconds in a day) = 1000 rps = 1k ------considering peak-----> 10 k to 100 k rps

Used Cache for low latency here


# Scalability

1. Decoupled read and write service
2. multiple instances of reads if they are more
3. sharding on DB

# High Availability

1. Replicase










