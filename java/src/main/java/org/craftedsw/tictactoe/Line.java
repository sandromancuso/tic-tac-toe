package org.craftedsw.tictactoe;

import static org.craftedsw.tictactoe.Board.EMPTY_CELL;

public class Line {

    private static final int NONE = -1;
    private final int firstCell;
    private final int secondCell;
    private final int thirdCell;

    private int cells[] = new int[3];

    public Line(int firstCell, int secondCell, int thirdCell) {
        this.firstCell = firstCell;
        this.secondCell = secondCell;
        this.thirdCell = thirdCell;

        cells[0] = firstCell;
        cells[1] = secondCell;
        cells[2] = thirdCell;
    }

    public boolean isWinner(String[] marks) {
        return (marks[firstCell] != EMPTY_CELL)
             && marks[firstCell].equals(marks[secondCell])
             && marks[secondCell].equals(marks[thirdCell]);
    }

    public int firstEmptyCell(String[] marks) {
        for (int cell : cells) {
            if (marks[cell] == EMPTY_CELL) {
                return cell;
            }
        }
        return NONE;
    }

}
