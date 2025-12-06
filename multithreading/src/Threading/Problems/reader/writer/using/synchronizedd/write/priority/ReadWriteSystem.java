package Threading.Problems.reader.writer.using.synchronizedd.write.priority;

public class ReadWriteSystem {
    private int sharedResource;
    private WritePriorityLock lock;

    public ReadWriteSystem() {
        this.sharedResource = 0;
        this.lock = new WritePriorityLock();
    }

    public void readValue() throws InterruptedException {
        lock.lockRead();
        System.out.println("Read value: "+sharedResource);
        lock.unlockRead();
    }

    public void writeValue() throws InterruptedException{
        lock.lockWrite();
        sharedResource++;
        System.out.println("Incremented value to: "+sharedResource);
        lock.unlockWrite();
    }
}
