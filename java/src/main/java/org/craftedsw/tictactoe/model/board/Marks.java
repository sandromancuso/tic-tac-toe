package org.craftedsw.tictactoe.model.board;

import static java.util.Arrays.asList;
import static java.util.Arrays.copyOf;
import static org.craftedsw.tictactoe.model.board.BoardStructure.*;

public class Marks {
    private final String[] marks;

    public Marks(String[] marksArray) {
        this.marks = marksArray;
    }

    public int firstEmptyCell() {
        return asList(marks).indexOf(EMPTY_CELL);
    }

    public boolean isFull() {
        return count() == ALL_CELLS.length;
    }

    public boolean isEmptyAt(int cell) {
        return EMPTY_CELL.equals(marks[cell]);
    }

    public void placeMarkAt(int cell, String mark) {
        if (!isEmptyAt(cell)) {
            throw new RuntimeException("Cell already occupied [" + cell + "]");
        }

        this.marks[cell] = mark;
    }

    public String markAt(int cell) {
        return marks[cell];
    }

    public String[] asArray() {
        return copyOf(marks, marks.length);
    }

    public int firstEmptySideCell() {
        for (int cell : SIDE_CELLS) {
            if (isEmptyAt(cell)) {
                return cell;
            }
        }
        return NO_CELL;
    }

    public int count() {
        return stringRepresentation().replace(" ", "").trim().length();
    }

    private String stringRepresentation() {
        StringBuilder builder = new StringBuilder();
        for (String mark : marks) {
            builder.append(mark);
        }
        return builder.toString();
    }
}
