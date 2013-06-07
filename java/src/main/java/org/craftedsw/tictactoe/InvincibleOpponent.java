package org.craftedsw.tictactoe;

import org.craftedsw.tictactoe.strategy.AttackStrategy;
import org.craftedsw.tictactoe.strategy.MarkStrategy;
import org.craftedsw.tictactoe.strategy.WinStrategy;

import java.util.Arrays;

import static org.craftedsw.tictactoe.Player.PLAYER_ONE;
import static org.craftedsw.tictactoe.Player.PLAYER_TWO;
import static org.craftedsw.tictactoe.strategy.MarkStrategy.NONE;

public class InvincibleOpponent implements Opponent {

    private final MarkStrategy markStrategy;
    private final AttackStrategy attackStrategy;
    private final Player player;
    private final WinStrategy winStrategy;

    public InvincibleOpponent(Player player,
                              WinStrategy winStrategy,
                              MarkStrategy markStrategy,
                              AttackStrategy attackStrategy) {
        this.winStrategy = winStrategy;
        this.markStrategy = markStrategy;
        this.attackStrategy = attackStrategy;
        this.player = player;
    }

    @Override
    public int nextCell(Board board) {
        int mark = winStrategy.nextCell(player, board.marks());
        if (mark == NONE) {
            mark = markStrategy.defenceMark(player.opponent(), board.marks().asArray());
            if (mark == NONE) {
                mark = attackStrategy.nextMark(player, board.marks());
                if (mark == NONE) {
                    mark = board.marks().firstEmptyCell();
                }
            }
        }
        return mark;
    }

}
