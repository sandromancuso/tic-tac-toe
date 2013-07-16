package org.craftedsw.tictactoe.model.game;

import org.craftedsw.tictactoe.model.board.Marks;
import org.craftedsw.tictactoe.model.strategy.*;

import java.util.Iterator;

import static org.craftedsw.tictactoe.model.board.BoardStructure.NO_CELL;

public class MachinePlayer implements Player {

    private PlayerMark playerMark;
    private GameStrategies gameStrategies;

    public MachinePlayer(PlayerMark playerMark, GameStrategies gameStrategies) {
        this.playerMark = playerMark;
        this.gameStrategies = gameStrategies;
    }

    @Override
    public void placeMarkOn(Marks marks) {
        int cell = NO_CELL;
        Iterator<Strategy> strategies = gameStrategies.iterator();
        while (strategies.hasNext()) {
            cell = strategies.next().nextCell(playerMark, marks);
            if (cell != NO_CELL) {
                break;
            }
        }
        marks.placeMarkAt(cell, playerMark.mark());
    }

    @Override
    public PlayerMark mark() {
        return playerMark;
    }

}
