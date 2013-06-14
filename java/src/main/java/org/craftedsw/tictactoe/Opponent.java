package org.craftedsw.tictactoe;

import org.craftedsw.tictactoe.strategy.*;

import java.util.Iterator;

import static org.craftedsw.tictactoe.Board.NO_CELL;

public class Opponent {

    private Player player;
    private InvincibleStrategies strategies;

    public Opponent(Player player, InvincibleStrategies strategies) {
        this.player = player;
        this.strategies = strategies;
    }

    public int nextCell(Marks marks) {
        int nextCell = NO_CELL;
        Iterator<Strategy> iterator = strategies.iterator();
        while (iterator.hasNext()) {
            nextCell = iterator.next().nextCell(player, marks);
            if (nextCell != NO_CELL) {
                break;
            }
        }
        System.out.println("Attack "+ player + " [" + NO_CELL + "]");
        return nextCell;
    }

}
