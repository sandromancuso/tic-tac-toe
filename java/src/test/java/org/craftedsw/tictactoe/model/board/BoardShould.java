package org.craftedsw.tictactoe.model.board;

import org.craftedsw.tictactoe.model.game.MachinePlayer;
import org.craftedsw.tictactoe.model.game.Player;
import org.craftedsw.tictactoe.view.BoardDisplay;
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
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class BoardShould {

    private Board board;
    @Mock private BoardDisplay boardDisplay;
    @Mock private MachinePlayer machinePlayer;
    private Player humanPlayer = PLAYER_TWO;


    @Before
    public void initialise() {
        board = new Board(boardDisplay, machinePlayer, humanPlayer);
        when(machinePlayer.mark()).thenReturn(PLAYER_ONE.mark());
    }

    @Test public void
    display_board_with_the_machine_player_mark_when_new_game_starts() {
        board.newGame();

        InOrder inOrder = Mockito.inOrder(boardDisplay, machinePlayer);

        inOrder.verify(machinePlayer).nextCell(any(Marks.class));
        inOrder.verify(boardDisplay).displayGameInstructions();
        inOrder.verify(boardDisplay).displayBoard(any(Marks.class));
    }

    @Test public void
    inform_game_is_not_over_when_there_is_no_winner_and_board_is_not_full() {
        machinePlayerWillMark(CELL_1, CELL_3);

        board.newGame();
        board.placeMarkAt(CELL_2);

        assertThat(board.gameIsOver(), is(false));
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

    @Test public void
    display_the_game_result() {
        Player WINNER = PLAYER_ONE;
        Player HUMAN_PLAYER = PLAYER_TWO;
        machinePlayerWillMark(CELL_1, CELL_2, CELL_3);

        board.newGame();
        board.placeMarkAt(CELL_4);
        board.placeMarkAt(CELL_5);

        board.displayGameResult();

        verify(boardDisplay).displayGameResult(WINNER, HUMAN_PLAYER);

    }

    private void machinePlayerWillMark(Integer... cells){
        when(machinePlayer.nextCell(any(Marks.class)))
                .thenReturn(cells[0], copyOfRange(cells, 1, cells.length));
    }


}
