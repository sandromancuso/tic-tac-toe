package org.craftedsw.tictactoe.model.board;

import org.craftedsw.tictactoe.model.game.MachinePlayer;
import org.craftedsw.tictactoe.model.game.Player;
import org.craftedsw.tictactoe.view.Console;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import static java.util.Arrays.copyOfRange;
import static org.craftedsw.tictactoe.model.board.BoardStructure.*;
import static org.craftedsw.tictactoe.model.game.Player.PLAYER_ONE;
import static org.craftedsw.tictactoe.model.game.Player.PLAYER_TWO;
import static org.craftedsw.tictactoe.view.BoardDisplay.CELL_INDEX_INSTRUCTIONS;
import static org.craftedsw.tictactoe.view.BoardDisplay.CURRENT_BOARD_STATE_MESSAGE;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class BoardShould {

    private Board board;
    @Mock private Console console;
    @Mock private MachinePlayer machinePlayer;
    private Player humanPlayer = PLAYER_TWO;


    @Before
    public void initialise() {
        board = new Board(console, machinePlayer, humanPlayer);
        when(machinePlayer.mark()).thenReturn(PLAYER_ONE.mark());
    }

    @Test public void
    display_board_with_the_machine_player_mark_when_new_game_starts() {
        board.newGame();

        InOrder inOrder = Mockito.inOrder(console, machinePlayer);

        inOrder.verify(machinePlayer).nextCell(any(Marks.class));
        inOrder.verify(console).print(CELL_INDEX_INSTRUCTIONS);
        inOrder.verify(console).print(CURRENT_BOARD_STATE_MESSAGE);
    }

    @Test public void
    inform_game_is_not_over_when_there_is_no_winner_and_board_is_not_full() {
        machinePlayerWillMark(CELL_1, CELL_3);

        board.newGame();
        board.placeMarkAt(CELL_2);

        assertThat(board.gameIsOver(), is(false));
    }

    @Test public void
    inform_there_is_winner_when_top_row_is_fully_marked_by_player_one() {
        machinePlayerWillMark(CELL_1, CELL_2, CELL_3);

        board.newGame();
        board.placeMarkAt(CELL_4);
        board.placeMarkAt(CELL_5);

        assertThat(board.winner(), is(PLAYER_ONE));
    }

    @Test public void
    inform_there_is_winner_when_middle_row_is_fully_marked_by_player_one() {
        machinePlayerWillMark(CELL_4, CELL_5, CELL_6);

        board.newGame();

        board.placeMarkAt(CELL_1);
        board.placeMarkAt(CELL_3);
        board.placeMarkAt(CELL_9);

        assertThat(board.winner(), is(PLAYER_ONE));
    }

    @Test public void
    inform_there_is_winner_when_first_column_is_fully_marked_by_player_two() {
        machinePlayerWillMark(CELL_5, CELL_2, CELL_8);

        board.newGame();

        board.placeMarkAt(CELL_1);
        board.placeMarkAt(CELL_4);
        board.placeMarkAt(CELL_7);

        assertThat(board.winner(), is(PLAYER_TWO));
    }

    @Test(expected = Exception.class) public void
    throw_exception_when_cell_is_placed_in_an_occupied_position() {
        board.placeMarkAt(CELL_1);
        board.placeMarkAt(CELL_1);
    }


    @Test public void
    inform_that_game_is_over_when_all_cells_are_marked() {
        machinePlayerWillMark(CELL_1, CELL_2, CELL_5, CELL_6, CELL_7);

        board.newGame();

        board.placeMarkAt(CELL_3);
        board.placeMarkAt(CELL_4);
        board.placeMarkAt(CELL_8);
        board.placeMarkAt(CELL_9);

        assertThat(board.gameIsOver(), is(true));
    }

    private void machinePlayerWillMark(Integer... cells){
        when(machinePlayer.nextCell(any(Marks.class)))
                .thenReturn(cells[0], copyOfRange(cells, 1, cells.length));
    }


}
