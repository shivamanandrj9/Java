package snake.and.ladder.impl;

public class Ladder {
    private int top;
    private int bottom;

    public int getTop() {
        return top;
    }

    public void setTop(int top) {
        this.top = top;
    }

    public int getBottom() {
        return bottom;
    }

    public void setBottom(int bottom) {
        this.bottom = bottom;
    }

    public boolean isValid(){
        return top>bottom;
    }
}
