Requirements:

2. Two players will be playing it
2. Players will be registered by the name.
2. 3x3 board will be there initially nothing will be there. Then player one will start the game with 'X' and then alternate turns will be there
3. After each turn the player made, we will have to check if they win.
4. [Missed] validation of the move


Entities: 

1. Player
    - Name

2. BasicBoard
    - grid<Symbol> 3x3
    - TicTacWinDetector
    - hasWon() {hasWon(board)}
    - isValidMove() { //we don't need to decouple it because the validation logic remains the same that already filled ones should not be chosen)

3. Symbol - Enum
    CROSS, CIRCLE

4. Game
    - List<Player>
    - Board 
    - play()

5. <<interface>> TicTacWinDetector<T> {hasWon()}
6. BasicWinDetector<Board> {hasWon(){...}}


Improvements after implementation and takeaways

So, first the hasWon is an overkill as we could have written the same logic via loop for different board size. Always think to do it if the implementation somehow changes class to class for an interface.

1. Hide the internal array. Instead of giving the whole array to the WinDetector, give it a method like getSymbolAt(row, col)

2. If I enter Row: 5 or Row: -1, the program will crash with an ArrayIndexOutOfBoundsException.

3. Add a isFull() or hasDraw() method to the TicTacToeBoard interface. The game loop should check for both a win and a draw.



