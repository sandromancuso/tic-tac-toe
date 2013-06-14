package org.craftedsw.tictactoe;

import java.util.ArrayList;
import java.util.List;

import static org.craftedsw.tictactoe.Board.*;

public class BoardLines {

    public static final Line ROW_1 = new Line(CELL_1, CELL_2, CELL_3);
    public static final Line ROW_2 = new Line(CELL_4, CELL_5, CELL_6);
    public static final Line ROW_3 = new Line(CELL_7, CELL_8, CELL_9);

    public static final Line COLUMN_1 = new Line(CELL_1, CELL_4, CELL_7);
    public static final Line COLUMN_2 = new Line(CELL_2, CELL_5, CELL_8);
    public static final Line COLUMN_3 = new Line(CELL_3, CELL_6, CELL_9);

    public static final Line DIAGONAL_1 = new Line(CELL_1, CELL_5, CELL_9);
    public static final Line DIAGONAL_2 = new Line(CELL_3, CELL_5, CELL_7);

    private List<Line> boardLines = new ArrayList<Line>();

    public BoardLines() {
        add(ROW_1, ROW_2, ROW_3, COLUMN_1, COLUMN_2, COLUMN_3, DIAGONAL_1, DIAGONAL_2);
    }

    private void add(Line... lines) {
        for (Line line : lines) {
            boardLines.add(line);
        }
    }

    public boolean hasWinnerLine(Marks marks) {
        for (Line line : boardLines) {
            if (line.isWinner(marks)) {
                return true;
            }
        }
        return false;
    }


    public Line winningLine(Player player, Marks marks) {
        for (Line line : boardLines) {
            if (line.isWinningLine(player, marks.asArray())) {
                return line;
            }
        }
        return null;
    }


    public Line loosingLine(Player opponent, Marks marks) {
        for (Line line : boardLines) {
            if (line.isLoosingLine(opponent, marks.asArray())) {
                return line;
            }
        }
        return null;
    }
}
