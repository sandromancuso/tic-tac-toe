package org.craftedsw.tictactoe.strategy;

import org.craftedsw.tictactoe.BoardLines;

public class MarkStrategy {

    public static final int NONE = -1;
    private BoardLines boardLines = new BoardLines();

    public int winMark(String[] marks) {
        return NONE;
    }

    public int defenceMark(String[] marks) {
        return NONE;
    }

}
