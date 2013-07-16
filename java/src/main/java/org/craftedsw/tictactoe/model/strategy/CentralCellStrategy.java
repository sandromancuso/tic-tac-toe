package org.craftedsw.tictactoe.model.strategy;

import org.craftedsw.tictactoe.model.board.Marks;
import org.craftedsw.tictactoe.model.game.PlayerMark;

public class CentralCellStrategy implements Strategy {

    @Override
    public int nextCell(PlayerMark playerMark, Marks marks) {
        return 0;
    }

}
