package snake.and.ladder.impl;

import java.util.List;
import java.util.Queue;

public class Game {
    private Board board;
    private Queue<Player> players;
    private Dice dice;

    public Game(Board board, Queue<Player> players, Dice dice) {
        this.board = board;
        this.players = players;
        this.dice = dice;
    }

    public void startGame(){
        while(true){
            Player currentPlayer=players.peek();
            players.poll();
            System.out.println(currentPlayer.getId() + " is playing: ");


            int currPos= currentPlayer.getPos();
            System.out.println(currentPlayer.getId() + " is at pos: " + currPos);

            int num=dice.roll();
            System.out.println(currentPlayer.getId()+ " got "+ num);

            int newPos=board.getUpdatedPosition(currPos,num);
            if(newPos!=-1){
                System.out.println(currentPlayer.getId() + " updated Position: " + newPos);
                currentPlayer.setPos(newPos);
                if(newPos==board.getBoardSize()){
                    System.out.println(currentPlayer.getId() + " won");
                    return;
                }
            }
            else{
                System.out.println("Invalid dice outcome");
            }
            players.add(currentPlayer);
            System.out.println();
        }
    }
}
