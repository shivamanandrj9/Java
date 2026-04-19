package pub.sub;

import pub.sub.daos.*;
import pub.sub.manager.DispatchManager;

public class Main {
    public static void main(String[] args) {
        TopicDao topicDao=new TopicDao();
        TopicSubscriberMappingDao topicSubscriberMappingDao=new TopicSubscriberMappingDao();
        MessageDao messageDao=new MessageDao();



        DispatchManager dispatchManager=new DispatchManager(topicDao,topicSubscriberMappingDao,5);
        dispatchManager.initialize(5, 10);


    }
}
