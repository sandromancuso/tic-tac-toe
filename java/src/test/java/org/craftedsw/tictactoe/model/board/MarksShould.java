package org.craftedsw.tictactoe.model.board;

import org.junit.Test;
import org.junit.experimental.theories.DataPoint;
import org.junit.experimental.theories.Theories;
import org.junit.runner.RunWith;

import static org.craftedsw.tictactoe.model.board.BoardStructure.*;
import static org.craftedsw.tictactoe.model.game.PlayerMark.CROSS;
import static org.craftedsw.tictactoe.builder.MarksBuilder.marks;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class MarksShould {

    @Test public void
    should_inform_when_it_is_not_full() {
        Marks marks = marks()
                        .fromPlayerOneAt(CELL_1)
                        .fromPlayerTwoAt(CELL_9).build();

        assertThat(marks.isFull(), is(false));
    }

    @Test public void
    should_inform_when_it_is_full() {
        Marks marks = marks()
                            .fromPlayerOneAt(CELL_1, CELL_2, CELL_3, CELL_4, CELL_5)
                            .fromPlayerTwoAt(CELL_6, CELL_7, CELL_8, CELL_9)
                            .build();

        assertThat(marks.isFull(), is(true));
    }

    @Test public void
    should_inform_which_is_the_first_empty_cell() {
        Marks marks = marks().fromPlayerOneAt(CELL_1, CELL_2, CELL_7, CELL_9).build();

        assertThat(marks.firstEmptyCell(), is(CELL_3));
    }

    @Test(expected = RuntimeException.class) public void
    should_throw_exception_when_mark_is_placed_on_a_marked_cell() {
        Marks marks = marks().fromPlayerOneAt(CELL_2).build();

        marks.placeMarkAt(CELL_2, CROSS.mark());
    }

    @Test public void
    should_return_a_mark_at_specified_position() {
        Marks marks = marks().fromPlayerOneAt(CELL_3).build();

        assertThat(marks.markAt(CELL_3), is(CROSS.mark()));
    }

    @Test public void
    return_the_first_empty_side_cell() {
        Marks marks = marks()
                        .fromPlayerOneAt(CELL_1, CELL_3)
                        .fromPlayerTwoAt(CELL_2, CELL_4)
                        .build();

        assertThat(marks.firstEmptySideCell(), is(CELL_6));
    }

}
