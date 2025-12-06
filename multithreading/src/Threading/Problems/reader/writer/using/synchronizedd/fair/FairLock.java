package Threading.Problems.reader.writer.using.synchronizedd.fair;

import java.util.ArrayDeque;
import java.util.Queue;

public class FairLock {

    private Queue<Request> q;
    private boolean isWriting;
    private int countReader;

    public FairLock() {
        this.q = new ArrayDeque<>();
        this.isWriting = false;
        this.countReader = 0;
    }

    public synchronized void lockRead() throws InterruptedException {
        Request request=new Request(true);
        q.add(request);

        while(!request.isGranted){
            if(q.peek()==request && !isWriting){
                while(!q.isEmpty() && q.peek().isReadRequest){
                    q.peek().setGranted();
                    countReader++;
                    q.poll();
                }
                notifyAll();
            }
            else
            {
                wait();
            }
        }
    }

    public synchronized void unlockRead(){
        countReader--;
        if(countReader==0){
            notifyAll();
        }
    }

    public synchronized void lockWrite() throws InterruptedException {
        Request request=new Request(false);
        q.add(request);
        while(!(q.peek()==request && !isWriting && countReader==0)){
            wait();
        }
        isWriting=true;
        q.poll();

    }

    public synchronized void unlockWrite(){
        isWriting=false;
        notifyAll();
    }

    class Request{
        boolean isGranted;
        boolean isReadRequest;

        public Request(boolean isReadRequest) {
            this.isReadRequest=isReadRequest;
            isGranted=false;
        }

        public void setGranted() {
            isGranted = true;
        }
    }
}
