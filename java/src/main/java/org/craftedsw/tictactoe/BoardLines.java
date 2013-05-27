package org.craftedsw.tictactoe;

import java.util.ArrayList;
import java.util.List;

import static org.craftedsw.tictactoe.Board.*;

class BoardLines {

    private static final Line ROW_1 = new Line(CELL_1, CELL_2, CELL_3);
    private static final Line ROW_2 = new Line(CELL_4, CELL_5, CELL_6);
    private static final Line ROW_3 = new Line(CELL_7, CELL_8, CELL_9);

    private static final Line COLUM_1 = new Line(CELL_1, CELL_4, CELL_7);
    private static final Line COLUM_2 = new Line(CELL_2, CELL_5, CELL_8);
    private static final Line COLUM_3 = new Line(CELL_3, CELL_6, CELL_9);

    private static final Line DIAGONAL_1 = new Line(CELL_1, CELL_5, CELL_9);
    private static final Line DIAGONAL_2 = new Line(CELL_3, CELL_5, CELL_7);

    private List<Line> boardLines = new ArrayList<Line>();

    public BoardLines() {
        add(ROW_1, ROW_2, ROW_3, COLUM_1, COLUM_2, COLUM_3, DIAGONAL_1, DIAGONAL_2);
    }

    private void add(Line... lines) {
        for (Line line : lines) {
            boardLines.add(line);
        }
    }

    public boolean hasWinnerLine(String[] marks) {
        for (Line line : boardLines) {
            if (line.isWinner(marks)) {
                return true;
            }
        }
        return false;
    }

}
