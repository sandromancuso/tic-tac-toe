package org.craftedsw.tictactoe.model.board;

import org.craftedsw.tictactoe.model.game.MachinePlayer;
import org.craftedsw.tictactoe.model.game.Player;
import org.craftedsw.tictactoe.view.Console;

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

    private Player humanPlayer;
    private MachinePlayer machinePlayer;

    public Board(Console console, MachinePlayer machinePlayer, Player humanPlayer) {
        this.console = console;
        this.machinePlayer = machinePlayer;
        this.humanPlayer = humanPlayer;
    }

    public void newGame() {
        placeMarkForMachinePlayer();
        console.print(CELL_INDEX_INSTRUCTIONS);
        console.print(CURRENT_BOARD_STATE_MESSAGE);
        console.print(representation(marks));
    }

    public void placeMarkAt(int cellToBeMarked) {
        marks.placeMarkAt(cellToBeMarked, humanPlayer.mark());
        if (!gameIsOver()) {
            placeMarkForMachinePlayer();
        }
        console.print(representation(marks));
    }

    private void placeMarkForMachinePlayer() {
        marks.placeMarkAt(machinePlayer.nextCell(marks), machinePlayer.mark());
    }

    public boolean gameIsOver() {
        return hasWinner() || isFull();
    }

    public Player winner() {
        return boardLines.winner(marks);
    }

    private boolean hasWinner() {
        return boardLines.hasWinnerLine(marks);
    }

    private boolean isFull() {
        return marks.isFull();
    }
}
