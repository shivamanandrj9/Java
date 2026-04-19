# Problem Statement

Design and implement a Publish-Subscribe system that allows publishers to send message to topics, and subscribers to receive messages from topics they are interested in. The system should support multiple topics, multiple subscribers per topic, and asynchronous message delivery.

# Functional Requirement

1. We will have some data structure to act as a topic. There can be multiple topics in this system.
2. There can be multiple publishers who will be pushing messages to any topic that they want. 
3. We should keep this thread safe so that parallel pushes does not corrupt the data.
4. There will be some subscriber to this topic. They can also unsubscribe
5. Also one subscriber can subscribe to multiple topics.
5. As soon as a message is received, by the topic, it will broadcast it to all the subscriber of this topic parallely.
6. We will have some TTL over the data, so that this topic persist the data for some time and clean it.

# Entities

1. Topic
    - id: int
    - name: String
    - capacity: int

2. Publisher
    - id: int

4. Message 
    - id: int
    - payload: String
    - publisherId: FK

5. MessageTopicMapping
    - messageId: FK
    - topicId: FK
    - createdAt: DateTime

5. Subscriber
    - id: int
    - name: String

6. TopicSubscriberMapping
    - topicId: FK
    - subscriberId: FK
    - isDeleted: boolean
    - offset: int


# Services

1. MessageService
    - int publishMessage(topicId, message, publisherId);

2. TopicService
    - int addTopic(String topicName, int capacity)

3. SubscriberService
    - int addSubscriber(name)
    - void listen(topicId, subscriberId)



# Models

1. TopicContext
    - Map<SubscriberId, Set<Integer>> inFlights;
    - BlockingQueue<MessageId> buffer;



# DAOs

1. TopicDao
2. PublisherDao
3. MessageDao
4. MessageTopicMappingDao
5. SubscriberDao
6. TopicSubscriberMappingDao

# Manager

1. RetryManager

2. DispatchManager
    - Map<TopicId, TopicContext> contexts;

    - void initialize()


