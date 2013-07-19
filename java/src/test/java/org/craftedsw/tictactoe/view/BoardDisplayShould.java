package org.craftedsw.tictactoe.view;

import org.craftedsw.tictactoe.model.board.Marks;
import org.craftedsw.tictactoe.model.game.PlayerMark;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;
import static org.craftedsw.tictactoe.builder.MarksBuilder.emptyMarks;
import static org.craftedsw.tictactoe.builder.MarksBuilder.marks;
import static org.craftedsw.tictactoe.model.board.BoardStructure.*;
import static org.craftedsw.tictactoe.model.game.PlayerMark.CROSS;
import static org.craftedsw.tictactoe.model.game.PlayerMark.NOUGHT;
import static org.craftedsw.tictactoe.view.BoardDisplay.*;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class BoardDisplayShould {

    private static final PlayerMark NO_WINNER = null;

    private List<String> printedLines;
    private Console console;

    private BoardDisplay boardDisplay;

    @Before
    public void initialise() {
        printedLines = new ArrayList<String>();
        console = createConsole();
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

        assertThat(printedLines, hasItems(
                                          CELL_INDEX_INSTRUCTIONS,
                                          CURRENT_BOARD_STATE_MESSAGE,
                                          emptyBoard));
    }

    @Test public void
    display_marks_on_the_board() {
        Marks marks = marks()
                            .fromPlayerOneAt(CELL_1, CELL_3)
                            .fromPlayerTwoAt(CELL_2, CELL_9).build();

        boardDisplay.displayBoardWith(marks);

        assertThat(printedLines, hasItems(
                                            " X | 0 | X " + '\n' +
                                            "---+---+---" + '\n' +
                                            "   |   |   " + '\n' +
                                            "---+---+---" + '\n' +
                                            "   |   | 0 "));
    }

    @Test public void
    display_a_players_turn() {
        boardDisplay.nextPlayerIs(CROSS);

        assertThat(printedLines, hasItem(NEXT_PLAYER_IS + CROSS));
    }

    @Test public void
    inform_it_was_a_draw() {
        boardDisplay.displayGameResult(NO_WINNER);

        assertThat(printedLines, hasItem(DRAW_MESSAGE));
    }

    @Test public void
    inform_that_human_player_has_won() {
        PlayerMark WINNER = NOUGHT;

        boardDisplay.displayGameResult(WINNER);

        assertThat(printedLines, hasItem("NOUGHT wins!!!"));
    }

    private Console createConsole() {

        return new Console() {
            @Override
            public void printLines(String... lines) {
                printedLines.addAll(asList(lines));
            }
        };
    }

}
