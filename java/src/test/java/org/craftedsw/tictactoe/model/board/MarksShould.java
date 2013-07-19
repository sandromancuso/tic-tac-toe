package org.craftedsw.tictactoe.model.board;

import org.junit.Test;
import org.junit.experimental.theories.DataPoint;
import org.junit.experimental.theories.Theories;
import org.junit.runner.RunWith;

import static org.craftedsw.tictactoe.builder.MarksBuilder.emptyMarks;
import static org.craftedsw.tictactoe.model.board.BoardStructure.*;
import static org.craftedsw.tictactoe.model.game.PlayerMark.CROSS;
import static org.craftedsw.tictactoe.builder.MarksBuilder.marks;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class MarksShould {

    @Test public void
    inform_when_it_is_not_full() {
        Marks marks = marks()
                        .fromPlayerOneAt(CELL_1)
                        .fromPlayerTwoAt(CELL_9).build();

        assertThat(marks.isFull(), is(false));
    }

    @Test public void
    inform_when_it_is_full() {
        Marks marks = marks()
                            .fromPlayerOneAt(CELL_1, CELL_2, CELL_3, CELL_4, CELL_5)
                            .fromPlayerTwoAt(CELL_6, CELL_7, CELL_8, CELL_9)
                            .build();

        assertThat(marks.isFull(), is(true));
    }

    @Test public void
    inform_which_is_the_first_empty_cell() {
        Marks marks = marks().fromPlayerOneAt(CELL_1, CELL_2, CELL_7, CELL_9).build();

        assertThat(marks.firstEmptyCell(), is(CELL_3));
    }

    @Test(expected = RuntimeException.class) public void
    throw_exception_when_mark_is_placed_on_a_marked_cell() {
        Marks marks = marks().fromPlayerOneAt(CELL_2).build();

        marks.placeMarkAt(CELL_2, CROSS);
    }

    @Test public void
    should_place_a_mark_on_specified_cell() {
        Marks marks = emptyMarks();

        marks.placeMarkAt(CELL_3, CROSS);

        assertThat(marks.markAt(CELL_3), is(CROSS));
    }

    @Test public void
    return_a_mark_at_specified_position() {
        Marks marks = marks().fromPlayerOneAt(CELL_3).build();

        assertThat(marks.markAt(CELL_3), is(CROSS));
    }

    @Test public void
    return_the_first_empty_side_cell() {
        Marks marks = marks()
                        .fromPlayerOneAt(CELL_1, CELL_3)
                        .fromPlayerTwoAt(CELL_2, CELL_4)
                        .build();

        assertThat(marks.firstEmptySideCell(), is(CELL_6));
    }

    @Test public void
    not_return_any_empty_side_cells_when_they_all_have_marks() {
        Marks marks = marks()
                        .fromPlayerOneAt(CELL_2, CELL_6)
                        .fromPlayerTwoAt(CELL_4, CELL_8)
                        .build();

        assertThat(marks.firstEmptySideCell(), is(NO_CELL));
    }

    @Test public void
    inform_the_number_of_marks_placed() {
        Marks marks = marks()
                        .fromPlayerOneAt(CELL_2, CELL_6)
                        .fromPlayerTwoAt(CELL_5, CELL_7)
                        .build();

        assertThat(marks.count(), is(4));
    }
}
