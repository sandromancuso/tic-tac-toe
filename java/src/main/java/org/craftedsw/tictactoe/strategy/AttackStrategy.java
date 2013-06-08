package org.craftedsw.tictactoe.strategy;

import org.craftedsw.tictactoe.Marks;
import org.craftedsw.tictactoe.Player;

import static org.craftedsw.tictactoe.Board.CELL_1;

public class AttackStrategy implements Strategy {

    @Override
    public int nextCell(Player player, Marks marks) {
        int cell = CELL_1;
        if (marks.containsSingleMark() && marks.hasAnyCornerMarked()) {
            cell = marks.emptyOppositeCell(CELL_1);
        }
        return cell;
    }
}
