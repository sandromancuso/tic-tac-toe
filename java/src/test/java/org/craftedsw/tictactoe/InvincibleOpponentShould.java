package org.craftedsw.tictactoe;

import org.craftedsw.tictactoe.strategy.AttackStrategy;
import org.craftedsw.tictactoe.strategy.DefenceStrategy;
import org.craftedsw.tictactoe.strategy.WinStrategy;
import org.junit.Before;
import org.junit.Test;

import static org.craftedsw.tictactoe.Board.CELL_2;
import static org.craftedsw.tictactoe.Board.NO_CELL;
import static org.craftedsw.tictactoe.Player.PLAYER_ONE;
import static org.craftedsw.tictactoe.Player.PLAYER_TWO;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;

public class InvincibleOpponentShould {

    private static final int CELL_3 = 2;
    private InvincibleOpponent opponent;
    private WinStrategy winStrategy = mock(WinStrategy.class);
    private DefenceStrategy defenceStrategy = mock(DefenceStrategy.class);
    private AttackStrategy attackStrategy = mock(AttackStrategy.class);
    private Board board = mock(Board.class);
    private Marks marks;

    @Before
    public void initialise() {
        this.marks =  new Marks(new String[]{" ", " ", " ", " ", " ", " ", " ", " ", " "});
        when(board.marks()).thenReturn(marks);
        opponent = new InvincibleOpponent(PLAYER_ONE, winStrategy, defenceStrategy, attackStrategy);
        when(attackStrategy.nextMark(any(Player.class), any(Marks.class))).thenReturn(NO_CELL);
    }

    @Test public void
    should_place_mark_on_first_empty_cell() {
        this.marks =  new Marks(new String[]{"0", " ", "X", " ", " ", " ", " ", " ", " "});
        when(board.marks()).thenReturn(marks);
        when(winStrategy.nextCell(PLAYER_ONE, marks)).thenReturn(NO_CELL);
        when(defenceStrategy.nextCell(PLAYER_ONE, marks)).thenReturn(NO_CELL);
        when(attackStrategy.nextMark(PLAYER_ONE, marks)).thenReturn(NO_CELL);

        int nextMark = opponent.nextCell(board);

        assertThat(nextMark, is(CELL_2));
    }

    @Test public void
    should_place_mark_according_to_winning_mark() {
        when(winStrategy.nextCell(PLAYER_ONE, marks)).thenReturn(CELL_3);

        int nextMark = opponent.nextCell(board);

        assertThat(nextMark, is(CELL_3));
    }

    @Test public void
    should_defend_when_needed() {
        when(winStrategy.nextCell(PLAYER_ONE, marks)).thenReturn(NO_CELL);
        when(defenceStrategy.nextCell(PLAYER_ONE, marks)).thenReturn(CELL_3);

        int nextMark = opponent.nextCell(board);

        assertThat(nextMark, is(CELL_3));
    }

}
