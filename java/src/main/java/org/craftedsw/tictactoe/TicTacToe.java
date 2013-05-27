package org.craftedsw.tictactoe;

import static org.craftedsw.tictactoe.Board.ASK_FOR_NEXT_MARK;
import static org.craftedsw.tictactoe.BoardDisplay.CELL_INDEX_INSTRUCTIONS;

public class TicTacToe {

    public static final String WINNER_IS = "Winner is: ";
    public final static String CURRENT_BOARD_STATE_MSG = "Current state of the game: ";

    private final Console console;
    private final Board board;
    private boolean quit = false;

    public TicTacToe(Console console, Board board) {
        this.console = console;
        this.board = board;
    }

    public void newGame() {
        console.print(CELL_INDEX_INSTRUCTIONS);
        console.print(CURRENT_BOARD_STATE_MSG);
        console.print(board.representation());
        while (!board.hasWinner() && !quit) {
            int cellToBeMarked = console.ask(ASK_FOR_NEXT_MARK);
            board.placeMarkOn(cellToBeMarked - 1);
            console.print(board.representation());
        }
        console.print("Winner is: " + board.winner());
    }

    public String boardRepresentation() {
        return board.representation();
    }

    public void quit() {
        this.quit = true;
    }

    public static void main(String[] args) {
        TicTacToe ticTacToe = new TicTacToe(new Console(), new Board());

        ticTacToe.newGame();
    }


}
