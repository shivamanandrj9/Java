package Threading.Problems.reader.writer.using.synchronizedd.read.priority;

public class Main {
    public static void main(String[] args) {
        //Reading

        ReadWriteSystem system=new ReadWriteSystem();

        for(int i=0;i<5;i++){
            new Thread(()->{
                try {
                    while(true){
                        system.readValue();
                        Thread.sleep(1000);
                    }

                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }).start();
        }

        for(int i=0;i<5;i++){
            new Thread(()->{
                try {
                    while(true){
                        system.writeValue();
                        Thread.sleep(1000);
                    }

                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }).start();
        }
    }
}
