package org.craftedsw.tictactoe.model.board;

import org.craftedsw.tictactoe.model.game.MachinePlayer;
import org.craftedsw.tictactoe.model.game.Player;
import org.craftedsw.tictactoe.view.BoardDisplay;

import static java.util.Arrays.copyOf;
import static org.craftedsw.tictactoe.model.board.BoardStructure.EMPTY_BOARD;

public class Game {

    private final BoardDisplay boardDisplay;
    private Marks marks = new Marks(copyOf(EMPTY_BOARD, EMPTY_BOARD.length));
    private BoardLines boardLines = new BoardLines();

    private Player humanPlayer;
    private MachinePlayer machinePlayer;

    public Game(BoardDisplay boardDisplay, MachinePlayer machinePlayer, Player humanPlayer) {
        this.boardDisplay = boardDisplay;
        this.machinePlayer = machinePlayer;
        this.humanPlayer = humanPlayer;
    }

    public void newGame() {
        placeMarkForMachinePlayer();
        boardDisplay.displayGameInstructions();
        boardDisplay.displayBoard(marks);
    }

    public void placeMarkAt(int cellToBeMarked) {
        marks.placeMarkAt(cellToBeMarked, humanPlayer.mark());
        if (!isOver()) {
            placeMarkForMachinePlayer();
        }
        boardDisplay.displayBoard(marks);
    }

    public boolean isOver() {
        return hasWinner() || isFull();
    }

    public void displayGameResult() {
        Player winner = boardLines.winner(marks);
        boardDisplay.displayGameResult(winner, humanPlayer);
    }

    private void placeMarkForMachinePlayer() {
        marks.placeMarkAt(machinePlayer.nextCell(marks), machinePlayer.mark());
    }

    private boolean hasWinner() {
        return boardLines.hasWinnerLine(marks);
    }

    private boolean isFull() {
        return marks.isFull();
    }

}
