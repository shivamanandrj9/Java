package snake.and.ladder.impl;

import java.util.Random;

public class Dice {

    private int count;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int roll(){
        Random random=new Random();
        int value=0;
        for(int i=0;i<count;i++){
            value+=((random.nextInt(6))+1);
        }
        return value;
    }


}
