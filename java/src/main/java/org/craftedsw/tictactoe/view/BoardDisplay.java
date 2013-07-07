package org.craftedsw.tictactoe.view;

import org.craftedsw.tictactoe.model.board.Marks;
import org.craftedsw.tictactoe.model.game.Player;

import static java.lang.String.format;
import static org.craftedsw.tictactoe.model.game.Player.PLAYER_TWO;

public class BoardDisplay {

    public final static String DRAW_MESSAGE = "It was a draw!!!";
    public static final String YOU_WIN = "You win!!!";
    public static final String YOU_LOSE = "You LOSE!!!";

    public final static String CURRENT_BOARD_STATE_MESSAGE = "Current state of the game: ";

    public static final String CELL_INDEX_INSTRUCTIONS =
                    " 1 | 2 | 3 " + "\n" +
                    "---+---+---" + "\n" +
                    " 4 | 5 | 6 " + "\n" +
                    "---+---+---" + "\n" +
                    " 7 | 8 | 9 ";

    private static final String EMPTY_BOARD =
                    " %s | %s | %s " + "\n" +
                    "---+---+---"    + "\n" +
                    " %s | %s | %s " + "\n" +
                    "---+---+---"    + "\n" +
                    " %s | %s | %s ";

    public static final String ASK_FOR_NEXT_MARK = "Cell number for your next mark  >>> ";

    private final Console console;

    public BoardDisplay(Console console) {
        this.console = console;
    }

    public void displayBoard(Marks marks) {
        console.print(format(EMPTY_BOARD, marks.asArray()));
    }

    public void displayGameInstructions() {
        console.print(CELL_INDEX_INSTRUCTIONS);
        console.print(CURRENT_BOARD_STATE_MESSAGE);
    }

    public void displayGameResult(Player winner, Player humanPlayer) {
        if (winner == null) {
            console.print(DRAW_MESSAGE);
        } else {
            console.print(winner.equals(humanPlayer)
                        ? YOU_WIN
                        : YOU_LOSE);
        }
    }
}
