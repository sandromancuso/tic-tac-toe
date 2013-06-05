package org.craftedsw.tictactoe;

import org.craftedsw.tictactoe.strategy.MarkStrategy;

import java.util.Arrays;

import static org.craftedsw.tictactoe.Player.PLAYER_ONE;
import static org.craftedsw.tictactoe.Player.PLAYER_TWO;
import static org.craftedsw.tictactoe.strategy.MarkStrategy.NONE;

public class InvincibleOpponent implements Opponent {

    private final MarkStrategy markStrategy;
    private final Player player;

    public InvincibleOpponent(Player player, MarkStrategy markStrategy) {
        this.markStrategy = markStrategy;
        this.player = player;
    }

    @Override
    public int nextCell(Board board) {
        int mark = markStrategy.winMark(player, board.marks());
        if (mark == NONE) {
            mark = markStrategy.defenceMark(getOpponent(), board.marks());
            if (mark == NONE) {
                mark = firstEmptyCell(board);
            }
        }
        return mark;
    }

    private Player getOpponent() {
        return PLAYER_ONE.equals(player)
                        ? PLAYER_TWO
                        : PLAYER_ONE;
    }

    private int firstEmptyCell(Board board) {
        return Arrays.asList(board.marks()).indexOf(" ");
    }

}
