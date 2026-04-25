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

    public void setInFlights(int subscriberId, Set<Integer> inProgress){
        inFlights.put(subscriberId, inProgress);
    }

    public void addInFlight(int subscriberId, int messageId){
        inFlights.computeIfAbsent(subscriberId, k -> new TreeSet<>()).add(messageId);
    }

    public void removeInFlight(int subscriberId, int messageId){
        Set<Integer> inFlight=inFlights.get(subscriberId);
        if(inFlight!=null){
            inFlight.remove(messageId);
        }
    }

    public int getCheckpoint(int subscriberId, int messageId){
        Set<Integer> inFlight=inFlights.get(subscriberId);
        if(inFlight!=null && !inFlight.isEmpty()){
            return inFlight.stream().findFirst().get()-1;
        }
        else{
            return messageId;
        }
    }

}
