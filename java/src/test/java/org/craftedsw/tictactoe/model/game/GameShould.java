package org.craftedsw.tictactoe.model.game;

import org.craftedsw.tictactoe.model.board.BoardLines;
import org.craftedsw.tictactoe.model.board.Marks;
import org.craftedsw.tictactoe.view.BoardDisplay;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import static org.craftedsw.tictactoe.builder.MarksBuilder.marks;
import static org.craftedsw.tictactoe.model.game.PlayerMark.CROSS;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class GameShould {

    private Game game;
    @Mock private BoardDisplay boardDisplay;
    @Mock private Player machinePlayer;
    @Mock private Player humanPlayer;
    @Mock private BoardLines boardLines;
    private Marks marks;


    @Before
    public void initialise() {
        marks = spy(marks().build());
        game = new TestableGame(boardDisplay, machinePlayer, humanPlayer);
        when(machinePlayer.mark()).thenReturn(CROSS);
    }

    @Test public void
    display_board_with_the_machine_player_mark_when_new_game_starts() {
        game.startNewGame();

        InOrder inOrder = Mockito.inOrder(boardDisplay, machinePlayer);

        inOrder.verify(machinePlayer).placeMark(any(Marks.class));
        inOrder.verify(boardDisplay).displayGameInstructions();
        inOrder.verify(boardDisplay).displayBoard(any(Marks.class));
    }

    @Test public void
    inform_game_is_not_over_when_there_is_no_winner_and_board_is_not_full() {
        when(boardLines.hasWinnerLine(marks)).thenReturn(false);
        when(marks.isFull()).thenReturn(false);

        assertThat(game.isOver(), is(false));
    }

    @Test public void
    terminate_when_all_cells_have_marks() {
        when(marks.isFull()).thenReturn(true);

        assertThat(game.isOver(), is(true));
    }

    @Test public void
    display_the_game_result() {
        when(boardLines.winner(marks)).thenReturn(CROSS);

        game.displayGameResult();

        verify(boardDisplay).displayGameResult(CROSS);

    }

    private class TestableGame extends Game {
        public TestableGame(BoardDisplay boardDisplay, Player machinePlayer, Player humanPlayer) {
            super(boardDisplay, machinePlayer, humanPlayer);
        }

        @Override
        protected Marks initialiseMarks() {
            return marks;
        }

        @Override
        protected BoardLines newBoardLines() {
            return boardLines;
        }
    }

}
