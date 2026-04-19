package pub.sub.entities;

public class TopicSubscriberMapping {
    public int getTopicId() {
        return topicId;
    }

    public int getSubscriberId() {
        return subscriberId;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public int getOffset() {
        return offset;
    }

    int topicId;

    public TopicSubscriberMapping(int topicId, int subscriberId, boolean isDeleted, int offset) {
        this.topicId = topicId;
        this.subscriberId = subscriberId;
        this.isDeleted = isDeleted;
        this.offset = offset;
    }

    int subscriberId;
    boolean isDeleted;
    int offset;
}
