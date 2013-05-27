package org.craftedsw.tictactoe.steps;

import cucumber.annotation.en.Given;
import cucumber.annotation.en.Then;
import cucumber.annotation.en.When;
import cucumber.table.DataTable;
import org.craftedsw.tictactoe.Board;
import org.craftedsw.tictactoe.Console;
import org.craftedsw.tictactoe.Player;
import org.craftedsw.tictactoe.TicTacToe;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

import static com.jayway.awaitility.Awaitility.await;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

public class TicTacToeSteps {

    public static final String BOARD_WITH_X_ON_CELL_3 =
                    "   |   | X " + "\n" +
                    "---+---+---" + "\n" +
                    "   |   |   " + "\n" +
                    "---+---+---" + "\n" +
                    "   |   |   ";

    private TicTacToe ticTacToe;

    private List<String> markPositions = null;
    private Thread gameThread;
    private String lastPrintedText;

    @Given("^a new Tic Tac Toe game starts$")
    public void a_new_Tic_Tac_Toe_game_starts() throws InterruptedException {
        ticTacToe = new TicTacToe(new InterceptableConsole(), new Board());
        startNewGame();
    }

    @When("^I place a mark on cell (\\d+)$")
    public void I_place_a_mark_on_cell(int cell) throws IOException, InterruptedException {
        this.markPositions = new ArrayList<String>();
        this.markPositions.add(String.valueOf(cell));

    }

    @Then("^my mark is displayed on the board$")
    public void my_mark_is_displayed_on_the_board() throws InterruptedException {
        ticTacToe.quit();
        gameThread.join();
        assertThat(ticTacToe.boardRepresentation(), containsString(BOARD_WITH_X_ON_CELL_3));
    }

    @When("^players place marks on the following cells:$")
    public void players_place_marks_on_the_following_cells(DataTable cells) {
        this.markPositions = cells.getGherkinRows().get(0).getCells();
    }

    @Then("^Player One wins$")
    public void Player_One_wins() throws InterruptedException {
        gameThread.join();
        assertThat(lastPrintedText, is("Winner is: " + Player.PLAYER_ONE));
    }

    private void startNewGame() throws InterruptedException {
        gameThread = new Thread() {
            @Override
            public void run() {
                ticTacToe.newGame();
            }
        };
        gameThread.start();
    }

    private class InterceptableConsole extends Console {

        int index = 0;

        @Override
        public int ask(String question) {
            await().until(userPlacesAMark());
            return new Integer(markPositions.get(index++));
        }

        @Override
        public void print(String text) {
            lastPrintedText = text;
        }
    }

    private Callable<Boolean> userPlacesAMark() {
        return new Callable<Boolean>() {
            @Override
            public Boolean call() throws Exception {
                return markPositions != null;
            }
        };
    }

}
