package org.craftedsw.tictactoe;

import org.craftedsw.tictactoe.strategy.AttackStrategy;
import org.craftedsw.tictactoe.strategy.DefenceStrategy;
import org.craftedsw.tictactoe.strategy.WinStrategy;

import static org.craftedsw.tictactoe.Board.NO_CELL;

public class InvincibleOpponent implements Opponent {

    private final DefenceStrategy defenceStrategy;
    private final AttackStrategy attackStrategy;
    private final Player player;
    private final WinStrategy winStrategy;

    public InvincibleOpponent(Player player,
                              WinStrategy winStrategy,
                              DefenceStrategy defenceStrategy,
                              AttackStrategy attackStrategy) {
        this.winStrategy = winStrategy;
        this.defenceStrategy = defenceStrategy;
        this.attackStrategy = attackStrategy;
        this.player = player;
    }

    @Override
    public int nextCell(Board board) {
        int mark = winStrategy.nextCell(player, board.marks());
        if (mark == NO_CELL) {
            mark = defenceStrategy.nextCell(player, board.marks());
            if (mark == NO_CELL) {
                mark = attackStrategy.nextMark(player, board.marks());
                if (mark == NO_CELL) {
                    mark = board.marks().firstEmptyCell();
                }
            }
        }
        return mark;
    }

}
