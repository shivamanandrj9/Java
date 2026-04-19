package pub.sub.daos;

import pub.sub.entities.Message;

import java.util.ArrayList;
import java.util.List;

public class MessageDao {

    List<Message> messages;

    public MessageDao(){
        this.messages=new ArrayList<>();
    }

    public int insert(Message message){
        int maxId=0;
        for(int i=0;i<messages.size();i++){
            maxId=Math.max(maxId, messages.get(i).getId());
        }
        maxId++;
        message.setId(maxId);
        messages.add(message);
        return maxId;
    }
}
