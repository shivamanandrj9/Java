package tic.tac.toe.impl;

public class BasicBoard implements TicTacToeBoard {

    public static final int BOARD_SIZE = 3;

    private Symbol[][] board;

    public Symbol[][] getBoard() {
        return board;
    }

    private TicTacToeWinDetector ticTacToeWinDetector;

    public BasicBoard(){
        this.ticTacToeWinDetector =new BasicWinDetector();
        board=new Symbol[BOARD_SIZE][BOARD_SIZE];
    }

    @Override
    public boolean hasWon(){
        return ticTacToeWinDetector.hasWon(this);
    }

    @Override
    public boolean isValid(int row, int col){
        if(board[row][col]!=null){
            return false;
        }
        return true;
    }

    @Override
    public void markMove(int row, int col, Symbol symbol){
        board[row][col]=symbol;
    }

}
