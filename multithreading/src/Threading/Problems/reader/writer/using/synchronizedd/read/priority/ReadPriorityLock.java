package Threading.Problems.reader.writer.using.synchronizedd.read.priority;

public class ReadPriorityLock {

    private int readerCount;
    private boolean isWriting;

    public ReadPriorityLock() {
        this.readerCount = 0;
        this.isWriting = false;
    }

    public synchronized void lockRead() throws InterruptedException {
        while(isWriting) wait();
        readerCount++;
    }

    public synchronized void unlockRead() throws InterruptedException{
        readerCount--;
        if(readerCount==0){
            notifyAll();
        }
    }

    public synchronized void lockWrite() throws InterruptedException {
        while(readerCount != 0 || isWriting) wait();
        isWriting=true;
    }

    public synchronized void unlockWrite(){
        isWriting=false;
        notifyAll();
    }
}
