package tic.tac.toe.impl;

import snake.and.ladder.impl.Board;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Player> playerList=new ArrayList<>();

        playerList.add(new Player("Shivam", Symbol.CIRCLE));
        playerList.add(new Player("Rahul", Symbol.CROSS));

        TicTacToeBoard board=new BasicBoard();

        Game game=new Game(board,playerList);
        game.play();
    }
}
