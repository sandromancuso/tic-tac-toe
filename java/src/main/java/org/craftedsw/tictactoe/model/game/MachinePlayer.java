package org.craftedsw.tictactoe.model.game;

import org.craftedsw.tictactoe.model.board.Marks;
import org.craftedsw.tictactoe.model.strategy.*;

import java.util.Iterator;

import static org.craftedsw.tictactoe.model.board.BoardStructure.NO_CELL;

public class MachinePlayer {

    private Player player;
    private GameStrategies strategies;

    public MachinePlayer(Player player, GameStrategies strategies) {
        this.player = player;
        this.strategies = strategies;
    }

    public void placeMark(Marks marks) {
        int cell = NO_CELL;
        Iterator<Strategy> iterator = strategies.iterator();
        while (iterator.hasNext()) {
            cell = iterator.next().nextCell(player, marks);
            if (cell != NO_CELL) {
                break;
            }
        }
        marks.placeMarkAt(cell, player.mark());
    }

    public String mark() {
        return player.mark();
    }

}
