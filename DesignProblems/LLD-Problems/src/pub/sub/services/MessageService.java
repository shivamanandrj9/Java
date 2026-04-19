package pub.sub.services;

import pub.sub.daos.MessageDao;
import pub.sub.daos.MessageTopicMappingDao;
import pub.sub.entities.Message;
import pub.sub.entities.MessageTopicMapping;
import pub.sub.manager.DispatchManager;

public class MessageService {

    MessageDao messageDao;
    MessageTopicMappingDao messageTopicMappingDao;
    DispatchManager dispatchManager;

    public MessageService(MessageDao messageDao, MessageTopicMappingDao messageTopicMappingDao, DispatchManager dispatchManager){
        this.messageDao=messageDao;
        this.messageTopicMappingDao=messageTopicMappingDao;
        this.dispatchManager=dispatchManager;
    }

    public int publishMessage(int topicId, String payload, int publisherId) throws InterruptedException {
        Message message= new Message(payload, publisherId);
        int messageId = messageDao.insert(message);

        MessageTopicMapping mapping = new MessageTopicMapping(messageId, topicId);
        messageTopicMappingDao.insert(mapping);

        dispatchManager.submitTask(topicId, messageId);

        return messageId;
    }
}
