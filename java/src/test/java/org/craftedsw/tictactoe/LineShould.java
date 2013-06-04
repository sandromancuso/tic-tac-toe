package org.craftedsw.tictactoe;

import org.junit.Test;

import static org.craftedsw.tictactoe.Board.*;
import static org.craftedsw.tictactoe.BoardLines.*;
import static org.craftedsw.tictactoe.Player.PLAYER_ONE;
import static org.craftedsw.tictactoe.Player.PLAYER_TWO;
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

        assertThat(ROW_1.isWinningLine(PLAYER_ONE, marks), is(false));
        assertThat(ROW_2.isWinningLine(PLAYER_ONE, marks), is(false));
        assertThat(ROW_3.isWinningLine(PLAYER_ONE, marks), is(false));
        assertThat(COLUMN_1.isWinningLine(PLAYER_ONE, marks), is(false));
        assertThat(COLUMN_2.isWinningLine(PLAYER_ONE, marks), is(false));
    }

    @Test public void
    should_inform_when_a_line_is_not_a_loosing_line() {
        String[] marks = marks()
                              .fromPlayerOneAt(CELL_1, CELL_2)
                              .fromPlayerTwoAt(CELL_3, CELL_4)
                              .build();

        assertThat(ROW_1.isLoosingLine(PLAYER_ONE, marks), is(false));
        assertThat(ROW_2.isLoosingLine(PLAYER_ONE, marks), is(false));
        assertThat(ROW_3.isLoosingLine(PLAYER_ONE, marks), is(false));
        assertThat(COLUMN_1.isLoosingLine(PLAYER_ONE, marks), is(false));
        assertThat(COLUMN_2.isLoosingLine(PLAYER_ONE, marks), is(false));
    }

    @Test public void
    should_inform_when_a_line_is_a_winning_line() {
        String[] marks = marks()
                            .fromPlayerOneAt(CELL_1, CELL_5, CELL_6, CELL_7)
                            .fromPlayerTwoAt(CELL_3, CELL_8, CELL_9)
                            .build();

        assertThat(DIAGONAL_1.isWinningLine(PLAYER_ONE, marks), is(false));
        assertThat(COLUMN_1.isWinningLine(PLAYER_ONE, marks), is(true));
        assertThat(ROW_2.isWinningLine(PLAYER_ONE, marks), is(true));
    }

    @Test public void
    should_inform_when_a_line_is_a_loosing_line() {
        String[] marks = marks()
                            .fromPlayerOneAt(CELL_1, CELL_5, CELL_6, CELL_7)
                            .fromPlayerTwoAt(CELL_3, CELL_8, CELL_9)
                            .build();

        Player opponent = PLAYER_ONE;

        assertThat(DIAGONAL_1.isLoosingLine(opponent, marks), is(false));
        assertThat(COLUMN_1.isLoosingLine(opponent, marks), is(true));
        assertThat(ROW_2.isLoosingLine(opponent, marks), is(true));
    }

}
