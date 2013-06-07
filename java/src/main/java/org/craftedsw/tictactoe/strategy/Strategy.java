package org.craftedsw.tictactoe.strategy;

import org.craftedsw.tictactoe.Marks;
import org.craftedsw.tictactoe.Player;

public interface Strategy {

    int nextCell(Player player, Marks marks);

}
