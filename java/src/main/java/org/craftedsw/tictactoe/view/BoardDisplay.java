package org.craftedsw.tictactoe.view;

import org.craftedsw.tictactoe.model.board.Marks;
import org.craftedsw.tictactoe.model.game.PlayerMark;

import static java.lang.String.format;

public class BoardDisplay {

    private static final String NEW_GAME_MESSAGE = "Please select cells according to the following numbers:";
    private static final String NEW_LINE = "";
    public  static final String NEXT_PLAYER_IS = "Next player is ";


    public final static String DRAW_MESSAGE = "It was a draw!!!";
    public final static String WIN_MESSAGE = "%s wins!!!";

    public static final String CELL_INDEX_INSTRUCTIONS =
                    " 1 | 2 | 3 " + "\n" +
                    "---+---+---" + "\n" +
                    " 4 | 5 | 6 " + "\n" +
                    "---+---+---" + "\n" +
                    " 7 | 8 | 9 ";

    public final static String CURRENT_BOARD_STATE_MESSAGE = "Current state of the game: ";

    private static final String EMPTY_BOARD =
                    " %s | %s | %s " + "\n" +
                    "---+---+---"    + "\n" +
                    " %s | %s | %s " + "\n" +
                    "---+---+---"    + "\n" +
                    " %s | %s | %s ";

    private static final String EMPTY_LINE = "";

    private final Console console;

    public BoardDisplay(Console console) {
        this.console = console;
    }

    public void displayBoardWith(Marks marks) {
        console.printLines(
                            EMPTY_LINE,
                            format(EMPTY_BOARD, (Object[]) marks.asArray()));
    }

    public void displayGameInstructions(Marks marks) {
        console.printLines(
                            NEW_LINE,
                            NEW_GAME_MESSAGE,
                            NEW_LINE,
                            CELL_INDEX_INSTRUCTIONS,
                            NEW_LINE,
                            CURRENT_BOARD_STATE_MESSAGE);
        displayBoardWith(marks);
    }

    public void displayGameResult(PlayerMark winner) {
        String gameResult = (winner == null)
                                    ? DRAW_MESSAGE
                                    : format(WIN_MESSAGE, winner.name());
        console.printLines(
                            gameResult,
                            NEW_LINE);
    }

    public void nextPlayerIs(PlayerMark playerMark) {
        console.printLines(
                            NEW_LINE,
                            NEXT_PLAYER_IS + playerMark);
    }
}
