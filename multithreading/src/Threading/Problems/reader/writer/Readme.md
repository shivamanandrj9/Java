Design a system where multiple reader threads and multiple writer threads access a shared resource.

Conditions
1. Multiple readers can read the resource at the same time.
2. Only one writer can write at a time.
3. When a writer is writing, no other thread (reader or writer) can access the resource.
4. The solution must prevent race condition and starvation (pick a fair strategy)