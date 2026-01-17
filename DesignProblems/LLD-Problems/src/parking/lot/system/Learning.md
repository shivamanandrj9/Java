1. Entities ka service will have list<> that will replicate the db and we will do any sort of action based on that via this service

2. How to keep lock handling separate -> Whatever you were doing directly inside the service layer, with the db resource, do it via a method call.


3. Concurrent Hash map karte time mapping agar value hai to kaise proceed karna hai.

4. ConcurrentHashmap me size wala kaise dekhenge

ENTRY SET RATTA