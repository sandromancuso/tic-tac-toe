package org.craftedsw.tictactoe.model.board;

import org.craftedsw.tictactoe.model.game.PlayerMark;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;
import static org.craftedsw.tictactoe.model.board.BoardStructure.ALL_CELLS;
import static org.craftedsw.tictactoe.model.board.BoardStructure.EMPTY_CELL;

public class Marks {
    private final String[] marks;

    public Marks(String[] marksArray) {
        this.marks = marksArray;
    }

    public int firstEmptyCell() {
        return asList(marks).indexOf(EMPTY_CELL);
    }

    public Integer[] cornerMarksFor(PlayerMark playerMark) {
        List<Integer> cornerMarks = new ArrayList<Integer>();
        for (int cornerCell : BoardStructure.CORNER_CELLS) {
            if (playerMark.mark().equals(marks[cornerCell])) {
                cornerMarks.add(cornerCell);
            }
        }
        return cornerMarks.toArray(new Integer[]{});
    }

    public boolean isFull() {
        return stringRepresentation().replace(" ", "").trim().length() == ALL_CELLS.length;
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

    public boolean containsMarkAt(int cell, String mark) {
        return marks[cell].equals(mark);
    }

    public String at(int cell) {
        return marks[cell];
    }

    public String[] asArray() {
        return marks;
    }

    private String stringRepresentation() {
        StringBuilder builder = new StringBuilder();
        for (String mark : marks) {
            builder.append(mark);
        }
        return builder.toString();
    }

}
