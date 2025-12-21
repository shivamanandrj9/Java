package tic.tac.toe.impl;

public class BasicWinDetector implements TicTacToeWinDetector<BasicBoard>{
    @Override
    public boolean hasWon(BasicBoard board) {
        return (checkHorizontal(board) | checkVertical(board) | checkDiagonal(board));
    }

    private boolean checkHorizontal(BasicBoard board){
        for(int i=0;i<board.BOARD_SIZE;i++){
            boolean flag=true;
            for(int j=1;j<board.BOARD_SIZE;j++){
                if(board.getBoard()[i][j-1] == null || board.getBoard()[i][j] == null || board.getBoard()[i][j-1]!=board.getBoard()[i][j]){
                    flag=false;
                    break;
                }
            }
            if(flag){
                return true;
            }
        }
        return false;
    }

    private boolean checkVertical(BasicBoard board){
        for(int i=0;i<board.BOARD_SIZE;i++){
            boolean flag=true;
            for(int j=1;j<board.BOARD_SIZE;j++){
                if(board.getBoard()[j-1][i] == null || board.getBoard()[j][i] == null || board.getBoard()[j-1][i]!=board.getBoard()[j][i]){
                    flag=false;
                    break;
                }
            }
            if(flag){
                return true;
            }
        }
        return false;
    }

    private boolean checkDiagonal(BasicBoard board){
        if(board.getBoard()[0][0]==board.getBoard()[1][1] && board.getBoard()[1][1] == board.getBoard()[2][2] && board.getBoard()[0][0]!=null && board.getBoard()[1][1]!=null && board.getBoard()[2][2]!=null){
            return true;
        }

        if(board.getBoard()[0][2]==board.getBoard()[1][1] && board.getBoard()[1][1] == board.getBoard()[2][0] && board.getBoard()[0][2]!=null && board.getBoard()[1][1] != null && board.getBoard()[0][2]!=null){
            return true;
        }

        return false;
    }
}
