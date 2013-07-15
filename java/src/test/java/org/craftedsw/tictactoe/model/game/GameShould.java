package org.craftedsw.tictactoe.model.game;

import org.craftedsw.tictactoe.model.board.BoardLines;
import org.craftedsw.tictactoe.model.board.Marks;
import org.craftedsw.tictactoe.view.BoardDisplay;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static java.util.Arrays.copyOfRange;
import static java.util.Arrays.fill;
import static org.craftedsw.tictactoe.builder.MarksBuilder.marks;
import static org.craftedsw.tictactoe.model.game.PlayerMark.CROSS;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class GameShould {

    @Mock private BoardDisplay boardDisplay;
    @Mock private Player noughtsPlayer;
    @Mock private Player crossesPlayer;
    @Mock private BoardLines boardLines;

    private Game game;
    private Marks marks;

    @Before
    public void initialise() {
        marks = spy(marks().build());
        game = new TestableGame(boardDisplay, noughtsPlayer, crossesPlayer);
    }

    @Test public void
    terminate_when_there_is_a_winner() {
        when(boardLines.hasWinnerLine(marks)).thenReturn(true);

        game.startNewGame();

        verify(boardLines, times(1)).hasWinnerLine(marks);
    }

    @Test public void
    terminate_when_board_is_full() {
        when(marks.isFull()).thenReturn(true);

        game.startNewGame();

        verify(marks, times(1)).isFull();
    }

    @Test public void
    display_game_instructions_when_new_game_starts() {
        configureGameToFinishAfter(ZERO_ITERATIONS);

        game.startNewGame();

        verify(boardDisplay).displayGameInstructions(marks);
    }

    @Test public void
    ask_first_player_to_place_a_mark() {
        configureGameToFinishAfter(ONE_ITERATION);

        game.startNewGame();

        verify(boardLines, times(2)).hasWinnerLine(marks);
        verify(noughtsPlayer, times(1)).placeMarkOn(marks);
        verify(crossesPlayer, never()).placeMarkOn(marks);
    }

    @Test public void
    ask_players_in_turn_to_place_marks() {
        configureGameToFinishAfter(FIVE_ITERATIONS);

        game.startNewGame();

        InOrder inOrder = inOrder(noughtsPlayer, crossesPlayer);
        inOrder.verify(noughtsPlayer).placeMarkOn(marks);
        inOrder.verify(crossesPlayer).placeMarkOn(marks);
        inOrder.verify(noughtsPlayer).placeMarkOn(marks);
        inOrder.verify(crossesPlayer).placeMarkOn(marks);
        inOrder.verify(noughtsPlayer).placeMarkOn(marks);
    }

    @Test public void
    display_the_game_result() {
        when(boardLines.winnerMark(marks)).thenReturn(CROSS);

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

    private static int ZERO_ITERATIONS = 0;
    private static int ONE_ITERATION   = 1;
    private static int FIVE_ITERATIONS = 5;

    private void configureGameToFinishAfter(int iterations) {
        Boolean[] hasWinner = new Boolean[iterations + 1];
        fill(hasWinner, false);
        hasWinner[iterations] = true;

        when(boardLines.hasWinnerLine(marks)).thenReturn(hasWinner[0], copyOfRange(hasWinner, 1, hasWinner.length));
    }

}
