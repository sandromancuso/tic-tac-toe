package org.craftedsw.tictactoe;

import org.craftedsw.tictactoe.strategy.*;

import java.util.Iterator;

import static org.craftedsw.tictactoe.Board.NO_CELL;

public class InvincibleOpponent implements Opponent {

    private Player player;
    private InvincibleStrategies strategies;

    public InvincibleOpponent(Player player, InvincibleStrategies strategies) {
        this.player = player;
        this.strategies = strategies;
    }

    @Override
    public int nextCell(Marks marks) {
        int nextCell;
        Iterator<Strategy> iterator = strategies.iterator();
        while (iterator.hasNext()) {
            nextCell = iterator.next().nextCell(player, marks);
            if (nextCell != NO_CELL) {
                return nextCell;
            }
        }
        return NO_CELL;
    }

}
