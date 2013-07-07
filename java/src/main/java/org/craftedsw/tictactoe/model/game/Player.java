package org.craftedsw.tictactoe.model.game;

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

    public Player opponent() {
        return this.equals(PLAYER_ONE)
                        ? PLAYER_TWO
                        : PLAYER_ONE;
    }

    public static Player byMark(String mark) {
        for (Player player : Player.values()) {
            if (player.mark.equals(mark)) return player;
        }
        return null;
    }
}
