package pub.sub.daos;

import pub.sub.entities.MessageTopicMapping;

import java.util.ArrayList;
import java.util.List;

public class MessageTopicMappingDao {

    public MessageTopicMappingDao(){
        this.messageTopicMappings=new ArrayList<>();
    }

    List<MessageTopicMapping> messageTopicMappings;

    public void insert(MessageTopicMapping messageTopicMapping){
        messageTopicMappings.add(messageTopicMapping);
    }
}
