package org.craftedsw.tictactoe.strategy;

import org.craftedsw.tictactoe.Board;
import org.craftedsw.tictactoe.Marks;
import org.craftedsw.tictactoe.Player;

import static org.craftedsw.tictactoe.Board.CELL_3;
import static org.craftedsw.tictactoe.Board.CELL_9;
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
        Integer[] cornerMarks = marks.cornerMarksFor(player);
        int cell;
        for (int corner : cornerMarks) {
            if ((cell = marks.emptyOppositeCell(corner)) != NO_CELL) {
                return cell;
            }
        }
        return NO_CELL;
    }
}
