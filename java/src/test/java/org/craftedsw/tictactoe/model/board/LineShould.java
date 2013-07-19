package org.craftedsw.tictactoe.model.board;

import org.junit.Test;

import static org.craftedsw.tictactoe.builder.MarksBuilder.marks;
import static org.craftedsw.tictactoe.model.board.BoardStructure.*;
import static org.craftedsw.tictactoe.model.game.PlayerMark.CROSS;
import static org.craftedsw.tictactoe.model.game.PlayerMark.NOUGHT;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class LineShould {

    @Test public void
    inform_when_a_line_is_not_a_winning_line() {
        Marks marks = marks()
                             .fromPlayerOneAt(CELL_1, CELL_2)
                             .fromPlayerTwoAt(CELL_3, CELL_4).build();

        assertThat(ROW_1   .isWinningLine(CROSS, marks), is(false));
        assertThat(ROW_2   .isWinningLine(CROSS, marks), is(false));
        assertThat(ROW_3   .isWinningLine(CROSS, marks), is(false));
        assertThat(COLUMN_1.isWinningLine(CROSS, marks), is(false));
        assertThat(COLUMN_2.isWinningLine(CROSS, marks), is(false));
    }

    @Test public void
    inform_when_a_line_is_a_winning_line() {
        Marks marks = marks()
                             .fromPlayerOneAt(CELL_1, CELL_5, CELL_6, CELL_7)
                             .fromPlayerTwoAt(CELL_3, CELL_8, CELL_9).build();

        assertThat(DIAGONAL_1.isWinningLine(CROSS, marks), is(false));
        assertThat(COLUMN_1  .isWinningLine(CROSS, marks), is(true));
        assertThat(ROW_2     .isWinningLine(CROSS, marks), is(true));
    }

    @Test public void
    inform_when_line_has_single_corner_marked() {
        Marks marks = marks()
                             .fromPlayerOneAt(CELL_1, CELL_3, CELL_4).build();

        assertThat(ROW_1     .hasSingleCornerMarkForPlayer(CROSS,  marks), is(false));
        assertThat(COLUMN_1  .hasSingleCornerMarkForPlayer(CROSS,  marks), is(false));
        assertThat(DIAGONAL_1.hasSingleCornerMarkForPlayer(CROSS,  marks), is(true));
        assertThat(DIAGONAL_2.hasSingleCornerMarkForPlayer(CROSS,  marks), is(true));
        assertThat(DIAGONAL_1.hasSingleCornerMarkForPlayer(NOUGHT, marks), is(false));
        assertThat(COLUMN_3  .hasSingleCornerMarkForPlayer(CROSS,  marks), is(true));
    }

    @Test public void
    inform_when_line_has_an_empty_edge_cell_either_first_or_third_cell() {
        Marks marks = marks()
                             .fromPlayerOneAt(CELL_1, CELL_6, CELL_7, CELL_9).build();

        assertThat(ROW_1     .emptyEdgeCell(marks), is(CELL_3));
        assertThat(ROW_2     .emptyEdgeCell(marks), is(CELL_4));
        assertThat(ROW_3     .emptyEdgeCell(marks), is(NO_CELL));
        assertThat(DIAGONAL_1.emptyEdgeCell(marks), is(NO_CELL));
        assertThat(COLUMN_3  .emptyEdgeCell(marks), is(CELL_3));
    }

    @Test public void
    inform_the_first_empty_cell() {
        Marks marks = marks()
                             .fromPlayerOneAt(CELL_1).build();

        assertThat(ROW_1.firstEmptyCell(marks), is(CELL_2));
    }

    @Test public void
    inform_when_there_is_no_empty_cell() {
        Marks marks = marks()
                             .fromPlayerOneAt(CELL_1, CELL_3)
                             .fromPlayerTwoAt(CELL_2).build();

        assertThat(ROW_1.firstEmptyCell(marks), is(NO_CELL));
    }

    @Test public void
    inform_when_line_does_not_have_a_single_matching_mark() {
        Marks marks = marks()
                             .fromPlayerOneAt(CELL_2, CELL_3)
                             .fromPlayerTwoAt(CELL_5).build();

        assertThat(ROW_1     .hasSingleMark(CROSS,  marks), is(false));
        assertThat(ROW_2     .hasSingleMark(CROSS,  marks), is(false));
        assertThat(COLUMN_2  .hasSingleMark(CROSS,  marks), is(false));
        assertThat(COLUMN_3  .hasSingleMark(NOUGHT, marks), is(false));
        assertThat(DIAGONAL_1.hasSingleMark(CROSS,  marks), is(false));
    }

    @Test public void
    inform_when_line_has_a_single_matching_mark() {
        Marks marks = marks()
                             .fromPlayerOneAt(CELL_2, CELL_3)
                             .fromPlayerTwoAt(CELL_5).build();

        assertThat(ROW_2     .hasSingleMark(NOUGHT, marks), is(true));
        assertThat(COLUMN_3  .hasSingleMark(CROSS,  marks), is(true));
        assertThat(DIAGONAL_1.hasSingleMark(NOUGHT, marks), is(true));
    }

    @Test public void
    inform_number_of_marks() {
        Marks marks = marks()
                             .fromPlayerOneAt(CELL_2, CELL_3)
                             .fromPlayerTwoAt(CELL_5).build();

        assertThat(ROW_1     .numberOfMarkedCells(marks), is(2));
        assertThat(COLUMN_3  .numberOfMarkedCells(marks), is(1));
        assertThat(DIAGONAL_2.numberOfMarkedCells(marks), is(2));
    }

}
