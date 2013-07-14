package org.craftedsw.tictactoe.model.game;

import org.craftedsw.tictactoe.model.board.Marks;

public interface Player {
    void placeMarkOn(Marks marks);

    PlayerMark mark();
}
