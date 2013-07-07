package org.craftedsw.tictactoe.model.strategy;

import org.craftedsw.tictactoe.model.board.BoardLines;
import org.craftedsw.tictactoe.model.board.Line;
import org.craftedsw.tictactoe.model.board.Marks;
import org.craftedsw.tictactoe.model.game.Player;

import java.util.List;

import static org.craftedsw.tictactoe.model.board.BoardStructure.NO_CELL;

public class AttackStrategy implements Strategy {

    @Override
    public int nextCell(Player player, Marks marks) {
        BoardLines boardLines = new BoardLines();
        List<Line> lines = boardLines.linesWhereJustOneCornerIsSelectedBy(player, marks);
        if (!lines.isEmpty()) {
            return lines.get(0).emptyEdgeCell(marks);
        }
        return NO_CELL;
    }
}
