package org.craftedsw.tictactoe.model.board;

import org.junit.Test;
import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

import static org.craftedsw.tictactoe.model.board.BoardStructure.*;
import static org.craftedsw.tictactoe.model.game.PlayerMark.CROSS;
import static org.craftedsw.tictactoe.model.game.PlayerMark.NOUGHT;
import static org.craftedsw.tictactoe.builder.MarksBuilder.marks;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

@RunWith(Theories.class)
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
                            .fromPlayerOneAt(CELL_1, BoardStructure.CELL_2, CELL_3, BoardStructure.CELL_4, BoardStructure.CELL_5)
                            .fromPlayerTwoAt(BoardStructure.CELL_6, CELL_7, BoardStructure.CELL_8, CELL_9)
                            .build();

        assertThat(marks.isFull(), is(true));
    }

    @Test public void
    should_inform_which_is_the_first_empty_cell() {
        Marks marks = marks().fromPlayerOneAt(CELL_1, BoardStructure.CELL_2, CELL_7, CELL_9).build();

        assertThat(marks.firstEmptyCell(), is(CELL_3));
    }

    @Test(expected = RuntimeException.class) public void
    should_throw_exception_when_mark_is_placed_on_a_marked_cell() {
        Marks marks = marks().fromPlayerOneAt(BoardStructure.CELL_2).build();

        marks.placeMarkAt(BoardStructure.CELL_2, CROSS.mark());
    }

    @Test public void
    should_return_a_mark_at_specified_position() {
        Marks marks = marks().fromPlayerOneAt(CELL_3).build();

        assertThat(marks.at(CELL_3), is(CROSS.mark()));
    }

}
