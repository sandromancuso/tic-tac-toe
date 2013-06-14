package org.craftedsw.tictactoe.model.board;

import org.craftedsw.tictactoe.model.game.Player;

import java.util.ArrayList;
import java.util.List;

public class BoardLines {

    public static final Line ROW_1 = new Line(BoardStructure.CELL_1, BoardStructure.CELL_2, BoardStructure.CELL_3);
    public static final Line ROW_2 = new Line(BoardStructure.CELL_4, BoardStructure.CELL_5, BoardStructure.CELL_6);
    public static final Line ROW_3 = new Line(BoardStructure.CELL_7, BoardStructure.CELL_8, BoardStructure.CELL_9);

    public static final Line COLUMN_1 = new Line(BoardStructure.CELL_1, BoardStructure.CELL_4, BoardStructure.CELL_7);
    public static final Line COLUMN_2 = new Line(BoardStructure.CELL_2, BoardStructure.CELL_5, BoardStructure.CELL_8);
    public static final Line COLUMN_3 = new Line(BoardStructure.CELL_3, BoardStructure.CELL_6, BoardStructure.CELL_9);

    public static final Line DIAGONAL_1 = new Line(BoardStructure.CELL_1, BoardStructure.CELL_5, BoardStructure.CELL_9);
    public static final Line DIAGONAL_2 = new Line(BoardStructure.CELL_3, BoardStructure.CELL_5, BoardStructure.CELL_7);

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
            if (line.isWinningLine(player, marks)) {
                return line;
            }
        }
        return null;
    }


    public Line loosingLine(Player opponent, Marks marks) {
        for (Line line : boardLines) {
            if (line.isLoosingLine(opponent, marks)) {
                return line;
            }
        }
        return null;
    }
}
