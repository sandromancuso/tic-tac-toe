package org.craftedsw.tictactoe.model.strategy;

import org.craftedsw.tictactoe.model.board.Line;
import org.craftedsw.tictactoe.model.board.Marks;
import org.craftedsw.tictactoe.model.game.PlayerMark;

import static org.craftedsw.tictactoe.model.board.BoardStructure.*;
import static org.craftedsw.tictactoe.model.game.PlayerMark.CROSS;
import static org.craftedsw.tictactoe.model.game.PlayerMark.NOUGHT;

public class BlockingForkStrategy implements Strategy {

    @Override
    public int nextCell(PlayerMark playerMark, Marks marks) {
        return (anyForkThreatFor(marks))
                        ? marks.firstEmptySideCell()
                        : NO_CELL;
    }

    private boolean anyForkThreatFor(Marks marks) {
        return forkThreatOn(DIAGONAL_1, marks) || forkThreatOn(DIAGONAL_2, marks);
    }

    private boolean forkThreatOn(Line diagonal, Marks marks) {
        return
               CROSS .mark().equals(marks.markAt(diagonal.firstCell))
            && NOUGHT.mark().equals(marks.markAt(diagonal.secondCell))
            && CROSS .mark().equals(marks.markAt(diagonal.thirdCell));
    }

}
