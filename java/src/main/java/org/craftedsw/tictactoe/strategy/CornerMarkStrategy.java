package org.craftedsw.tictactoe.strategy;

import org.craftedsw.tictactoe.Marks;
import org.craftedsw.tictactoe.Player;

public class CornerMarkStrategy implements Strategy {
    public CornerMarkStrategy(Player player) {
    }

    @Override
    public int nextCell(Player player, Marks marks) {
        return 0;
    }
}
