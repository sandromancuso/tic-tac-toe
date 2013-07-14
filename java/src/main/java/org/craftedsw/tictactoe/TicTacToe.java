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

    public static void main(String[] args) {
        start(newGame());
    }

    private static void start(Game game) {
        game.startNewGame();
        game.displayGameResult();
    }

    private static Game newGame() {
        Console console = new Console();
        BoardDisplay boardDisplay = new BoardDisplay(console);
        MachinePlayer machinePlayer = new MachinePlayer(CROSS, new GameStrategies());
        HumanPlayer humanPlayer = new HumanPlayer(NOUGHT, console);

        return new Game(boardDisplay, machinePlayer, humanPlayer);
    }

}
