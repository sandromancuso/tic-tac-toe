package org.craftedsw.tictactoe.model.strategy;

import org.craftedsw.tictactoe.model.board.Marks;
import org.craftedsw.tictactoe.model.game.Player;

import static org.craftedsw.tictactoe.model.board.Board.NO_CELL;

public class CornerMarkStrategy implements Strategy {

    @Override
    public int nextCell(Player player, Marks marks) {
        int cornerMark;
        if ((cornerMark = cornerCellFor(player, marks)) == NO_CELL) {
            cornerMark = cornerCellFor(player.opponent(), marks);
        }
        return cornerMark;
    }

    private int cornerCellFor(Player player, Marks marks) {
        int cell;
        for (int corner : marks.cornerMarksFor(player)) {
            if ((cell = marks.emptyOppositeCell(corner)) != NO_CELL) {
                return cell;
            }
        }
        return NO_CELL;
    }
}
