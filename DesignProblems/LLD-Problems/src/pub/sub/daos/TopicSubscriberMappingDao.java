package pub.sub.daos;

import pub.sub.entities.MessageTopicMapping;
import pub.sub.entities.TopicSubscriberMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TopicSubscriberMappingDao {

    List<TopicSubscriberMapping> topicSubscriberMappings;

    public TopicSubscriberMappingDao(){
        this.topicSubscriberMappings=new ArrayList<>();
    }

    public void insert(TopicSubscriberMapping topicSubscriberMapping){
        topicSubscriberMappings.add(topicSubscriberMapping);
    }

    public List<Integer> getSubscribers(int topicId){
        return topicSubscriberMappings.stream().filter(t -> {
            return t.getTopicId() == topicId;
        }).map(TopicSubscriberMapping::getSubscriberId).collect(Collectors.toList());
    }

    public void updateCheckpoint(int topicId, int subscriberId, int checkpoint){
        TopicSubscriberMapping mapping=topicSubscriberMappings.stream().filter(t ->{
            return (t.getTopicId()==topicId && t.getSubscriberId()==subscriberId);
        }).collect(Collectors.toList()).get(0);

        mapping.setOffset(checkpoint);

    }
}
