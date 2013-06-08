package org.craftedsw.tictactoe.strategy;

import org.craftedsw.tictactoe.Board;
import org.craftedsw.tictactoe.Marks;
import org.craftedsw.tictactoe.Player;

import static org.craftedsw.tictactoe.Board.CELL_1;
import static org.craftedsw.tictactoe.Board.NO_CELL;

public class AttackStrategy implements Strategy {

    @Override
    public int nextCell(Player player, Marks marks) {
        int cell = NO_CELL;
        if (marks.isEmpty()) {
            cell = Board.CELL_1;
        } else if (marks.containsSingleMark() && marks.hasAnyCornerMarked()) {
            cell = marks.emptyOppositeCell(CELL_1);
        }
        System.out.println("Attack "+ player + " [" + cell + "]");
        return cell;
    }
}
