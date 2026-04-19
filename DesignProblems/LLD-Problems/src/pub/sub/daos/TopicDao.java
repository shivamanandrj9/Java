package pub.sub.daos;

import pub.sub.entities.Topic;

import java.util.ArrayList;
import java.util.List;

public class TopicDao {
    List<Topic> topics;

    public TopicDao(){
        this.topics=new ArrayList<>();
    }

    public int insert(Topic topic){
        int maxId=0;
        for(int i=0;i<topics.size();i++){
            maxId=Math.max(maxId, topics.get(i).getId());
        }
        maxId++;
        topic.setId(maxId);
        topics.add(topic);
        return maxId;
    }

    public List<Topic> readAll(){
        return this.topics;
    }
}
