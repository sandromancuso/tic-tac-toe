package org.craftedsw.tictactoe.view;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import static org.craftedsw.tictactoe.view.BoardDisplay.CELL_INDEX_INSTRUCTIONS;
import static org.craftedsw.tictactoe.view.BoardDisplay.CURRENT_BOARD_STATE_MESSAGE;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class BoardDisplayShould {

    @MockitoAnnotations.Mock
    private Console console;

    private BoardDisplay boardDisplay;

    @Before
    public void initialise() {
        boardDisplay = new BoardDisplay(console);
    }

    @Test public void
    display_instructions() {
        boardDisplay.displayGameInstructions();

        verify(console).print(CELL_INDEX_INSTRUCTIONS);
        verify(console).print(CURRENT_BOARD_STATE_MESSAGE);
    }


}
