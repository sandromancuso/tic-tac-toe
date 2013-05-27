package org.craftedsw.tictactoe;

public enum Player {

    PLAYER_ONE("X"),
    PLAYER_TWO("0");

    private final String mark;

    private Player(String mark) {
        this.mark = mark;
    }

    public String mark() {
        return mark;
    }
}
