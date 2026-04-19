package pub.sub.entities;

import java.time.LocalDateTime;

public class MessageTopicMapping {

    public MessageTopicMapping(int messageId, int topicId) {
        this.messageId = messageId;
        this.topicId = topicId;
        this.createdAt=String.valueOf(System.currentTimeMillis());


    }

    int messageId;
    int topicId;
    String createdAt;
}
