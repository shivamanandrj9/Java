Design Wise

1. To keep track of which subscriber has received till what message. Keep a subscriber-topic offset. Then we can simply query on message.id>offset.

2. Always keep id as integer which will be auto incremented. This is a better design(read about the btree arrangmenet changes when an UUID is used. It is heavy).

3. When a topic receives a message. Submit tasks to an executor service of a fixed thread pool that will send. If success, update the offset. If failed, 