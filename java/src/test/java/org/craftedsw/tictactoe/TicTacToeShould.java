package org.craftedsw.tictactoe;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InOrder;

import static org.craftedsw.tictactoe.Board.ASK_FOR_NEXT_MARK;
import static org.craftedsw.tictactoe.BoardDisplay.CELL_INDEX_INSTRUCTIONS;
import static org.craftedsw.tictactoe.Player.PLAYER_ONE;
import static org.craftedsw.tictactoe.TicTacToe.*;
import static org.mockito.BDDMockito.*;

public class TicTacToeShould {

    private static final int CELL_1 = 1;
    private static final int CELL_2 = 2;
    private static final int CELL_3 = 3;

    private Console console = mock(Console.class);
    private Board board = mock(Board.class);
    private TicTacToe ticTacToe;

    @Before
    public void initialise() {
        ticTacToe = new TicTacToe(console, board);
        when(board.hasWinner()).thenReturn(true);
    }

    @Test public void
    display_instructions_whent_the_game_starts() {
        when(board.representation()).thenReturn("EMPTY BOARD");

        ticTacToe.newGame();

        InOrder inOrder = inOrder(console);
        inOrder.verify(console).print(CELL_INDEX_INSTRUCTIONS);
        inOrder.verify(console).print(CURRENT_BOARD_STATE_MSG);
        inOrder.verify(console).print("EMPTY BOARD");
        inOrder.verify(console).ask(ASK_FOR_NEXT_MARK);
    }

    @Test public void
    ask_player_to_place_her_mark_after_game_starts() {
        ticTacToe.newGame();

        verify(console).ask(ASK_FOR_NEXT_MARK);
    }

    @Test public void
    print_current_state_of_the_board_after_player_input() {
        when(board.representation()).thenReturn("EMPTY BOARD", "BOARD REPRESENTATION");
        when(console.ask(ASK_FOR_NEXT_MARK)).thenReturn(CELL_3);

        ticTacToe.newGame();

        InOrder inOrder = inOrder(console, board);
        inOrder.verify(console).print(CELL_INDEX_INSTRUCTIONS);
        inOrder.verify(console).print(CURRENT_BOARD_STATE_MSG);
        inOrder.verify(board).representation();
        inOrder.verify(console).print("EMPTY BOARD");
        inOrder.verify(console).ask(ASK_FOR_NEXT_MARK);
        inOrder.verify(board).placeMarkOn(CELL_3);
        inOrder.verify(board).representation();
        inOrder.verify(console).print("BOARD REPRESENTATION");
    }

    @Test public void
    end_the_game_when_there_is_a_winner() {
        when(board.hasWinner()).thenReturn(false, false , true);
        when(console.ask(ASK_FOR_NEXT_MARK)).thenReturn(CELL_1, CELL_2, CELL_3);
        when(board.winner()).thenReturn(PLAYER_ONE);

        ticTacToe.newGame();

        verify(console).print(WINNER_IS + PLAYER_ONE);
    }


}
