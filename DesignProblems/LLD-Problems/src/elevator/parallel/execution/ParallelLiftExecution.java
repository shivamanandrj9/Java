package elevator.parallel.execution;

import java.util.*;

public class ParallelLiftExecution {

    public static void main(String[] args) throws InterruptedException {
        Lift lift1=new Lift(Direction.UP, 0,false,0);
        Lift lift2=new Lift(Direction.DOWN, 0, false,1);

        List<Lift> lifts=new ArrayList<>();
        lifts.add(lift1);
        lifts.add(lift2);

        LiftManager liftManager=new LiftManager(lifts);
        liftManager.start();

        for(int i=0;i<15;i++){
            Thread.sleep(5000);
            liftManager.randomInterruption();
        }
    }
}

class LiftManager{
    public LiftManager(List<Lift> lifts) {
        this.lifts = lifts;
    }

    List<Lift> lifts;

    public void start() throws InterruptedException {
        for(Lift lift: lifts){
            Runnable runnable = ()->{
                try {
                    lift.run();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            };
            Thread thread = new Thread(runnable);
            thread.start();
        }

    }


    public void randomInterruption(){
        Random random=new Random();
        int liftId=random.nextInt(2);
        Lift currLift=lifts.get(liftId);
        currLift.setDir((currLift.getDir()==Direction.DOWN)? Direction.UP : Direction.DOWN);
        System.out.println("Direction of lift "+liftId+" changed to "+currLift.getDir());
    }
}

class Lift{
    public void setDir(Direction dir) {
        this.dir = dir;
    }

    public Direction getDir() {
        return dir;
    }

    private Direction dir;
    private int currFloor;
    private int liftId;

    public Lift(Direction dir, int currFloor, boolean stop, int liftId) {
        this.dir = dir;
        this.currFloor = currFloor;
        this.stop = stop;
        this.liftId=liftId;
    }

    private boolean stop=false;

    public void run() throws InterruptedException {
        while(!stop){
            if(dir==Direction.UP){
                currFloor++;
            }
            else{
                currFloor--;
            }
            System.out.println("Lift " + liftId + " is at floor "+ currFloor);
            Thread.sleep(2000);
        }
    }


}

enum Direction{
    UP, DOWN
}
