package org.craftedsw.tictactoe;

import org.craftedsw.tictactoe.strategy.MarkStrategy;

import java.util.Arrays;

import static org.craftedsw.tictactoe.strategy.MarkStrategy.NONE;

public class InvincibleOpponent implements Opponent {

    private final MarkStrategy markStrategy;

    public InvincibleOpponent(MarkStrategy markStrategy) {
        this.markStrategy = markStrategy;
    }

    @Override
    public int nextMark(Board board) {
        int mark = markStrategy.winMark(board.marks());
        if (mark == NONE) {
            mark = markStrategy.defenceMark(board.marks());
            if (mark == NONE) {
                mark = firstEmptyCell(board);
            }
        }
        return mark;
    }

    private int firstEmptyCell(Board board) {
        return Arrays.asList(board.marks()).indexOf(" ");
    }

}
