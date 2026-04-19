package pub.sub.manager;


import pub.sub.commons.Pair;
import pub.sub.daos.TopicDao;
import pub.sub.daos.TopicSubscriberMappingDao;
import pub.sub.entities.Topic;
import pub.sub.models.TopicContext;

import java.util.*;
import java.util.concurrent.*;

public class DispatchManager {

    TopicDao topicDao;
    TopicSubscriberMappingDao topicSubscriberMappingDao;
    Map<Integer, TopicContext> contexts;
    List<TopicWorker> topicWorkers;
    ExecutorService executorService;

    public DispatchManager(TopicDao topicDao,
                           TopicSubscriberMappingDao topicSubscriberMappingDao,
                           int dispatcherCount){
        this.topicDao=topicDao;
        this.topicSubscriberMappingDao=topicSubscriberMappingDao;
        this.executorService=Executors.newFixedThreadPool(dispatcherCount);
        this.contexts=new HashMap<>();
    }

    public void initialize(
            int shards,
            int capacity){

        List<Topic> topics = topicDao.readAll();
        for(Topic topic: topics){
            contexts.put(topic.getId(), new TopicContext());
            List<Integer> subIds=topicSubscriberMappingDao.getSubscribers(topic.getId());
            for(int subId: subIds){
                contexts.get(topic.getId()).setInFlights(subId, new TreeSet<>());
            }
        }

        this.topicWorkers=new ArrayList<>();
        for(int i=0;i<shards;i++){
            topicWorkers.add(new TopicWorker(capacity));
        }
    }

    public void run(){
        for(TopicWorker topicWorker: topicWorkers){
            Thread thread=new Thread(topicWorker);
            thread.start();
        }
    }

    public void submitTask(int topicId, int messageId) throws InterruptedException {
        int shardVal=topicId%topicWorkers.size();
        TopicWorker currWorker=topicWorkers.get(shardVal);
        currWorker.submitTask(topicId, messageId);
    }


    public class TopicWorker implements Runnable {
        BlockingQueue<Pair<Integer,Integer>> bq;

        public TopicWorker(int capacity){
            this.bq=new ArrayBlockingQueue<>(capacity);
        }

        public void submitTask(int topicId, int messageId) throws InterruptedException {
            bq.put(new Pair(topicId, messageId));
            System.out.println("Task with message: " + messageId+ " for the topic: " + topicId);
        }

        @Override
        public void run() {
            try {
                Pair<Integer, Integer> task=bq.take();
                int topicId=task.getKey();
                int messageId=task.getValue();

                List<Integer> subscriberIds=topicSubscriberMappingDao.getSubscribers(topicId);

                for(int subscriberId: subscriberIds){
                    System.out.println("Task with message: " + messageId +" dispatched for topicId: " + task.getKey() + " and subscriberId: "+subscriberId);
                    //TODO: Will add logic to submit to the executor service
                }

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }



}
