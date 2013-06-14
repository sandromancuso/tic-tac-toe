package org.craftedsw.tictactoe.model.game;

import org.craftedsw.tictactoe.model.board.Board;
import org.craftedsw.tictactoe.model.board.Marks;
import org.craftedsw.tictactoe.view.Console;
import org.junit.Before;
import org.junit.Test;

import static org.craftedsw.tictactoe.model.game.Player.PLAYER_ONE;
import static org.craftedsw.tictactoe.view.BoardDisplay.ASK_FOR_NEXT_MARK;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.mockito.BDDMockito.*;
import static org.mockito.Matchers.any;

public class TicTacToeShould {

    private Console console = mock(Console.class);
    private Opponent opponent = mock(Opponent.class);
    private Board board = spy(new Board());
    private TicTacToe ticTacToe;

    @Before
    public void initialise() {
        ticTacToe = new TicTacToe(console, board);
    }

    @Test public void
    ask_game_to_place_its_mark_after_player_placed_hers() {
        when(opponent.nextCell(any(Marks.class))).thenReturn(0, 1, 2); // zero based
        when(console.ask(ASK_FOR_NEXT_MARK)).thenReturn(4, 5); // one based

        ticTacToe.newSinglePlayerGame(opponent);

        assertThat(board.winner(), is(PLAYER_ONE));
    }

    @Test public void
    should_end_the_game_when_board_is_full() {
        when(opponent.nextCell(any(Marks.class))).thenReturn(0); // zero based
        when(console.ask(ASK_FOR_NEXT_MARK)).thenReturn(4);
        when(board.isFull()).thenReturn(true);

        ticTacToe.newSinglePlayerGame(opponent);

        assertThat(board.hasWinner(), is(false));
    }


}
