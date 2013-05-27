package org.craftedsw.tictactoe;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class InvencibleOpponentShould {

    private InvencibleOpponent opponent;
    private Board board = mock(Board.class);
    private String[] marks;

    @Before
    public void initialise() {
        this.marks =  new String[]{" ", " ", " ", " ", " ", " ", " ", " ", " "};
        when(board.marks()).thenReturn(marks);
        opponent = new InvencibleOpponent();
    }

    @Test public void
    should_place_mark_on_first_empty_cell() {
        this.marks =  new String[]{" ", " ", " ", " ", " ", " ", " ", " ", " "};

        int nextMark = opponent.nextMark(board);

        assertThat(nextMark, is(0));
    }

}
