package org.craftedsw.tictactoe.model.board;

import org.craftedsw.tictactoe.model.game.PlayerMark;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.craftedsw.tictactoe.builder.MarksBuilder.marks;
import static org.craftedsw.tictactoe.model.board.BoardStructure.*;
import static org.craftedsw.tictactoe.model.game.PlayerMark.CROSS;
import static org.craftedsw.tictactoe.model.game.PlayerMark.NOUGHT;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class BoardLinesShould {

    private BoardLines boardLines;

    @Before
    public void initialise() {
        boardLines = new BoardLines();
    }

    @Test public void
    return_null_when_there_is_no_winning_line() {
        Marks marks = marks()
                           .fromPlayerOneAt(CELL_1, CELL_5)
                           .fromPlayerTwoAt(CELL_4, CELL_9)
                           .build();

        assertThat(boardLines.winningLine(CROSS, marks),  is(nullValue()));
    }

    @Test public void
    return_a_winning_line() {
        Marks marks = marks()
                            .fromPlayerOneAt(CELL_4, CELL_6)
                            .fromPlayerTwoAt(CELL_1, CELL_7)
                            .build();

        Line winningLine = boardLines.winningLine(CROSS, marks);

        assertThat(winningLine, is(ROW_2));
    }

    @Test public void
    return_null_when_there_is_no_loosing_line() {
        Marks marks = marks()
                            .fromPlayerOneAt(CELL_4)
                            .fromPlayerTwoAt(CELL_1)
                            .build();
        PlayerMark player = NOUGHT;

        Line winningLine = boardLines.loosingLine(player, marks);

        assertThat(winningLine, is(nullValue()));
    }

    @Test public void
    return_a_loosing_line() {
        Marks marks = marks()
                            .fromPlayerOneAt(CELL_4, CELL_6)
                            .fromPlayerTwoAt(CELL_1, CELL_7)
                            .build();
        PlayerMark player = NOUGHT;

        Line winningLine = boardLines.loosingLine(player, marks);

        assertThat(winningLine, is(ROW_2));
    }

    @Test public void
    return_lines_where_just_one_corner_is_selected() {
        Marks marks = marks()
                            .fromPlayerOneAt(CELL_3, CELL_6)
                            .build();

        List<Line> lines = boardLines.linesWhereJustOneCornerIsSelectedBy(CROSS, marks);

        assertThat(lines.size(), is(2));
        assertThat(lines.contains(ROW_1), is(true));
        assertThat(lines.contains(DIAGONAL_2), is(true));
    }

    @Test public void
    inform_there_are_no_winners_when_no_player_marked_a_full_line() {
        Marks marks = marks()
                            .fromPlayerOneAt(CELL_1, CELL_5)
                            .fromPlayerTwoAt(CELL_2, CELL_3)
                            .build();

        assertThat(boardLines.winnerMark(marks), is(nullValue()));
    }

    @Test public void
    inform_player_one_is_the_winner_when_she_has_a_full_line_marked() {
        Marks marks = marks()
                            .fromPlayerOneAt(CELL_1, CELL_5, CELL_9)
                            .fromPlayerTwoAt(CELL_2, CELL_3)
                            .build();

        assertThat(boardLines.winnerMark(marks), is(CROSS));
    }

    @Test public void
    inform_player_two_is_the_winner_when_she_has_a_full_line_marked() {
        Marks marks = marks()
                            .fromPlayerOneAt(CELL_2, CELL_3)
                            .fromPlayerTwoAt(CELL_1, CELL_5, CELL_9)
                            .build();

        assertThat(boardLines.winnerMark(marks), is(NOUGHT));
    }

    @Test public void
    return_a_list_of_lines_with_a_single_matching_mark() {
        Marks marks = marks()
                            .fromPlayerOneAt(CELL_1, CELL_8)
                            .fromPlayerTwoAt(CELL_5)
                            .build();

        List<Line> lines = boardLines.withSingleMark(NOUGHT, marks);

        assertThat(lines, Matchers.hasItems(DIAGONAL_2, ROW_2));
    }

}