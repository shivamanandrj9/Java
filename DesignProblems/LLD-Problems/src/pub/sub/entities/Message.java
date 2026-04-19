package pub.sub.entities;

public class Message {


    int id;
    String payload;
    int publisherId;

    public String getPayload() {
        return payload;
    }

    public int getId() {
        return id;
    }

    public int getPublisherId() {
        return publisherId;
    }


    public void setId(int id) {
        this.id = id;
    }



    public Message(String payload, int publisherId) {
        this.payload = payload;
        this.publisherId = publisherId;
    }
}
