package org.craftedsw.tictactoe;

import org.junit.Before;
import org.junit.Test;

import static org.craftedsw.tictactoe.Board.CELL_1;
import static org.craftedsw.tictactoe.Board.CELL_5;
import static org.craftedsw.tictactoe.BoardLines.ROW_2;
import static org.craftedsw.tictactoe.Player.PLAYER_ONE;
import static org.craftedsw.tictactoe.builder.MarksBuilder.marks;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class BoardLinesShould {

    private BoardLines boardLines;

    @Before
    public void initialise() {
        boardLines = new BoardLines();
    }

    @Test public void
    should_return_null_when_there_is_no_winning_line() {
        String[] marks = marks()
                               .fromPlayerOneAt(CELL_1, CELL_5)
                               .fromPlayerTwoAt(Board.CELL_4, Board.CELL_9)
                               .buildAsArray();

        assertThat(boardLines.winningLine(PLAYER_ONE, marks),  is(nullValue()));
    }

    @Test public void
    should_return_a_winning_line() {
        String[] marks = new String[] {"0", " ", " ", "X", " ", "X", "0", " ", " "};

        Line winningLine = boardLines.winningLine(PLAYER_ONE, marks);

        assertThat(winningLine, is(ROW_2));
    }

    @Test public void
    should_return_a_loosing_line() {
        String[] marks = new String[] {"0", " ", " ", "X", " ", "X", "0", " ", " "};
        Player opponent = PLAYER_ONE;

        Line winningLine = boardLines.loosingLine(opponent, marks);

        assertThat(winningLine, is(ROW_2));
    }

}
