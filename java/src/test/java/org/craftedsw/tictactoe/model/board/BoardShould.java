package org.craftedsw.tictactoe.model.board;

import org.craftedsw.tictactoe.view.Console;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InOrder;
import org.mockito.Mockito;

import static org.craftedsw.tictactoe.model.board.BoardStructure.*;
import static org.craftedsw.tictactoe.model.game.Player.PLAYER_ONE;
import static org.craftedsw.tictactoe.view.BoardDisplay.CELL_INDEX_INSTRUCTIONS;
import static org.craftedsw.tictactoe.view.BoardDisplay.CURRENT_BOARD_STATE_MESSAGE;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class BoardShould {

    private Board board;
    private Console console;

    @Before
    public void initialise() {
        console = mock(Console.class);
        board = new Board(console);
    }

    @Test public void
    display_empty_board_when_new_game_starts() {
        board.newGame();

        InOrder inOrder = Mockito.inOrder(console);

        inOrder.verify(console).print(CELL_INDEX_INSTRUCTIONS);
        inOrder.verify(console).print(CURRENT_BOARD_STATE_MESSAGE);
    }

    @Test public void
    display_mark_on_the_board() {
        final String BOARD_WITH_X_ON_CELL_2 =

            "   | X |   " + "\n" +
            "---+---+---" + "\n" +
            "   |   |   " + "\n" +
            "---+---+---" + "\n" +
            "   |   |   ";

        board.placeMarkAt(CELL_2);

        verify(console).print(BOARD_WITH_X_ON_CELL_2);
    }

    @Test public void
    display_board_with_multiple_marks() {
        final String BOARD =

            " X | X | 0 " + "\n" +
            "---+---+---" + "\n" +
            "   | 0 |   " + "\n" +
            "---+---+---" + "\n" +
            " X |   | 0 ";

        board.placeMarkAt(CELL_1);
        board.placeMarkAt(CELL_5);
        board.placeMarkAt(CELL_2);
        board.placeMarkAt(CELL_3);
        board.placeMarkAt(CELL_7);
        board.placeMarkAt(CELL_9);

        verify(console).print(BOARD);
    }

    @Test public void
    inform_there_is_no_winner() {
        board.placeMarkAt(CELL_1);

        assertThat(board.hasWinner(), is(false));
    }

    @Test public void
    inform_there_is_winner_when_same_mark_is_placed_on_top_row() {
        board.placeMarkAt(CELL_1); // X
        board.placeMarkAt(CELL_4); // 0
        board.placeMarkAt(CELL_2); // X
        board.placeMarkAt(CELL_5); // 0
        board.placeMarkAt(CELL_3); // X

        assertThat(board.hasWinner(), is(true));
    }

    @Test public void
    inform_there_is_winner_when_same_mark_is_placed_on_middle_row() {
        board.placeMarkAt(CELL_4); // X
        board.placeMarkAt(CELL_1); // 0
        board.placeMarkAt(CELL_5); // X
        board.placeMarkAt(CELL_2); // 0
        board.placeMarkAt(CELL_6); // X

        assertThat(board.hasWinner(), is(true));
        assertThat(board.winner(), is(PLAYER_ONE));
    }

    @Test public void
    inform_there_is_winner_when_same_mark_is_placed_on_first_column() {
        board.placeMarkAt(CELL_1); // X
        board.placeMarkAt(CELL_5); // 0
        board.placeMarkAt(CELL_4); // X
        board.placeMarkAt(CELL_2); // 0
        board.placeMarkAt(CELL_7); // X

        assertThat(board.hasWinner(), is(true));
        assertThat(board.winner(), is(PLAYER_ONE));
    }

    @Test(expected = Exception.class) public void
    throw_exception_when_cell_is_placed_in_an_occupied_position() {
        board.placeMarkAt(CELL_1);
        board.placeMarkAt(CELL_1);
    }

    @Test public void
    inform_when_it_is_not_full() {
        board.placeMarkAt(CELL_1);

        assertThat(board.isFull(), is(false));
    }

    @Test public void
    inform_when_it_is_full() {
        for (int cell : BoardStructure.ALL_CELLS) {
            board.placeMarkAt(cell);
        }

        assertThat(board.isFull(), is(true));
    }

}
