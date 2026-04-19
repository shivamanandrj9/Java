package pub.sub.daos;

import pub.sub.entities.Subscriber;
import pub.sub.entities.Topic;

import java.util.ArrayList;
import java.util.List;

public class SubscriberDao {
    List<Subscriber> subscribers;

    public SubscriberDao(){
        this.subscribers=new ArrayList<>();
    }

    public int insert(Subscriber subscriber){
        int maxId=0;
        for(int i=0;i<subscribers.size();i++){
            maxId=Math.max(maxId, subscribers.get(i).getId());
        }
        maxId++;
        subscriber.setId(maxId);
        subscribers.add(subscriber);
        return maxId;
    }
}
