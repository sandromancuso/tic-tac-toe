package org.craftedsw.tictactoe.view;

import org.craftedsw.tictactoe.model.board.Marks;
import org.craftedsw.tictactoe.model.game.PlayerMark;

import static java.lang.String.format;

public class BoardDisplay {

    public final static String DRAW_MESSAGE = "It was a draw!!!";
    public final static String WIN_MESSAGE = "%s wins!!!";

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
    private static final String EMPTY_LINE = "";

    private final Console console;

    public BoardDisplay(Console console) {
        this.console = console;
    }

    public void displayBoardWith(Marks marks) {
        console.print(EMPTY_LINE);
        console.print(format(EMPTY_BOARD, marks.asArray()));
    }

    public void displayGameInstructions(Marks marks) {
        console.print(CELL_INDEX_INSTRUCTIONS);
        console.print(CURRENT_BOARD_STATE_MESSAGE);
        displayBoardWith(marks);
    }

    public void displayGameResult(PlayerMark winner) {
        if (winner == null) {
            console.print(DRAW_MESSAGE);
        } else {
            console.print(format(WIN_MESSAGE, winner.name()));
        }
    }
}
