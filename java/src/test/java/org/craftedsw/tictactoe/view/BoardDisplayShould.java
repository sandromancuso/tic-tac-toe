package org.craftedsw.tictactoe.view;

import org.craftedsw.tictactoe.model.board.Marks;
import org.craftedsw.tictactoe.model.game.PlayerMark;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.craftedsw.tictactoe.builder.MarksBuilder.emptyMarks;
import static org.craftedsw.tictactoe.builder.MarksBuilder.marks;
import static org.craftedsw.tictactoe.model.board.BoardStructure.*;
import static org.craftedsw.tictactoe.model.game.PlayerMark.CROSS;
import static org.craftedsw.tictactoe.model.game.PlayerMark.NOUGHT;
import static org.craftedsw.tictactoe.view.BoardDisplay.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class BoardDisplayShould {

    private static final PlayerMark NO_WINNER = null;

    @Mock private Console console;

    private BoardDisplay boardDisplay;

    @Before
    public void initialise() {
        boardDisplay = new BoardDisplay(console);
    }

    @Test public void
    display_instructions() {
        String emptyBoard =
                "   |   |   " + '\n' +
                "---+---+---" + '\n' +
                "   |   |   " + '\n' +
                "---+---+---" + '\n' +
                "   |   |   ";

        boardDisplay.displayGameInstructions(emptyMarks());

        verify(console).print(CELL_INDEX_INSTRUCTIONS);
        verify(console).print(CURRENT_BOARD_STATE_MESSAGE);
        verify(console).print(emptyBoard);
    }

    @Test public void
    display_marks_on_the_board() {
        Marks marks = marks()
                        .fromPlayerOneAt(CELL_1, CELL_3)
                        .fromPlayerTwoAt(CELL_2, CELL_9)
                        .build();

        boardDisplay.displayBoardWith(marks);

        verify(console).print(
                " X | 0 | X " + '\n' +
                "---+---+---" + '\n' +
                "   |   |   " + '\n' +
                "---+---+---" + '\n' +
                "   |   | 0 "
        );
    }

    @Test public void
    display_a_players_turn() {
        boardDisplay.nextPlayerIs(CROSS);

        verify(console).print(NEXT_PLAYER_IS + CROSS);
    }

    @Test public void
    inform_it_was_a_draw() {
        boardDisplay.displayGameResult(NO_WINNER);

        verify(console).print(DRAW_MESSAGE);
    }

    @Test public void
    inform_that_human_player_has_won() {
        PlayerMark WINNER = NOUGHT;

        boardDisplay.displayGameResult(WINNER);

        verify(console).print("NOUGHT wins!!!");
    }

}
