package org.craftedsw.tictactoe.view;

import org.craftedsw.tictactoe.model.board.Marks;

import static java.lang.String.format;

public class BoardDisplay {

    public static final String CELL_INDEX_INSTRUCTIONS =
                    " 1 | 2 | 3 " + "\n" +
                    "---+---+---" + "\n" +
                    " 4 | 5 | 6 " + "\n" +
                    "---+---+---" + "\n" +
                    " 7 | 8 | 9 ";

    public static final String EMPTY_BOARD =
                    " %s | %s | %s " + "\n" +
                    "---+---+---"    + "\n" +
                    " %s | %s | %s " + "\n" +
                    "---+---+---"    + "\n" +
                    " %s | %s | %s ";

    public static String representation(Marks marks) {
        return format(EMPTY_BOARD, marks.asArray());
    }

}
