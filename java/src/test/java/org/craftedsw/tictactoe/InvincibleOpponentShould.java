package org.craftedsw.tictactoe;

import org.craftedsw.tictactoe.builder.MarksBuilder;
import org.craftedsw.tictactoe.strategy.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Iterator;

import static org.craftedsw.tictactoe.Board.CELL_3;
import static org.craftedsw.tictactoe.Board.CELL_4;
import static org.craftedsw.tictactoe.Board.NO_CELL;
import static org.craftedsw.tictactoe.Player.PLAYER_ONE;
import static org.craftedsw.tictactoe.builder.MarksBuilder.marks;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class InvincibleOpponentShould {

    @Mock private InvincibleStrategies strategies;
    @Mock private Iterator<Strategy> strategiesIterator;
    @Mock private WinStrategy winStrategy;
    @Mock private DefenceStrategy defenceStrategy;
    @Mock private AttackStrategy attackStrategy;

    private InvincibleOpponent opponent;
    private Marks marks = marks().build();

    @Before
    public void initialise() {
        opponent = new InvincibleOpponent(PLAYER_ONE, strategies);
        when(strategies.iterator()).thenReturn(strategiesIterator);
        when(strategiesIterator.next()).thenReturn(winStrategy, defenceStrategy, attackStrategy);
        when(strategiesIterator.hasNext()).thenReturn(true, true, true, false);
    }

    @Test public void
    should_return_same_cell_returned_by_first_strategy() {
        when(winStrategy.nextCell(PLAYER_ONE, marks)).thenReturn(CELL_3);

        assertThat(opponent.nextCell(marks), is(CELL_3));
    }

    @Test public void
    should_return_cell_from_third_strategy_when_previous_strategies_returned_no_cell() {
        when(winStrategy.nextCell(PLAYER_ONE, marks)).thenReturn(NO_CELL);
        when(defenceStrategy.nextCell(PLAYER_ONE, marks)).thenReturn(NO_CELL);
        when(attackStrategy.nextCell(PLAYER_ONE, marks)).thenReturn(CELL_4);

        assertThat(opponent.nextCell(marks), is(CELL_4));
    }

}
