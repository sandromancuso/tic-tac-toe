package org.craftedsw.tictactoe.model.board;

public interface BoardStructure {

    int CELL_1 = 0;
    int CELL_2 = 1;
    int CELL_3 = 2;
    int CELL_4 = 3;
    int CELL_5 = 4;
    int CELL_6 = 5;
    int CELL_7 = 6;
    int CELL_8 = 7;
    int CELL_9 = 8;

    Line ROW_1 = new Line(CELL_1, CELL_2, CELL_3);
    Line ROW_2 = new Line(CELL_4, CELL_5, CELL_6);
    Line ROW_3 = new Line(CELL_7, CELL_8, CELL_9);

    Line COLUMN_1 = new Line(CELL_1, CELL_4, CELL_7);
    Line COLUMN_2 = new Line(CELL_2, CELL_5, CELL_8);
    Line COLUMN_3 = new Line(CELL_3, CELL_6, CELL_9);

    Line DIAGONAL_1 = new Line(CELL_1, CELL_5, CELL_9);
    Line DIAGONAL_2 = new Line(CELL_3, CELL_5, CELL_7);

    int[][] OPPOSITE_CORNER_CELLS = new int[][] {
            {CELL_1, CELL_9},
            {CELL_9, CELL_1},
            {CELL_3, CELL_7},
            {CELL_7, CELL_3},
    };

    int[] CORNER_CELLS = new int[] {CELL_1, CELL_3, CELL_7, CELL_9};

    int[] ALL_CELLS = new int[] {
            CELL_1, CELL_2, CELL_3,
            CELL_4, CELL_5, CELL_6,
            CELL_7, CELL_8, CELL_9
    };

    int NO_CELL = -1;

    String EMPTY_CELL = " ";
}
