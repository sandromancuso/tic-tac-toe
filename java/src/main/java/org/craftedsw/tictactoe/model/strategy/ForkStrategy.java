package org.craftedsw.tictactoe.model.strategy;

import org.craftedsw.tictactoe.model.board.Line;
import org.craftedsw.tictactoe.model.board.Marks;
import org.craftedsw.tictactoe.model.game.PlayerMark;

import static org.craftedsw.tictactoe.model.board.BoardStructure.DIAGONALS;
import static org.craftedsw.tictactoe.model.board.BoardStructure.NO_CELL;

public class ForkStrategy implements Strategy {

    @Override
    public int nextCell(PlayerMark playerMark, Marks marks) {
        if (marks.count() == 2) {
            for (Line diagonal : DIAGONALS) {
                if (isCandidateForAFork(marks, diagonal)) {
                    return diagonal.emptyEdgeCell(marks);
                }
            }
        }
        return NO_CELL;
    }

    private boolean isCandidateForAFork(Marks marks, Line diagonal) {
        return diagonal.numberOfMarkedCells(marks) == 2 && diagonal.emptyEdgeCell(marks) != NO_CELL;
    }

}
