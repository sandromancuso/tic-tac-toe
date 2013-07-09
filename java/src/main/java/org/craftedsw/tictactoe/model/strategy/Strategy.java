package org.craftedsw.tictactoe.model.strategy;

import org.craftedsw.tictactoe.model.board.Marks;
import org.craftedsw.tictactoe.model.game.PlayerMark;

public interface Strategy {

    int nextCell(PlayerMark playerMark, Marks marks);

}
