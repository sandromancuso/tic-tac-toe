package org.craftedsw.tictactoe;

import org.craftedsw.tictactoe.model.board.Board;
import org.craftedsw.tictactoe.model.game.MachinePlayer;
import org.craftedsw.tictactoe.model.game.Player;
import org.craftedsw.tictactoe.model.strategy.GameStrategies;
import org.craftedsw.tictactoe.view.BoardDisplay;
import org.craftedsw.tictactoe.view.Console;

import static org.craftedsw.tictactoe.model.game.Player.PLAYER_ONE;
import static org.craftedsw.tictactoe.model.game.Player.PLAYER_TWO;
import static org.craftedsw.tictactoe.view.BoardDisplay.ASK_FOR_NEXT_MARK;

public class TicTacToe {

    private final Console console;
    private final Board board;

    public TicTacToe(Console console, Board board) {
        this.console = console;
        this.board = board;
    }

    public void newSinglePlayerGame() {
        board.newGame();
        while (!board.gameIsOver()) {
            board.placeMarkAt(playerNextCell());
        }
        board.displayGameResult();
    }

    private int playerNextCell() {
        return console.ask(ASK_FOR_NEXT_MARK) - 1;
    }

    public static void main(String[] args) {
        Console console = new Console();
        BoardDisplay boardDisplay = new BoardDisplay(console);
        MachinePlayer machinePlayer = new MachinePlayer(PLAYER_ONE, new GameStrategies());
        Player humanPlayer = PLAYER_TWO;
        Board board = new Board(boardDisplay, machinePlayer, humanPlayer);
        TicTacToe ticTacToe = new TicTacToe(console, board);

        ticTacToe.newSinglePlayerGame();
    }

}
