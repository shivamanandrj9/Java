package pub.sub.manager;

import pub.sub.commons.Pair;
import pub.sub.daos.TopicDao;
import pub.sub.daos.TopicSubscriberMappingDao;
import pub.sub.entities.Topic;
import pub.sub.models.TopicContext;

import java.util.*;
import java.util.concurrent.*;

/**
 * Manages the dispatching logic for topics and subscribers.
 * Handles task submission to workers and manages worker threads.
 */
public class DispatchManager {

    // DAOs for data access
    TopicDao topicDao;
    TopicSubscriberMappingDao topicSubscriberMappingDao;

    // Maps Topic ID to its specific context/state
    Map<Integer, TopicContext> contexts;

    // List of workers responsible for processing tasks
    List<TopicWorker> topicWorkers;

    // Thread pool for managing worker execution
    ExecutorService executorService;

    /**
     * Constructor: Sets up basic dependencies and data structures.
     */
    public DispatchManager(TopicDao topicDao,
                           TopicSubscriberMappingDao topicSubscriberMappingDao,
                           int dispatcherCount){
        System.out.println("[DispatchManager] Constructor called.");
        this.topicDao = topicDao;
        this.topicSubscriberMappingDao = topicSubscriberMappingDao;

        // Initialize the fixed thread pool
        System.out.println("[DispatchManager] Initializing ExecutorService with dispatcherCount: " + dispatcherCount);
        this.executorService = Executors.newFixedThreadPool(dispatcherCount);

        // Initialize the context map
        this.contexts = new ConcurrentHashMap<>();
        System.out.println("[DispatchManager] DispatchManager instance created.");
    }

    /**
     * Initialization: Sets up topic contexts and workers.
     */
    public void initialize(int shards, int capacity){
        System.out.println("[DispatchManager] Starting initialization with shards: " + shards + ", capacity: " + capacity);

        // Read all topics from the DAO
        List<Topic> topics = topicDao.readAll();
        System.out.println("[DispatchManager] Read " + topics.size() + " topics from TopicDao.");

        for(Topic topic: topics){
            System.out.println("[DispatchManager] Initializing context for Topic ID: " + topic.getId());

            // Create a new context for the topic
            contexts.put(topic.getId(), new TopicContext());

            // Fetch subscriber IDs for this topic
            List<Integer> subIds = topicSubscriberMappingDao.getSubscribers(topic.getId());
            System.out.println("[DispatchManager] Found " + subIds.size() + " subscribers for Topic ID: " + topic.getId());

            for(int subId: subIds){
                // Initialize in-flight message tracking for each subscriber
                System.out.println("[DispatchManager] Setting in-flight map for Subscriber ID: " + subId + " on Topic ID: " + topic.getId());
                contexts.get(topic.getId()).setInFlights(subId, new TreeSet<>());
            }
        }

        // Initialize workers based on shard count
        this.topicWorkers = new ArrayList<>();
        System.out.println("[DispatchManager] Initializing " + shards + " TopicWorkers.");
        for(int i = 0; i < shards; i++){
            System.out.println("[DispatchManager] Creating TopicWorker index: " + i + " with capacity: " + capacity);
            topicWorkers.add(new TopicWorker(capacity));
        }
        System.out.println("[DispatchManager] Initialization complete.");
    }

    /**
     * Starts the worker threads.
     */
    public void run(){
        System.out.println("[DispatchManager] run() called. Starting worker threads...");
        for(int i = 0; i < topicWorkers.size(); i++){
            TopicWorker topicWorker = topicWorkers.get(i);
            System.out.println("[DispatchManager] Starting thread for TopicWorker index: " + i);
            Thread thread = new Thread(topicWorker);
            thread.start();
        }
    }

    /**
     * Routes a message to a specific worker based on a shard calculation.
     */
    public void submitTask(int topicId, int messageId) throws InterruptedException {
        // Simple sharding logic based on topicId
        int shardVal = topicId % topicWorkers.size();
        System.out.println("[DispatchManager] Routing Topic: " + topicId + ", Message: " + messageId + " to shard: " + shardVal);

        TopicWorker currWorker = topicWorkers.get(shardVal);
        currWorker.submitTask(topicId, messageId);
    }

    /**
     * Inner class representing a worker that consumes tasks from a queue.
     */
    public class TopicWorker implements Runnable {
        // Thread-safe queue for tasks
        BlockingQueue<Pair<Integer,Integer>> bq;

        /**
         * Constructor for TopicWorker.
         */
        public TopicWorker(int capacity){
            System.out.println("[TopicWorker] Initializing queue with capacity: " + capacity);
            this.bq = new ArrayBlockingQueue<>(capacity);
        }

        /**
         * Adds a task to the worker's queue.
         */
        public void submitTask(int topicId, int messageId) throws InterruptedException {
            System.out.println("[TopicWorker] Received task submission. Topic: " + topicId + ", Message: " + messageId);
            bq.put(new Pair(topicId, messageId));
            System.out.println("[TopicWorker] Task put in queue: [Topic: " + topicId + ", Message: " + messageId + "]");
        }

        /**
         * The execution loop for the worker thread.
         */
        @Override
        public void run() {
            System.out.println("[TopicWorker] Thread " + Thread.currentThread().getName() + " is now running.");
            try {
                while(!Thread.interrupted()){
                    // Take a task from the queue (blocking)
                    System.out.println("[TopicWorker] Waiting to take a task from the queue...");
                    Pair<Integer, Integer> task = bq.take();

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
                }

            } catch (InterruptedException e) {
                System.err.println("[TopicWorker] Thread interrupted: " + e.getMessage());
                throw new RuntimeException(e);
            }
            System.out.println("[TopicWorker] Thread " + Thread.currentThread().getName() + " has finished processing one task.");
        }
    }
}