package pub.sub.services;

import pub.sub.daos.TopicDao;
import pub.sub.entities.Topic;

public class TopicService {

    TopicDao topicDao;

    public TopicService(TopicDao topicDao){
        this.topicDao=topicDao;
    }

    public int addTopic(String topicName, int capacity){
        Topic topic=new Topic(topicName, capacity);
        return topicDao.insert(topic);
    }
}
