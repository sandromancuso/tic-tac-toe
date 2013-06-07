package org.craftedsw.tictactoe.strategy;

import org.craftedsw.tictactoe.Marks;
import org.craftedsw.tictactoe.Player;

public class DefenceStrategy implements Strategy {
    public DefenceStrategy(Player player) {
    }

    @Override
    public int nextCell(Player player, Marks marks) {
        return 0;
    }
}
