package org.craftedsw.tictactoe.view;

import org.craftedsw.tictactoe.model.board.Marks;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.craftedsw.tictactoe.builder.MarksBuilder.marks;
import static org.craftedsw.tictactoe.model.board.BoardStructure.*;
import static org.craftedsw.tictactoe.view.BoardDisplay.CELL_INDEX_INSTRUCTIONS;
import static org.craftedsw.tictactoe.view.BoardDisplay.CURRENT_BOARD_STATE_MESSAGE;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class BoardDisplayShould {

    @Mock
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

    @Test public void
    display_marks_on_the_board() {
        Marks marks = marks()
                        .fromPlayerOneAt(CELL_1, CELL_3)
                        .fromPlayerTwoAt(CELL_2, CELL_9)
                        .build();

        boardDisplay.displayBoard(marks);

        verify(console).print(
                " X | 0 | X " + '\n' +
                "---+---+---" + '\n' +
                "   |   |   " + '\n' +
                "---+---+---" + '\n' +
                "   |   | 0 "
        );
    }


}
