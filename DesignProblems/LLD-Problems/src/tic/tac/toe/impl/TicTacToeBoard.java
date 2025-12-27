package tic.tac.toe.impl;

public interface TicTacToeBoard {
    public boolean hasWon();
    public boolean isValid(int row, int col);

    public void markMove(int row, int col, Symbol symbol);
}
