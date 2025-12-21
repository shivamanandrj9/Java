package Threading.Problems.diners.philosopher;

import java.util.ArrayList;
import java.util.List;

public class LockSystem {
    private int participant;
    private List<Boolean> isTaken;

    public LockSystem(int count){
        this.participant=count;
        isTaken=new ArrayList<>();
        for(int i=0;i<count;i++){
            isTaken.add(false);
        }
    }

    public synchronized void getLock(int ind) throws InterruptedException {
        int leftReqLock=ind-1;
        int rightReqLock=ind;
        if(ind-1==-1){
            leftReqLock=participant-1;
        }
        while(!(isTaken.get(leftReqLock)==false && isTaken.get(rightReqLock)==false)){
            wait();
        }
        isTaken.set(leftReqLock,true);
        isTaken.set(rightReqLock,true);
    }

    public synchronized void relaseLock(int ind){
        int leftReqLock=ind-1;
        int rightReqLock=ind;
        if(ind-1==-1){
            leftReqLock=participant-1;
        }
        isTaken.set(leftReqLock,false);
        isTaken.set(rightReqLock,false);
        notifyAll();
    }
}
