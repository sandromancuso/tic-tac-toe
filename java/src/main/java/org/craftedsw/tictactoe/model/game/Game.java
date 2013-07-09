package org.craftedsw.tictactoe.model.game;

import org.craftedsw.tictactoe.model.board.BoardLines;
import org.craftedsw.tictactoe.model.board.Marks;
import org.craftedsw.tictactoe.view.BoardDisplay;

import static java.util.Arrays.copyOf;
import static org.craftedsw.tictactoe.model.board.BoardStructure.EMPTY_BOARD;

public class Game {

    private final BoardDisplay boardDisplay;
    private Marks marks = initialiseMarks();

    private BoardLines boardLines = newBoardLines();

    private HumanPlayer humanPlayer;
    private MachinePlayer machinePlayer;

    public Game(BoardDisplay boardDisplay, MachinePlayer machinePlayer, HumanPlayer humanPlayer) {
        this.boardDisplay = boardDisplay;
        this.machinePlayer = machinePlayer;
        this.humanPlayer = humanPlayer;
    }

    public void newGame() {
        machinePlayer.placeMark(marks);
        boardDisplay.displayGameInstructions();
        boardDisplay.displayBoard(marks);
    }

    public void nextMove() {
        humanPlayer.placeMark(marks);
        if (!isOver()) {
            machinePlayer.placeMark(marks);
        }
        boardDisplay.displayBoard(marks);
    }

    public boolean isOver() {
        return hasWinner() || isFull();
    }

    public void displayGameResult() {
        PlayerMark winner = boardLines.winner(marks);
        boardDisplay.displayGameResult(winner);
    }

    private boolean hasWinner() {
        return boardLines.hasWinnerLine(marks);
    }

    private boolean isFull() {
        return marks.isFull();
    }

    protected Marks initialiseMarks() {
        return new Marks(copyOf(EMPTY_BOARD, EMPTY_BOARD.length));
    }

    protected BoardLines newBoardLines() {
        return new BoardLines();
    }

}
