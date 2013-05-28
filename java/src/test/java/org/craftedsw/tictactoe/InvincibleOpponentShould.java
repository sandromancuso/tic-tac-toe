package org.craftedsw.tictactoe;

import org.craftedsw.tictactoe.strategy.MarkStrategy;
import org.junit.Before;
import org.junit.Test;

import static org.craftedsw.tictactoe.strategy.MarkStrategy.NONE;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class InvincibleOpponentShould {

    private static final int CELL_3 = 2;
    private InvincibleOpponent opponent;
    private MarkStrategy markStrategy = mock(MarkStrategy.class);
    private Board board = mock(Board.class);
    private String[] marks;

    @Before
    public void initialise() {
        this.marks =  new String[]{" ", " ", " ", " ", " ", " ", " ", " ", " "};
        when(board.marks()).thenReturn(marks);
        opponent = new InvincibleOpponent(markStrategy);
    }

    @Test public void
    should_place_mark_on_first_empty_cell() {
        this.marks =  new String[]{" ", " ", " ", " ", " ", " ", " ", " ", " "};

        int nextMark = opponent.nextMark(board);

        assertThat(nextMark, is(0));
    }

    @Test public void
    should_place_mark_according_to_winning_mark() {
        when(markStrategy.winMark(marks)).thenReturn(CELL_3);

        int nextMark = opponent.nextMark(board);

        assertThat(nextMark, is(CELL_3));
    }

    @Test public void
    should_defend_when_needed() {
        when(markStrategy.winMark(marks)).thenReturn(NONE);
        when(markStrategy.defenceMark(marks)).thenReturn(CELL_3);

        int nextMark = opponent.nextMark(board);

        assertThat(nextMark, is(CELL_3));
    }

}
