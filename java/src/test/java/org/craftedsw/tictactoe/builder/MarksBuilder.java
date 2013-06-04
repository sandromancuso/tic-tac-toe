package org.craftedsw.tictactoe.builder;

import org.craftedsw.tictactoe.Player;

import static org.craftedsw.tictactoe.Player.PLAYER_ONE;
import static org.craftedsw.tictactoe.Player.PLAYER_TWO;

public class MarksBuilder {

    private int[] playerOneCells = new int[] {};
    private int[] playerTwoCells = new int[] {};

    public static MarksBuilder marks() {
        return new MarksBuilder();
    }

    public MarksBuilder fromPlayerOneAt(int... cells) {
        this.playerOneCells = cells;
        return this;
    }

    public MarksBuilder fromPlayerTwoAt(int... cells) {
        this.playerTwoCells = cells;
        return this;
    }

    public String[] build() {
        String[] marks = new String[] {" ", " ", " ", " ", " ", " ", " ", " ", " "};
        addPlayerOneMarks(marks);
        addPlayerTwoMarks(marks);
        return marks;
    }

    private void addPlayerOneMarks(String[] marks) {
        addMarks(playerOneCells, PLAYER_ONE.mark(), marks);
    }

    private void addPlayerTwoMarks(String[] marks) {
        addMarks(playerTwoCells, PLAYER_TWO.mark(), marks);
    }

    private void addMarks(int[] playerCells, String mark, String[] marks) {
        for (int cell : playerCells) {
            marks[cell] = mark;
        }
    }

}
