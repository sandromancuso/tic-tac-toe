package org.craftedsw.tictactoe.strategy;

import org.craftedsw.tictactoe.Marks;
import org.craftedsw.tictactoe.Player;

public class FirstEmptyCellStrategy implements Strategy {

    @Override
    public int nextCell(Player player, Marks marks) {
        return marks.firstEmptyCell();
    }
}
