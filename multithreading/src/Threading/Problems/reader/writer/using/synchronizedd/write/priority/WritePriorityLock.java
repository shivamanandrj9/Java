package Threading.Problems.reader.writer.using.synchronizedd.write.priority;

public class WritePriorityLock {

    private int readerCount;
    private int writerWaiting;
    private boolean isWriting;

    public WritePriorityLock() {
        this.readerCount = 0;
        this.writerWaiting = 0;
        this.isWriting=false;
    }

    public synchronized void lockRead() throws InterruptedException {
        while(writerWaiting!=0 || isWriting) wait();
        readerCount++;
    }

    public synchronized void unlockRead() throws InterruptedException{
        readerCount--;
        if(readerCount==0){
            notifyAll();
        }
    }

    public synchronized void lockWrite() throws InterruptedException {
        writerWaiting++;
        while(readerCount != 0 || isWriting) wait();
        writerWaiting--;
        isWriting=true;
    }

    public synchronized void unlockWrite(){
        isWriting=false;
        notifyAll();
    }
}
