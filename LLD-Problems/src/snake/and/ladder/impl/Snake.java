package snake.and.ladder.impl;

public class Snake {
    int head;
    int tail;

    public int getHead() {
        return head;
    }

    public void setHead(int head) {
        this.head = head;
    }

    public int getTail() {
        return tail;
    }

    public void setTail(int tail) {
        this.tail = tail;
    }

    public boolean isValid(){
        return head>tail;
    }
}
