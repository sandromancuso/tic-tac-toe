package org.craftedsw.tictactoe.model.strategy;

import org.craftedsw.tictactoe.model.board.BoardLines;
import org.craftedsw.tictactoe.model.board.Line;
import org.craftedsw.tictactoe.model.board.Marks;
import org.craftedsw.tictactoe.model.game.PlayerMark;

import java.util.List;

import static org.craftedsw.tictactoe.model.board.BoardStructure.NO_CELL;

public class SimpleAttackStrategy implements Strategy {

    @Override
    public int nextCell(PlayerMark playerMark, Marks marks) {
        List<Line> lines = linesWithSingleMarkFor(playerMark, marks);
        return (lines.size() > 0)
                    ? lines.get(0).emptyEdgeCell(marks)
                    : NO_CELL;
    }

    private List<Line> linesWithSingleMarkFor(PlayerMark playerMark, Marks marks) {
        return new BoardLines().withSingleMark(playerMark, marks);
    }

}
