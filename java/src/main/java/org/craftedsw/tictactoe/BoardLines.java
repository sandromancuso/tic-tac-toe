package org.craftedsw.tictactoe;

import java.util.ArrayList;
import java.util.List;

class BoardLines {

    private static final Line ROW_1 = new Line(Board.CELL_1, Board.CELL_2, Board.CELL_3);
    private static final Line ROW_2 = new Line(Board.CELL_4, Board.CELL_5, Board.CELL_6);
    private static final Line ROW_3 = new Line(Board.CELL_7, Board.CELL_8, Board.CELL_9);

    private static final Line COLUM_1 = new Line(Board.CELL_1, Board.CELL_4, Board.CELL_7);
    private static final Line COLUM_2 = new Line(Board.CELL_2, Board.CELL_5, Board.CELL_8);
    private static final Line COLUM_3 = new Line(Board.CELL_3, Board.CELL_6, Board.CELL_9);

    private List<Line> boardLines = new ArrayList<Line>();

    public BoardLines() {
        add(ROW_1, ROW_2, ROW_3, COLUM_1, COLUM_2, COLUM_3);
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
