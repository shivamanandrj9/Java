package tic.tac.toe.impl;

import snake.and.ladder.impl.Board;

import java.util.List;
import java.util.Scanner;

public class Game {
    private TicTacToeBoard board;
    private List<Player> players;

    public Game(TicTacToeBoard board, List<Player> players){
        this.board=board;
        this.players=players;
    }

    public void play(){
        int turnIdx=-1;
        while(true){
            turnIdx++;
            turnIdx=turnIdx%(players.size());

            System.out.println("Hey "+ players.get(turnIdx).getName() + "Choose your grid position: ");
            Scanner scanner=new Scanner(System.in);
            System.out.print("Row: ");
            int row=scanner.nextInt();
            System.out.print("Column: ");
            int column=scanner.nextInt();


            while(!board.isValid(row, column)){
                System.out.println("INVALID POSITION CHOICE, PLEASE CHOOSE AGAIN");
                System.out.print("Row: ");
                row=scanner.nextInt();
                System.out.print("Column: ");
                column=scanner.nextInt();
            }

            board.markMove(row,column,players.get(turnIdx).getSymbol());
            if(board.hasWon()){
                System.out.println("You Won");
                break;
            }
        }
    }
}
