package pub.sub.services;

import pub.sub.daos.SubscriberDao;
import pub.sub.daos.TopicSubscriberMappingDao;
import pub.sub.entities.Subscriber;
import pub.sub.entities.TopicSubscriberMapping;

public class SubscriberService {

    SubscriberDao subscriberDao;
    TopicSubscriberMappingDao topicSubscriberMappingDao;

    public SubscriberService(SubscriberDao subscriberDao){
        this.subscriberDao=new SubscriberDao();
    }

    public int addSubscriber(String name){
        Subscriber subscriber=new Subscriber(name);
        int subscriberId = subscriberDao.insert(subscriber);

        return subscriberId;
    }

    public void listen(int topicId, int subscriberId){
        TopicSubscriberMapping topicSubscriberMapping=new TopicSubscriberMapping(topicId, subscriberId, false, 0);

        topicSubscriberMappingDao.insert(topicSubscriberMapping);

    }
}
