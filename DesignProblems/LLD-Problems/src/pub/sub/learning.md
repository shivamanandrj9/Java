# Naming Wise

1. Dispatcher -> Broker

# Data Type Wise

1. Whenever you want to store the instnace, save it as String. And you can then use String.valueOf(System.currentTimeMillis().toString()) and store it


# Design Wise

1. To keep track of which subscriber has received till what message. Keep a subscriber-topic offset. Then we can simply query on message.id>offset.

2. Always keep id as integer which will be auto incremented. This is a better design(read about the btree arrangmenet changes when an UUID is used. It is heavy).

3. Whenever you think of polling something. Always think if we can use BlockingQueue in order to have an event based logic.

4. When you add a blocking queue for event driven architecture, you always spawn a thread that uses the .take() method so that it only wakes when there is something to be processed.

5. Use observer pattern. So each Topic will have list of subscribers and notifyAll methods. Whatever we are doing in

```
int topicId = task.getKey();
                    int messageId = task.getValue();
                    System.out.println("[TopicWorker] Processing task - Topic: " + topicId + ", Message: " + messageId);


                    // Look up subscribers for the topic
                    List<Integer> subscriberIds = topicSubscriberMappingDao.getSubscribers(topicId);
                    System.out.println("[TopicWorker] Found " + subscriberIds.size() + " subscribers for Topic: " + topicId);

                    for(int subscriberId: subscriberIds){
                        System.out.println("[TopicWorker] Dispatching: Message ID " + messageId + " -> Topic ID: " + topicId + " -> Subscriber ID: " + subscriberId);
                        TopicContext currContext=contexts.get(topicId);
                        currContext.addInFlight(subscriberId, messageId);

                        Runnable runnable = () -> {
                            /*
                            Logic to call subscriber.receive in SubscriberManager, to actually push the data.
                             */
                            currContext.removeInFlight(subscriberId, messageId);
                            topicSubscriberMappingDao.updateCheckpoint(topicId, subscriberId, currContext.getCheckpoint(subscriberId, messageId));


                        };
                        executorService.submit(runnable);
                    }
```

We can actually do it inside the notifyAll method and the TopicContext can lie inside that topic object only which can be utilised then and there. The executor service can lie in the Dispatcher.

