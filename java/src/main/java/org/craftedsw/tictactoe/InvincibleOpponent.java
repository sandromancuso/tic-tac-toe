package org.craftedsw.tictactoe;

import org.craftedsw.tictactoe.strategy.AttackStrategy;
import org.craftedsw.tictactoe.strategy.MarkStrategy;

import java.util.Arrays;

import static org.craftedsw.tictactoe.Player.PLAYER_ONE;
import static org.craftedsw.tictactoe.Player.PLAYER_TWO;
import static org.craftedsw.tictactoe.strategy.MarkStrategy.NONE;

public class InvincibleOpponent implements Opponent {

    private final MarkStrategy markStrategy;
    private final AttackStrategy attackStrategy;
    private final Player player;

    public InvincibleOpponent(Player player, MarkStrategy markStrategy,
                              AttackStrategy attackStrategy) {
        this.markStrategy = markStrategy;
        this.attackStrategy = attackStrategy;
        this.player = player;
    }

    @Override
    public int nextCell(Board board) {
        int mark = markStrategy.winMark(player, board.marks());
        if (mark == NONE) {
            mark = markStrategy.defenceMark(getOpponent(), board.marks());
            if (mark == NONE) {
                mark = attackStrategy.nextMark(player, new Marks(board.marks()));
                if (mark == NONE) {
                    mark = firstEmptyCell(board);
                }
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
