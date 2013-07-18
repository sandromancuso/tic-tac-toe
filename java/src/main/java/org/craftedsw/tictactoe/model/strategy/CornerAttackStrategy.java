package org.craftedsw.tictactoe.model.strategy;

import org.craftedsw.tictactoe.model.board.BoardLines;
import org.craftedsw.tictactoe.model.board.Line;
import org.craftedsw.tictactoe.model.board.Marks;
import org.craftedsw.tictactoe.model.game.PlayerMark;

import java.util.List;

import static org.craftedsw.tictactoe.model.board.BoardStructure.NO_CELL;

public class CornerAttackStrategy implements Strategy {

    @Override
    public int nextCell(PlayerMark playerMark, Marks marks) {
        List<Line> lines = linesWithJustOneCornerSelectedFor(playerMark, marks);
        if (!lines.isEmpty()) {
            return lines.get(0).emptyEdgeCell(marks);
        }
        return NO_CELL;
    }

    private List<Line> linesWithJustOneCornerSelectedFor(PlayerMark playerMark, Marks marks) {
        return new BoardLines().linesWhereJustOneCornerIsSelectedBy(playerMark, marks);
    }
}
