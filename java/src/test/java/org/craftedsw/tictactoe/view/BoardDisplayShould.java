package org.craftedsw.tictactoe.view;

import org.craftedsw.tictactoe.model.board.Marks;
import org.craftedsw.tictactoe.model.game.HumanPlayer;
import org.craftedsw.tictactoe.model.game.PlayerMark;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.craftedsw.tictactoe.builder.MarksBuilder.marks;
import static org.craftedsw.tictactoe.model.board.BoardStructure.*;
import static org.craftedsw.tictactoe.model.game.PlayerMark.CROSS;
import static org.craftedsw.tictactoe.model.game.PlayerMark.NOUGHT;
import static org.craftedsw.tictactoe.view.BoardDisplay.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class BoardDisplayShould {

    private static final PlayerMark NO_WINNER = null;
    private static final PlayerMark MACHINE_PLAYER_MARK = CROSS;
    private static final PlayerMark HUMAN_PLAYER_MARK = NOUGHT;

    @Mock private Console console;
    private final HumanPlayer humanPlayer = new HumanPlayer(console, NOUGHT);

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
