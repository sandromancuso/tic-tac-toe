package org.craftedsw.tictactoe.model.board;

import org.junit.Before;
import org.junit.Test;

import static org.craftedsw.tictactoe.model.board.Board.*;
import static org.craftedsw.tictactoe.model.game.Player.PLAYER_ONE;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class BoardShould {

    private Board board;

    @Before
    public void initialise() {
        board = new Board();
    }

    @Test public void
    display_empty_board_when_no_marks_are_placed() {
        final String EMPTY_BOARD =

            "   |   |   " + "\n" +
            "---+---+---" + "\n" +
            "   |   |   " + "\n" +
            "---+---+---" + "\n" +
            "   |   |   ";

        String representation = board.representation();

        assertThat(representation, is(equalTo(EMPTY_BOARD)));
    }

    @Test public void
    display_mark_on_the_board() {
        final String BOARD_WITH_X_ON_CELL_2 =

            "   | X |   " + "\n" +
            "---+---+---" + "\n" +
            "   |   |   " + "\n" +
            "---+---+---" + "\n" +
            "   |   |   ";

        board.place(CELL_2);

        assertThat(board.representation(), is(equalTo(BOARD_WITH_X_ON_CELL_2)));
    }

    @Test public void
    display_board_with_multiple_marks() {
        final String BOARD =

            " X | X | 0 " + "\n" +
            "---+---+---" + "\n" +
            "   | 0 |   " + "\n" +
            "---+---+---" + "\n" +
            " X |   | 0 ";

        board.place(CELL_1);
        board.place(CELL_5);
        board.place(CELL_2);
        board.place(CELL_3);
        board.place(CELL_7);
        board.place(CELL_9);

        assertThat(board.representation(), is(equalTo(BOARD)));
    }

    @Test public void
    informs_there_is_no_winner() {
        board.place(CELL_1);

        assertThat(board.hasWinner(), is(false));
    }

    @Test public void
    informs_there_is_winner_when_same_mark_is_placed_on_top_row() {
        board.place(CELL_1); // X
        board.place(CELL_4); // 0
        board.place(CELL_2); // X
        board.place(CELL_5); // 0
        board.place(CELL_3); // X

        assertThat(board.hasWinner(), is(true));
    }

    @Test public void
    informs_there_is_winner_when_same_mark_is_placed_on_middle_row() {
        board.place(CELL_4); // X
        board.place(CELL_1); // 0
        board.place(CELL_5); // X
        board.place(CELL_2); // 0
        board.place(CELL_6); // X

        assertThat(board.hasWinner(), is(true));
        assertThat(board.winner(), is(PLAYER_ONE));
    }

    @Test public void
    informs_there_is_winner_when_same_mark_is_placed_on_first_column() {
        board.place(CELL_1); // X
        board.place(CELL_5); // 0
        board.place(CELL_4); // X
        board.place(CELL_2); // 0
        board.place(CELL_7); // X

        assertThat(board.hasWinner(), is(true));
        assertThat(board.winner(), is(PLAYER_ONE));
    }

    @Test(expected = Exception.class) public void
    should_throw_exception_when_cell_is_placed_in_an_occupied_position() {
        board.place(CELL_1);
        board.place(CELL_1);
    }

    @Test public void
    should_inform_when_it_is_not_full() {
        board.place(CELL_1);

        assertThat(board.isFull(), is(false));
    }

    @Test public void
    should_inform_when_it_is_full() {
        for (int cell : ALL_CELLS) {
            board.place(cell);
        }

        assertThat(board.isFull(), is(true));
    }

}
