package org.craftedsw.tictactoe.model.board;

import org.craftedsw.tictactoe.model.game.Player;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.craftedsw.tictactoe.builder.MarksBuilder.marks;
import static org.craftedsw.tictactoe.model.board.BoardStructure.*;
import static org.craftedsw.tictactoe.model.game.Player.PLAYER_ONE;
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

        assertThat(boardLines.winningLine(PLAYER_ONE, marks),  is(nullValue()));
    }

    @Test public void
    return_a_winning_line() {
        Marks marks = marks()
                            .fromPlayerOneAt(CELL_4, CELL_6)
                            .fromPlayerTwoAt(CELL_1, CELL_7)
                            .build();

        Line winningLine = boardLines.winningLine(PLAYER_ONE, marks);

        assertThat(winningLine, is(ROW_2));
    }

    @Test public void
    return_a_loosing_line() {
        Marks marks = marks()
                            .fromPlayerOneAt(CELL_4, CELL_6)
                            .fromPlayerTwoAt(CELL_1, CELL_7)
                            .build();
        Player opponent = PLAYER_ONE;

        Line winningLine = boardLines.loosingLine(opponent, marks);

        assertThat(winningLine, is(ROW_2));
    }

    @Test public void
    return_lines_where_just_one_corner_is_selected() {
        Marks marks = marks()
                            .fromPlayerOneAt(CELL_3, CELL_6)
                            .build();

        List<Line> lines = boardLines.linesWhereJustOneCornerIsSelectedBy(PLAYER_ONE, marks);

        assertThat(lines.size(), is(2));
        assertThat(lines.contains(ROW_1), is(true));
        assertThat(lines.contains(DIAGONAL_2), is(true));
    }

}