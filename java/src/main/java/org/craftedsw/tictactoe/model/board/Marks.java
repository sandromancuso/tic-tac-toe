package org.craftedsw.tictactoe.model.board;

import org.craftedsw.tictactoe.model.game.PlayerMark;

import static java.util.Arrays.asList;
import static java.util.Arrays.copyOf;
import static org.craftedsw.tictactoe.model.board.BoardStructure.*;
import static org.craftedsw.tictactoe.model.game.PlayerMark.byMark;

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

    public void placeMarkAt(int cell, PlayerMark playerMark) {
        if (!isEmptyAt(cell)) {
            throw new RuntimeException("Cell already occupied [" + cell + "]");
        }

        this.marks[cell] = playerMark.mark();
    }

    public PlayerMark markAt(int cell) {
        return byMark(marks[cell]);
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
        return stringRepresentation().replace(" ", "").length();
    }

    private String stringRepresentation() {
        StringBuilder builder = new StringBuilder();
        for (String mark : marks) {
            builder.append(mark);
        }
        return builder.toString();
    }
}
