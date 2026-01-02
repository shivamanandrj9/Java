
In terms of rate limiter, for the NFRs (Hint: First think via CAP)


**CAP:** 






While documenting
1. Fail fast in case of the user facing as the user will continue retrying and it will fail fast.
2. queue for intra service communication

alice ka bucket alice ke shard me. api key aur user id ke basis pe shard -> Think about consistent hashing