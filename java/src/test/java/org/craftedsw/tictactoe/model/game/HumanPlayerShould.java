package org.craftedsw.tictactoe.model.game;

import org.craftedsw.tictactoe.model.board.Marks;
import org.craftedsw.tictactoe.view.Console;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.craftedsw.tictactoe.model.board.BoardStructure.CELL_3;
import static org.craftedsw.tictactoe.model.board.BoardStructure.CELL_4;
import static org.craftedsw.tictactoe.model.game.HumanPlayer.ASK_FOR_NEXT_MARK;
import static org.craftedsw.tictactoe.model.game.PlayerMark.NOUGHT;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class HumanPlayerShould {

    @Mock private Console console;
    @Mock private Marks marks;
    private HumanPlayer player;

    @Before
    public void initialise() {
        player = new HumanPlayer(NOUGHT, console);
    }

    @Test public void
    place_a_mark() {
        when(console.getIntAnswerFor(ASK_FOR_NEXT_MARK)).thenReturn(3);

        player.placeMarkOn(marks);

        verify(marks).placeMarkAt(CELL_3, NOUGHT);
    }

    @Test public void
    ask_player_for_a_new_mark_when_player_tries_to_place_mark_on_a_occupied_cell() {
        when(console.getIntAnswerFor(ASK_FOR_NEXT_MARK)).thenReturn(3, 4);
        doThrow(RuntimeException.class).when(marks).placeMarkAt(CELL_3, NOUGHT);

        player.placeMarkOn(marks);

        verify(console, times(2)).getIntAnswerFor(ASK_FOR_NEXT_MARK);
        verify(marks, times(1)).placeMarkAt(CELL_3, NOUGHT);
        verify(marks, times(1)).placeMarkAt(CELL_4, NOUGHT);
    }

    @Test public void
    inform_her_mark() {
        assertThat(player.mark(), is(NOUGHT));
    }

}
