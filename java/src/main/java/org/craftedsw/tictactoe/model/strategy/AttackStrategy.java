package org.craftedsw.tictactoe.model.strategy;

import org.craftedsw.tictactoe.model.board.Board;
import org.craftedsw.tictactoe.model.board.Marks;
import org.craftedsw.tictactoe.model.game.Player;

import static org.craftedsw.tictactoe.model.board.Board.CELL_1;
import static org.craftedsw.tictactoe.model.board.Board.NO_CELL;

public class AttackStrategy implements Strategy {

    @Override
    public int nextCell(Player player, Marks marks) {
        int cell = NO_CELL;
        if (marks.isEmpty()) {
            cell = Board.CELL_1;
        } else if (marks.containsSingleMark() && marks.hasAnyCornerMarked()) {
            cell = marks.emptyOppositeCell(CELL_1);
        }
        return cell;
    }
}
