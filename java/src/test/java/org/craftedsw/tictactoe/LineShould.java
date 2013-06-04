package org.craftedsw.tictactoe;

import org.craftedsw.tictactoe.builder.MarksBuilder;
import org.junit.Ignore;
import org.junit.Test;

import static org.craftedsw.tictactoe.Board.*;
import static org.craftedsw.tictactoe.BoardLines.*;
import static org.craftedsw.tictactoe.Player.PLAYER_ONE;
import static org.craftedsw.tictactoe.builder.MarksBuilder.marks;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class LineShould {

    @Test public void
    should_inform_when_a_line_is_not_a_winning_line() {
        String[] marks = marks()
                              .fromPlayerOneAt(CELL_1, CELL_2)
                              .fromPlayerTwoAt(CELL_3, CELL_4)
                              .build();

        assertThat(ROW_1.isWinningLine(marks), is(false));
        assertThat(ROW_2.isWinningLine(marks), is(false));
        assertThat(ROW_3.isWinningLine(marks), is(false));
        assertThat(COLUMN_1.isWinningLine(marks), is(false));
        assertThat(COLUMN_2.isWinningLine(marks), is(false));
    }

    @Test public void
    should_inform_when_a_line_is_a_winning_line() {
        String[] marks = marks()
                            .fromPlayerOneAt(CELL_1, CELL_5, CELL_7)
                            .fromPlayerTwoAt(CELL_3, CELL_9)
                            .build();

        assertThat(DIAGONAL_1.isWinningLine(marks), is(false));
        assertThat(COLUMN_1.isWinningLine(marks), is(true));
        assertThat(COLUMN_3.isWinningLine(marks), is(true));
    }

}
