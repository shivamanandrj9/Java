# Data Type Wise

1. Whenever you want to store the instnace, save it as String. And you can then use String.valueOf(System.currentTimeMillis().toString()) and store it


# Design Wise

1. To keep track of which subscriber has received till what message. Keep a subscriber-topic offset. Then we can simply query on message.id>offset.

2. Always keep id as integer which will be auto incremented. This is a better design(read about the btree arrangmenet changes when an UUID is used. It is heavy).

3. Whenever you think of polling something. Always think if we can use BlockingQueue in order to have an event based logic.

4. When you add a blocking queue for event driven architecture, you always spawn a thread that uses the .take() method so that it only wakes when there is something to be processed.

