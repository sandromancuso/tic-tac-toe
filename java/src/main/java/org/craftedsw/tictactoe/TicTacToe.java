package org.craftedsw.tictactoe;

import org.craftedsw.tictactoe.model.game.Game;
import org.craftedsw.tictactoe.model.game.HumanPlayer;
import org.craftedsw.tictactoe.model.game.MachinePlayer;
import org.craftedsw.tictactoe.model.strategy.GameStrategies;
import org.craftedsw.tictactoe.view.BoardDisplay;
import org.craftedsw.tictactoe.view.Console;

import static org.craftedsw.tictactoe.model.game.PlayerMark.CROSS;
import static org.craftedsw.tictactoe.model.game.PlayerMark.NOUGHT;

public class TicTacToe {

    private final Console console;
    private final Game game;

    public TicTacToe(Console console, Game game) {
        this.console = console;
        this.game = game;
    }

    public void newSinglePlayerGame() {
        game.newGame();
        while (!game.isOver()) {
            game.nextMove();
        }
        game.displayGameResult();
    }

    public static void main(String[] args) {
        Console console = new Console();
        BoardDisplay boardDisplay = new BoardDisplay(console);
        MachinePlayer machinePlayer = new MachinePlayer(CROSS, new GameStrategies());
        HumanPlayer humanPlayer = new HumanPlayer(console, NOUGHT);
        Game game = new Game(boardDisplay, machinePlayer, humanPlayer);

        TicTacToe ticTacToe = new TicTacToe(console, game);
        ticTacToe.newSinglePlayerGame();
    }

}
