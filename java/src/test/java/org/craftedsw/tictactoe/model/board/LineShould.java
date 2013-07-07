package org.craftedsw.tictactoe.model.board;

import org.craftedsw.tictactoe.model.game.Player;
import org.junit.Test;

import static org.craftedsw.tictactoe.model.board.BoardStructure.*;
import static org.craftedsw.tictactoe.model.game.Player.PLAYER_ONE;
import static org.craftedsw.tictactoe.builder.MarksBuilder.marks;
import static org.craftedsw.tictactoe.model.game.Player.PLAYER_TWO;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class LineShould {

    @Test public void
    inform_when_a_line_is_not_a_winning_line() {
        Marks marks = marks()
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
    inform_when_a_line_is_not_a_loosing_line() {
        Marks marks = marks()
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
    inform_when_a_line_is_a_winning_line() {
        Marks marks = marks()
                            .fromPlayerOneAt(CELL_1, CELL_5, CELL_6, CELL_7)
                            .fromPlayerTwoAt(CELL_3, CELL_8, CELL_9)
                            .build();

        assertThat(DIAGONAL_1.isWinningLine(PLAYER_ONE, marks), is(false));
        assertThat(COLUMN_1.isWinningLine(PLAYER_ONE, marks), is(true));
        assertThat(ROW_2.isWinningLine(PLAYER_ONE, marks), is(true));
    }

    @Test public void
    inform_when_a_line_is_a_loosing_line() {
        Marks marks = marks()
                            .fromPlayerOneAt(CELL_1, CELL_5, CELL_6, CELL_7)
                            .fromPlayerTwoAt(CELL_3, CELL_8, CELL_9)
                            .build();

        Player opponent = PLAYER_ONE;

        assertThat(DIAGONAL_1.isLoosingLine(opponent, marks), is(false));
        assertThat(COLUMN_1.isLoosingLine(opponent, marks), is(true));
        assertThat(ROW_2.isLoosingLine(opponent, marks), is(true));
    }

    @Test public void
    inform_when_line_has_single_corner_marked() {
        Marks marks = marks()
                            .fromPlayerOneAt(CELL_1, CELL_3, CELL_4)
                            .build();

        assertThat(ROW_1.hasSingleCornerMarkForPlayer(PLAYER_ONE, marks), is(false));
        assertThat(COLUMN_1.hasSingleCornerMarkForPlayer(PLAYER_ONE, marks), is(false));
        assertThat(DIAGONAL_1.hasSingleCornerMarkForPlayer(PLAYER_ONE, marks), is(true));
        assertThat(DIAGONAL_2.hasSingleCornerMarkForPlayer(PLAYER_ONE, marks), is(true));
        assertThat(DIAGONAL_1.hasSingleCornerMarkForPlayer(PLAYER_TWO, marks), is(false));
        assertThat(COLUMN_3.hasSingleCornerMarkForPlayer(PLAYER_ONE, marks), is(true));
    }

    @Test public void
    inform_when_line_has_an_empty_edge_cell_either_first_or_third_cell() {
        Marks marks = marks()
                            .fromPlayerOneAt(CELL_1, CELL_6, CELL_7, CELL_9)
                            .build();

        assertThat(ROW_1.emptyEdgeCell(marks), is(CELL_3));
        assertThat(ROW_2.emptyEdgeCell(marks), is(CELL_4));
        assertThat(ROW_3.emptyEdgeCell(marks), is(NO_CELL));
        assertThat(DIAGONAL_1.emptyEdgeCell(marks), is(NO_CELL));
        assertThat(COLUMN_3.emptyEdgeCell(marks), is(CELL_3));
    }

}
