package org.craftedsw.tictactoe;

import org.craftedsw.tictactoe.model.board.Board;
import org.craftedsw.tictactoe.model.game.MachinePlayer;
import org.craftedsw.tictactoe.model.game.Player;
import org.craftedsw.tictactoe.model.strategy.GameStrategies;
import org.craftedsw.tictactoe.view.Console;

import static org.craftedsw.tictactoe.model.game.Player.PLAYER_ONE;
import static org.craftedsw.tictactoe.model.game.Player.PLAYER_TWO;
import static org.craftedsw.tictactoe.view.BoardDisplay.ASK_FOR_NEXT_MARK;

public class TicTacToe {

    public final static String DRAW_MESSAGE = "It was a draw!!!";
    public static final String YOU_WIN = "You win!!!";
    public static final String YOU_LOSE = "You LOSE!!!";

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
        displayGameResult();
    }

    private void displayGameResult() {
        Player winner = board.winner();
        if (winner == null) {
            console.print(DRAW_MESSAGE);
        } else {
            console.print(winner == PLAYER_TWO
                            ? YOU_WIN
                            : YOU_LOSE);
        }
    }

    private int playerNextCell() {
        return console.ask(ASK_FOR_NEXT_MARK) - 1;
    }

    public static void main(String[] args) {
        Console console = new Console();
        MachinePlayer machinePlayer = new MachinePlayer(PLAYER_ONE, new GameStrategies());
        Player humanPlayer = PLAYER_TWO;
        TicTacToe ticTacToe = new TicTacToe(console, new Board(console, machinePlayer, humanPlayer));

        ticTacToe.newSinglePlayerGame();
    }

}
