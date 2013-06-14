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
