package snake.and.ladder.impl;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner =new Scanner(System.in);

        System.out.print("Enter board size: ");
        int boardSize=scanner.nextInt();

        System.out.print("Enter snake count: ");
        int countSnake= scanner.nextInt();
        List<Snake> snakes=new ArrayList<>(countSnake);
        Random random=new Random();
        while(snakes.size()<countSnake){
            Snake snake=new Snake();
            snake.setTail((random.nextInt(boardSize))+1);
            snake.setHead((random.nextInt(boardSize))+1);
            if(snake.isValid()){
                snakes.add(snake);
            }
        }
        for(Snake snake: snakes){
            System.out.println(snake.getTail() + "-" + snake.getHead());
        }

        System.out.print("Enter ladder count: ");
        int countLadder= scanner.nextInt();
        List<Ladder> ladders=new ArrayList<>(countLadder);
        while(ladders.size()<countLadder){
            Ladder ladder=new Ladder();
            ladder.setTop((random.nextInt(boardSize))+1);
            ladder.setBottom((random.nextInt(boardSize))+1);
            if(ladder.isValid()){
                ladders.add(ladder);
            }
        }

        for(Ladder ladder: ladders){
            System.out.println(ladder.getBottom() + "-" + ladder.getTop());
        }


        System.out.print("Enter player count: ");
        int countPlayers=scanner.nextInt();
        Queue<Player> players = new ArrayDeque<>(countPlayers);
        for(int i=0;i<countPlayers;i++){
            Player player=new Player();
            player.setId(Integer.toString(i));
            player.setPos(1);
            players.add(player);
        }


        Board board=new Board(boardSize,snakes,ladders);
        Dice dice = new Dice();
        dice.setCount(1);
        Game game= new Game(board, players, dice);
        game.startGame();

    }
}
