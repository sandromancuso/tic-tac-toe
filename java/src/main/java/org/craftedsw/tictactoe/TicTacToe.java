package org.craftedsw.tictactoe;

import org.craftedsw.tictactoe.model.game.Game;
import org.craftedsw.tictactoe.view.BoardDisplay;
import org.craftedsw.tictactoe.view.Console;
import org.craftedsw.tictactoe.view.PlayerChoice;
import org.craftedsw.tictactoe.view.PlayerChooser;

public class TicTacToe {

    public static void main(String[] args) {
        play(newGame());
    }

    private static void play(Game game) {
        game.startNewGame();
        game.displayGameResult();
    }

    private static Game newGame() {
        Console console = new Console();
        BoardDisplay boardDisplay = new BoardDisplay(console);
        PlayerChoice playerChoice = new PlayerChooser(console).choose();

        return new Game(boardDisplay,
                        playerChoice.crossPlayer(),
                        playerChoice.noughtPlayer());
    }

}
