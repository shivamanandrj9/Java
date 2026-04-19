package pub.sub.models;

import java.util.*;

public class TopicContext {

    Map<Integer, Set<Integer>> inFlights;


    public Map<Integer, Set<Integer>> getInFlights() {
        return inFlights;
    }

    public TopicContext(){
        this.inFlights=new HashMap<>();
    }

    public void setInFlights(int messageId, Set<Integer> inProgress){
        inFlights.put(messageId, inProgress);
    }



}
