package org.craftedsw.tictactoe.model.strategy;

import org.craftedsw.tictactoe.model.board.Marks;
import org.craftedsw.tictactoe.model.game.PlayerMark;

import static org.craftedsw.tictactoe.model.board.BoardStructure.CELL_5;
import static org.craftedsw.tictactoe.model.board.BoardStructure.NO_CELL;

public class CentralCellStrategy implements Strategy {

    @Override
    public int nextCell(PlayerMark playerMark, Marks marks) {
        return marks.isEmptyAt(CELL_5)
                        ? CELL_5
                        : NO_CELL;
    }

}
