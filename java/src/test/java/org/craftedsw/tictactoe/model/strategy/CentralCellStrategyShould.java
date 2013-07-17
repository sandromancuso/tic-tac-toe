package org.craftedsw.tictactoe.model.strategy;

import org.craftedsw.tictactoe.model.board.Marks;
import org.junit.Test;

import static org.craftedsw.tictactoe.builder.MarksBuilder.emptyMarks;
import static org.craftedsw.tictactoe.builder.MarksBuilder.marks;
import static org.craftedsw.tictactoe.model.board.BoardStructure.CELL_5;
import static org.craftedsw.tictactoe.model.board.BoardStructure.NO_CELL;
import static org.craftedsw.tictactoe.model.game.PlayerMark.NOUGHT;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class CentralCellStrategyShould {

    private CentralCellStrategy centralCellStrategy = new CentralCellStrategy();

    @Test public void
    return_cell_5_when_there_is_no_mark_there() {
        Marks marks = emptyMarks();

        assertThat(centralCellStrategy.nextCell(NOUGHT, marks), is(CELL_5));
    }

    @Test public void
    return_no_cell_when_cell_5_already_has_a_mark() {
        Marks marks = marks().fromPlayerOneAt(CELL_5).build();

        assertThat(centralCellStrategy.nextCell(NOUGHT, marks), is(NO_CELL));
    }

}
