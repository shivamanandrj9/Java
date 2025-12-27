package snake.and.ladder.impl;

import java.util.List;

public class Board {
    private int boardSize;

    public int getBoardSize() {
        return boardSize;
    }

    private List<Snake> snakes;
    private List<Ladder> ladders;

    public Board(int boardSize, List<Snake> snakes, List<Ladder> ladders){
        if(isValidBoard(boardSize, snakes, ladders)){
            this.boardSize=boardSize;
            this.snakes=snakes;
            this.ladders=ladders;
        }
        else {
            throw new RuntimeException("Not a valid board");
        }
    }

    private boolean isValidBoard(int boardSize, List<Snake> snakes, List<Ladder> ladders){
        for(Snake s: snakes){
            if(s.getHead()<1 || s.getHead()>boardSize || s.getTail()<1 || s.getTail()>boardSize){
                return false;
            }
        }

        for(Ladder l: ladders){
            if(l.getBottom()<1 || l.getTop()>boardSize || l.getBottom()>boardSize || l.getTop()<1){
                return false;
            }
        }
        return true;
    }

    int getUpdatedPosition(int currPos, int inc){
        int newPos=currPos+inc;
        if(newPos>boardSize){
            return -1;
        }
        else {
            for(Snake snake: snakes){
                if(snake.getHead()==newPos){
                    return snake.getTail();
                }
            }

            for(Ladder ladder: ladders){
                if(ladder.getBottom()==newPos){
                    return ladder.getTop();
                }
            }
            return newPos;
        }
    }


}
