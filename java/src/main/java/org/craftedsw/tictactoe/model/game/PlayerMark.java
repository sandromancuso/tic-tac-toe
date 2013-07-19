package org.craftedsw.tictactoe.model.game;

public enum PlayerMark {

    CROSS("X"),
    NOUGHT("0"),
    EMPTY_MARK(" ");

    private final String mark;

    private PlayerMark(String mark) {
        this.mark = mark;
    }

    public String mark() {
        return mark;
    }

    public PlayerMark opponent() {
        return this.equals(CROSS)
                        ? NOUGHT
                        : CROSS;
    }

    public static PlayerMark byMark(String mark) {
        for (PlayerMark playerMark : PlayerMark.values()) {
            if (playerMark.mark.equals(mark)) return playerMark;
        }
        return null;
    }
}
