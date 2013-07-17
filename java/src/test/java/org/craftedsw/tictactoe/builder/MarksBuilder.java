package org.craftedsw.tictactoe.builder;

import org.craftedsw.tictactoe.model.board.Marks;

import static org.craftedsw.tictactoe.model.game.PlayerMark.CROSS;
import static org.craftedsw.tictactoe.model.game.PlayerMark.NOUGHT;

public class MarksBuilder {

    private int[] playerOneCells = new int[] {};
    private int[] playerTwoCells = new int[] {};

    public static MarksBuilder marks() {
        return new MarksBuilder();
    }

    public static Marks emptyMarks() {
        return marks().build();
    }

    public MarksBuilder fromPlayerOneAt(int... cells) {
        this.playerOneCells = cells;
        return this;
    }

    public MarksBuilder fromPlayerTwoAt(int... cells) {
        this.playerTwoCells = cells;
        return this;
    }

    public String[] buildAsArray() {
        String[] marks = new String[] {" ", " ", " ", " ", " ", " ", " ", " ", " "};
        addPlayerOneMarks(marks);
        addPlayerTwoMarks(marks);
        return marks;
    }

    public Marks build() {
        return new Marks(buildAsArray());
    }

    private void addPlayerOneMarks(String[] marks) {
        addMarks(playerOneCells, CROSS.mark(), marks);
    }

    private void addPlayerTwoMarks(String[] marks) {
        addMarks(playerTwoCells, NOUGHT.mark(), marks);
    }

    private void addMarks(int[] playerCells, String mark, String[] marks) {
        for (int cell : playerCells) {
            marks[cell] = mark;
        }
    }

}
