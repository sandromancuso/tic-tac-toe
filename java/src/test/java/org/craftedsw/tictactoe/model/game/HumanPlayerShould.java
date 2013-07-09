package org.craftedsw.tictactoe.model.game;

import org.craftedsw.tictactoe.model.board.Marks;
import org.craftedsw.tictactoe.view.BoardDisplay;
import org.craftedsw.tictactoe.view.Console;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.craftedsw.tictactoe.model.board.BoardStructure.CELL_3;
import static org.craftedsw.tictactoe.model.game.Player.PLAYER_TWO;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class HumanPlayerShould {

    @Mock private Console console;
    @Mock private Marks marks;

    @Test public void
    place_a_mark() {
        HumanPlayer player = new HumanPlayer(console, PLAYER_TWO);
        when(console.ask(BoardDisplay.ASK_FOR_NEXT_MARK)).thenReturn(3);

        player.placeMark(marks);

        verify(marks).placeMarkAt(CELL_3, PLAYER_TWO.mark());
    }

}
