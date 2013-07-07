package org.craftedsw.tictactoe.model.board;

import org.craftedsw.tictactoe.model.game.Player;
import org.craftedsw.tictactoe.view.BoardDisplay;
import org.craftedsw.tictactoe.view.Console;

import java.util.Arrays;

import static java.util.Arrays.copyOf;
import static org.craftedsw.tictactoe.model.board.BoardStructure.EMPTY_BOARD;
import static org.craftedsw.tictactoe.model.game.Player.PLAYER_ONE;
import static org.craftedsw.tictactoe.model.game.Player.PLAYER_TWO;
import static org.craftedsw.tictactoe.view.BoardDisplay.CELL_INDEX_INSTRUCTIONS;
import static org.craftedsw.tictactoe.view.BoardDisplay.CURRENT_BOARD_STATE_MESSAGE;
import static org.craftedsw.tictactoe.view.BoardDisplay.representation;

public class Board {

    private final Console console;
    private Marks marks = new Marks(copyOf(EMPTY_BOARD, EMPTY_BOARD.length));
    private BoardLines boardLines = new BoardLines();

    private Player currentPlayer = PLAYER_ONE;

    public Board(Console console) {
        this.console = console;
    }

    public void newGame() {
        console.print(CELL_INDEX_INSTRUCTIONS);
        console.print(CURRENT_BOARD_STATE_MESSAGE);
    }

    public void place(int cellToBeMarked) {
        marks.placeMarkAt(cellToBeMarked, currentPlayer.mark());
        console.print(representation(marks));
        if (!hasWinner()) {
            switchPlayers();
        }
    }

    public boolean hasWinner() {
        return boardLines.hasWinnerLine(marks);
    }

    public Player winner() {
        return currentPlayer;
    }

    public Marks marks() {
        return marks;
    }

    private void switchPlayers() {
        currentPlayer = (currentPlayer == PLAYER_ONE)
                                ? PLAYER_TWO
                                : PLAYER_ONE;
    }

    public boolean isFull() {
        return marks().isFull();
    }
}
