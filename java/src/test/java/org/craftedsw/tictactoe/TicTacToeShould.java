package org.craftedsw.tictactoe;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InOrder;

import static org.craftedsw.tictactoe.Board.ASK_FOR_NEXT_MARK;
import static org.craftedsw.tictactoe.BoardDisplay.CELL_INDEX_INSTRUCTIONS;
import static org.craftedsw.tictactoe.Player.PLAYER_ONE;
import static org.craftedsw.tictactoe.TicTacToe.*;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.*;

public class TicTacToeShould {

    private static final int CELL_3 = 3;

    private Console console = mock(Console.class);
    private Opponent opponent = mock(Opponent.class);
    private Board board = spy(new Board());
    private TicTacToe ticTacToe;

    @Before
    public void initialise() {
        ticTacToe = new TicTacToe(console, board);
    }

    @Test public void
    print_current_state_of_the_board_after_player_input() {
        when(board.representation()).thenReturn("EMPTY BOARD", "BOARD REPRESENTATION");
        when(console.ask(ASK_FOR_NEXT_MARK)).thenReturn(CELL_3);
        when(board.hasWinner()).thenReturn(false, true);

        ticTacToe.newGame();

        InOrder inOrder = inOrder(console, board);
        inOrder.verify(console).print(CELL_INDEX_INSTRUCTIONS);
        inOrder.verify(console).print(CURRENT_BOARD_STATE_MSG);
        inOrder.verify(board).representation();
        inOrder.verify(console).ask(ASK_FOR_NEXT_MARK);
        inOrder.verify(board).place(CELL_3 - 1);
        inOrder.verify(board).representation();
    }

    @Test public void
    ask_game_to_place_its_mark_after_player_placed_hers() {
        when(console.ask(ASK_FOR_NEXT_MARK)).thenReturn(1, 2, 3); // one based
        when(opponent.nextCell(board)).thenReturn(3, 4); // zero based

        ticTacToe.newSinglePlayerGame(opponent);

        assertThat(board.winner(), is(PLAYER_ONE));
    }


}
