package org.craftedsw.tictactoe.model.game;

import org.craftedsw.tictactoe.model.board.Marks;
import org.craftedsw.tictactoe.model.strategy.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Iterator;

import static org.craftedsw.tictactoe.builder.MarksBuilder.marks;
import static org.craftedsw.tictactoe.model.board.BoardStructure.*;
import static org.craftedsw.tictactoe.model.game.Player.PLAYER_ONE;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class MachinePlayerShould {

    @Mock private GameStrategies strategies;
    @Mock private Iterator<Strategy> strategiesIterator;
    @Mock private WinStrategy winStrategy;
    @Mock private DefenceStrategy defenceStrategy;
    @Mock private AttackStrategy attackStrategy;

    private MachinePlayer machinePlayer;
    private Marks marks = marks().build();

    @Before
    public void initialise() {
        machinePlayer = new MachinePlayer(PLAYER_ONE, strategies);
        when(strategies.iterator()).thenReturn(strategiesIterator);
        when(strategiesIterator.next()).thenReturn(winStrategy, defenceStrategy, attackStrategy);
        when(strategiesIterator.hasNext()).thenReturn(true, true, true, false);
    }

    @Test public void
    return_same_cell_returned_by_first_strategy_if_different_from_no_cell() {
        when(winStrategy.nextCell(PLAYER_ONE, marks)).thenReturn(CELL_3);

        assertThat(machinePlayer.nextCell(marks), is(CELL_3));
    }

    @Test public void
    return_cell_from_third_strategy_when_previous_strategies_returned_no_cell() {
        when(winStrategy.nextCell(PLAYER_ONE, marks)).thenReturn(NO_CELL);
        when(defenceStrategy.nextCell(PLAYER_ONE, marks)).thenReturn(NO_CELL);
        when(attackStrategy.nextCell(PLAYER_ONE, marks)).thenReturn(CELL_4);

        assertThat(machinePlayer.nextCell(marks), is(CELL_4));
    }

    @Test public void
    inform_her_mark() {
        machinePlayer = new MachinePlayer(PLAYER_ONE, strategies);

        assertThat(machinePlayer.mark(), is(PLAYER_ONE.mark()));
    }

}