package org.craftedsw.tictactoe.model.board;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class BoardLinesParameterizedShould {

    @Parameters(name = "{index}: Winner line {1} ")
    public static Iterable<Object[]> marks() {
        return Arrays.asList(new Object[][] {
                {new String[] {" ", " ", " ", " ", " ", " ", " ", " ", " "}, FALSE},
                {new String[] {"X", "X", "X", " ", " ", " ", " ", " ", " "}, TRUE},
                {new String[] {"0", "0", "0", " ", " ", " ", " ", " ", " "}, TRUE},
                {new String[] {" ", " ", " ", "X", "X", "X", " ", " ", " "}, TRUE},
                {new String[] {" ", " ", " ", "0", "0", "0", " ", " ", " "}, TRUE},
                {new String[] {" ", " ", " ", " ", " ", " ", "X", "X", "X"}, TRUE},
                {new String[] {" ", " ", " ", " ", " ", " ", "0", "0", "0"}, TRUE},
                {new String[] {"X", " ", " ", " ", "X", " ", " ", " ", "X"}, TRUE},
                {new String[] {"0", " ", " ", " ", "0", " ", " ", " ", "0"}, TRUE},
                {new String[] {" ", " ", "X", " ", "X", " ", "X", " ", " "}, TRUE},
                {new String[] {" ", " ", "0", " ", "0", " ", "0", " ", " "}, TRUE},
                {new String[] {"X", " ", " ", "X", " ", " ", "X", " ", " "}, TRUE},
                {new String[] {"0", " ", " ", "0", " ", " ", "0", " ", " "}, TRUE},
                {new String[] {" ", "X", " ", " ", "X", " ", " ", "X", " "}, TRUE},
                {new String[] {" ", "0", " ", " ", "0", " ", " ", "0", " "}, TRUE},
                {new String[] {" ", " ", "X", " ", " ", "X", " ", " ", "X"}, TRUE},
                {new String[] {" ", " ", "0", " ", " ", "0", " ", " ", "0"}, TRUE},
                {new String[] {"X", "0", "X", "0", "X", "X", "0", "X", "0"}, FALSE},
                {new String[] {"X", " ", " ", "0", "X", " ", "0", "X", " "}, FALSE}
        });
    }

    private String[] marks;
    private boolean winnerLine;

    public BoardLinesParameterizedShould(String[] marks, boolean isWinnerLine) {
        this.marks = marks;
        this.winnerLine = isWinnerLine;
    }

    @Test public void
    inform_when_there_is_a_winner_line() {
        BoardLines boardLines = new BoardLines();

        assertThat(boardLines.hasWinnerLine(new Marks(marks)), is(winnerLine));
    }

}
