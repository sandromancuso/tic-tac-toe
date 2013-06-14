package org.craftedsw.tictactoe.model.strategy;

import org.craftedsw.tictactoe.model.board.Marks;
import org.craftedsw.tictactoe.model.game.Player;

public class FirstEmptyCellStrategy implements Strategy {

    @Override
    public int nextCell(Player player, Marks marks) {
        return marks.firstEmptyCell();
    }
}
