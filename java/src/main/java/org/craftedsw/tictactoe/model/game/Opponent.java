package org.craftedsw.tictactoe.model.game;

import org.craftedsw.tictactoe.model.board.Marks;
import org.craftedsw.tictactoe.model.strategy.*;

import java.util.Iterator;

import static org.craftedsw.tictactoe.model.board.BoardStructure.NO_CELL;

public class Opponent {

    private Player player;
    private GameStrategies strategies;

    public Opponent(Player player, GameStrategies strategies) {
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
        return nextCell;
    }

}
