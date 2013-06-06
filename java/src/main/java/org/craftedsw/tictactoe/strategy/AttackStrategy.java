package org.craftedsw.tictactoe.strategy;

import org.craftedsw.tictactoe.Marks;
import org.craftedsw.tictactoe.Player;

import static org.craftedsw.tictactoe.Board.CELL_1;

public class AttackStrategy {

    public int nextMark(Player playerOne, Marks marks) {
        int cell = CELL_1;
        if (marks.containsSingleMark() && marks.hasAnyCornerMarked()) {
            cell = CELL_1;
        }
        return cell;
    }

}
