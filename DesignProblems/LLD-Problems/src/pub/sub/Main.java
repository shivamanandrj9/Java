package pub.sub;

import pub.sub.daos.*;
import pub.sub.entities.TopicSubscriberMapping;
import pub.sub.manager.DispatchManager;
import pub.sub.services.MessageService;
import pub.sub.services.SubscriberService;
import pub.sub.services.TopicService;

public class Main {

    // Static references to DAOs and Services for use across private methods
    private static TopicDao topicDao;
    private static SubscriberDao subscriberDao;
    private static MessageDao messageDao;
    private static MessageTopicMappingDao messageTopicMappingDao;
    private static TopicSubscriberMappingDao topicSubscriberMappingDao;

    private static DispatchManager dispatchManager;

    private static TopicService topicService;
    private static SubscriberService subscriberService;
    private static MessageService messageService;

    // IDs stored for use in publishing
    private static int techTopicId;
    private static int sportsTopicId;

    public static void main(String[] args) {
        try {
            System.out.println("=== SYSTEM STARTUP ===");

            // 1. Setup the data layer
            initializeDaos();

            // 2. Setup the business and management layer
            initializeServicesAndManager();

            // 3. Populate with initial test data
            seedInitialData();

            // 4. Start the background worker threads
            startWorkerThreads();

            // 5. Trigger the message flow
            runMessageSimulation();

            // Final wait to see async outputs
            System.out.println("[Main] Waiting for workers to process queues...");
            Thread.sleep(2000);
            System.out.println("=== SYSTEM SHUTDOWN ===");

        } catch (Exception e) {
            System.err.println("[Main] FATAL ERROR: " + e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * Instantiates all DAO objects.
     */
    private static void initializeDaos() {
        System.out.println("[Step 1] Initializing DAOs...");
        topicDao = new TopicDao();
        subscriberDao = new SubscriberDao();
        messageDao = new MessageDao();
        messageTopicMappingDao = new MessageTopicMappingDao();
        topicSubscriberMappingDao = new TopicSubscriberMappingDao();
        System.out.println("[Step 1] All DAOs initialized successfully.");
    }

    /**
     * Instantiates the Manager and Service layers.
     */
    private static void initializeServicesAndManager() {
        System.out.println("[Step 2] Initializing Manager and Services...");

        // DispatchManager with 3 dispatcher threads
        dispatchManager = new DispatchManager(topicDao, topicSubscriberMappingDao, 3);

        // Services
        topicService = new TopicService(topicDao);
        subscriberService = new SubscriberService(subscriberDao);
        messageService = new MessageService(messageDao, messageTopicMappingDao, dispatchManager);

        System.out.println("[Step 2] Manager and Services are ready.");
    }

    /**
     * Seeds topics, subscribers, and their relationships.
     */
    private static void seedInitialData() {
        System.out.println("[Step 3] Seeding initial data...");

        // Adding Topics
        techTopicId = topicService.addTopic("Tech_News", 10);
        sportsTopicId = topicService.addTopic("Sports_Updates", 10);
        System.out.println("[Data] Created Topic: Tech_News (ID: " + techTopicId + ")");
        System.out.println("[Data] Created Topic: Sports_Updates (ID: " + sportsTopicId + ")");

        // Adding Subscribers
        int subId1 = subscriberService.addSubscriber("Alice");
        int subId2 = subscriberService.addSubscriber("Bob");
        int subId3 = subscriberService.addSubscriber("Charlie");
        System.out.println("[Data] Created Subscribers: Alice(" + subId1 + "), Bob(" + subId2 + "), Charlie(" + subId3 + ")");

        // Manual mapping (as seen in previous snippets)
        System.out.println("[Data] Mapping subscribers to topics...");
        topicSubscriberMappingDao.insert(new TopicSubscriberMapping(techTopicId, subId1, false, 0));
        topicSubscriberMappingDao.insert(new TopicSubscriberMapping(techTopicId, subId2, false, 0));
        topicSubscriberMappingDao.insert(new TopicSubscriberMapping(sportsTopicId, subId3, false, 0));

        System.out.println("[Step 3] Data seeding complete.");
    }

    /**
     * Initializes the DispatchManager shards and starts worker threads.
     */
    private static void startWorkerThreads() {
        System.out.println("[Step 4] Configuring DispatchManager Workers...");

        // 2 shards, capacity of 5 messages per shard
        dispatchManager.initialize(2, 5);

        System.out.println("[Step 4] Starting worker threads...");
        dispatchManager.run();
    }

    /**
     * Simulates the publishing of messages to different topics.
     */
    private static void runMessageSimulation() throws InterruptedException {
        System.out.println("[Step 5] Running Message Simulation...");

        // Publish to Tech Topic
        System.out.println("[Sim] Publishing to Tech...");
        messageService.publishMessage(techTopicId, "New Java Features Released!", 501);

        // Publish to Sports Topic
        System.out.println("[Sim] Publishing to Sports...");
        messageService.publishMessage(sportsTopicId, "Championship Finals tonight!", 502);

        // Another one to Tech
        System.out.println("[Sim] Publishing again to Tech...");
        messageService.publishMessage(techTopicId, "Microservices vs Monoliths", 501);

        System.out.println("[Step 5] All messages submitted to Dispatcher.");
    }
}