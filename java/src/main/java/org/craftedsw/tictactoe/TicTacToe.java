package org.craftedsw.tictactoe;

import org.craftedsw.tictactoe.strategy.InvincibleStrategies;

import static org.craftedsw.tictactoe.Board.ASK_FOR_NEXT_MARK;
import static org.craftedsw.tictactoe.BoardDisplay.CELL_INDEX_INSTRUCTIONS;
import static org.craftedsw.tictactoe.Player.PLAYER_ONE;
import static org.craftedsw.tictactoe.Player.PLAYER_TWO;

public class TicTacToe {

    public static final String WINNER_IS = "Winner is: ";
    public final static String CURRENT_BOARD_STATE_MESSAGE = "Current state of the game: ";
    public final static String DRAW_MESSAGE = "It was a draw!!!";
    public static final String YOU_WIN = "You win!!!";
    public static final String YOU_LOSE = "You LOSE!!!";

    private final Console console;
    private final Board board;
    private boolean quit = false;

    public TicTacToe(Console console, Board board) {
        this.console = console;
        this.board = board;
    }

    public void newGame() {
        console.print(CELL_INDEX_INSTRUCTIONS);
        console.print(CURRENT_BOARD_STATE_MESSAGE);
        console.print(board.representation());
        while (!board.hasWinner() && !quit) {
            int cellToBeMarked = console.ask(ASK_FOR_NEXT_MARK);
            board.place(cellToBeMarked - 1);
            console.print(board.representation());
        }
        console.print(WINNER_IS + board.winner());
    }

    public void newSinglePlayerGame(Opponent opponent) {
        console.print(CELL_INDEX_INSTRUCTIONS);
        console.print(CURRENT_BOARD_STATE_MESSAGE);
        board.place(opponent.nextCell(board.marks()));
        console.print(board.representation());
        while (!board.hasWinner() && !board.isFull()) {
            board.place(playerNextCell());
            if (!board.hasWinner()) {
                board.place(opponent.nextCell(board.marks()));
            }
            console.print(board.representation());
        }
        displayGameResult();
    }

    private void displayGameResult() {
        if (board.hasWinner()) {
            console.print(board.winner() == PLAYER_TWO
                                ? YOU_WIN
                                : YOU_LOSE);
        } else {
            console.print(DRAW_MESSAGE);
        }
    }

    private int playerNextCell() {
        return console.ask(ASK_FOR_NEXT_MARK) - 1;
    }

    public String boardRepresentation() {
        return board.representation();
    }

    public void quit() {
        this.quit = true;
    }

    public static void main(String[] args) {
        TicTacToe ticTacToe = new TicTacToe(new Console(), new Board());

        ticTacToe.newSinglePlayerGame(
                new Opponent(PLAYER_ONE,
                                        new InvincibleStrategies(PLAYER_ONE)));
//        ticTacToe.newGame();
    }

}
