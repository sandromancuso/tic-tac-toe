package org.craftedsw.tictactoe.strategy;

import org.craftedsw.tictactoe.Marks;
import org.craftedsw.tictactoe.Player;

import static org.craftedsw.tictactoe.Board.NO_CELL;

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
