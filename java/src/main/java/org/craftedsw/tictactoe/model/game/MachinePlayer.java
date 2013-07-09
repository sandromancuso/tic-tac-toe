package org.craftedsw.tictactoe.model.game;

import org.craftedsw.tictactoe.model.board.Marks;
import org.craftedsw.tictactoe.model.strategy.*;

import java.util.Iterator;

import static org.craftedsw.tictactoe.model.board.BoardStructure.NO_CELL;

public class MachinePlayer {

    private PlayerMark playerMark;
    private GameStrategies strategies;

    public MachinePlayer(PlayerMark playerMark, GameStrategies strategies) {
        this.playerMark = playerMark;
        this.strategies = strategies;
    }

    public void placeMark(Marks marks) {
        int cell = NO_CELL;
        Iterator<Strategy> iterator = strategies.iterator();
        while (iterator.hasNext()) {
            cell = iterator.next().nextCell(playerMark, marks);
            if (cell != NO_CELL) {
                break;
            }
        }
        marks.placeMarkAt(cell, playerMark.mark());
    }

    public String mark() {
        return playerMark.mark();
    }

}
