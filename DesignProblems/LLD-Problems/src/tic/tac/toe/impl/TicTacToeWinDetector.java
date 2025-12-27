package tic.tac.toe.impl;

import snake.and.ladder.impl.Board;

public interface TicTacToeWinDetector<B> {
    boolean hasWon(B board);
}
