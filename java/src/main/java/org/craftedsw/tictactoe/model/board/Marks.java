package org.craftedsw.tictactoe.model.board;

import org.craftedsw.tictactoe.model.game.Player;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;

public class Marks {
    private final String[] marks;

    public Marks(String[] marksArray) {
        this.marks = marksArray;
    }

    public boolean isEmpty() {
        return stringRepresentation().trim().isEmpty();
    }

    public boolean containsSingleMark() {
        return stringRepresentation().trim().length() == 1;
    }

    public boolean hasAnyCornerMarked() {
        return atLeastOneIsMarked(BoardStructure.CELL_1, BoardStructure.CELL_3, BoardStructure.CELL_7, BoardStructure.CELL_9);
    }

    public int oppositeCornerOf(int cell) {
        for (int[] oppositeCells : BoardStructure.OPPOSITE_CORNER_CELLS) {
            if (cell == oppositeCells[0]) {
                return oppositeCells[1];
            }
        }
        return BoardStructure.NO_CELL;
    }

    public int emptyOppositeCell(int cell) {
        int oppositeCell = oppositeCornerOf(cell);
        return (isEmpty(oppositeCell))
                    ? oppositeCell
                    : BoardStructure.NO_CELL;
    }

    public int firstEmptyCell() {
        return asList(marks).indexOf(BoardStructure.EMPTY_CELL);
    }

    public Integer[] cornerMarksFor(Player player) {
        List<Integer> cornerMarks = new ArrayList<Integer>();
        for (int cornerCell : BoardStructure.CORNER_CELLS) {
            if (player.mark().equals(marks[cornerCell])) {
                cornerMarks.add(cornerCell);
            }
        }
        return cornerMarks.toArray(new Integer[] {});
    }

    public boolean isFull() {
        return stringRepresentation().replace(" ", "").trim().length() == BoardStructure.ALL_CELLS.length;
    }

    public boolean isEmpty(int cell) {
        return BoardStructure.EMPTY_CELL.equals(marks[cell]);
    }

    private String stringRepresentation() {
        StringBuilder builder = new StringBuilder();
        for (String mark : marks) {
            builder.append(mark);
        }
        return builder.toString();
    }

    private boolean atLeastOneIsMarked(int... cells) {
        for (int cell : cells) {
            if (!BoardStructure.EMPTY_CELL.equals(marks[cell])) {
                return true;
            }
        }
        return false;
    }

    public void placeMarkAt(int cell, String mark) {
        if (!isEmpty(cell)) {
            throw new RuntimeException("Cell already occupied [" + cell + "]");
        }

        this.marks[cell] = mark;
    }

    public boolean containsMarkAt(int cell, String mark) {
        return marks[cell].equals(mark);
    }

    public String at(int mark) {
        return marks[mark];
    }

    public String[] asArray() {
        return marks;
    }
}
