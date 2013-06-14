package org.craftedsw.tictactoe.steps;

import cucumber.annotation.en.Given;
import cucumber.annotation.en.Then;
import cucumber.annotation.en.When;
import cucumber.table.DataTable;
import org.craftedsw.tictactoe.model.board.Board;
import org.craftedsw.tictactoe.model.board.Marks;
import org.craftedsw.tictactoe.model.game.Opponent;
import org.craftedsw.tictactoe.model.game.Player;
import org.craftedsw.tictactoe.model.game.TicTacToe;
import org.craftedsw.tictactoe.model.strategy.InvincibleStrategies;
import org.craftedsw.tictactoe.view.Console;

import java.util.List;
import java.util.concurrent.Callable;

import static com.jayway.awaitility.Awaitility.await;
import static org.craftedsw.tictactoe.model.game.Player.PLAYER_ONE;
import static org.craftedsw.tictactoe.model.game.TicTacToe.YOU_WIN;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

public class SinglePlayerSteps {

    private TicTacToe ticTacToe;
    private List<String> myMarks = null;
    private List<String> opponentMarks = null;
    private Thread gameThread;
    private String lastPrintedText;

    @Given("^I start a single player Tic Tac Toe game$")
    public void I_start_a_single_player_Tic_Tac_Toe_game() throws InterruptedException {
        ticTacToe = new TicTacToe(new InterceptableConsole(), new Board());
        startNewGame();
    }

    @When("^I place my marks on cells:$")
    public void I_place_my_marks_on_cells(DataTable marks) {
        this.myMarks = marks.getGherkinRows().get(0).getCells();
    }

    @When("^the game places its marks on cells:$")
    public void the_game_places_its_marks_on_cells(DataTable marks) {
        this.opponentMarks = marks.getGherkinRows().get(0).getCells();
    }

    @Then("^I win$")
    public void I_win() throws InterruptedException {
        gameThread.join();
        assertThat(lastPrintedText, is(YOU_WIN));
    }

    private void startNewGame() throws InterruptedException {
        gameThread = new Thread() {
            @Override
            public void run() {
                ticTacToe.newSinglePlayerGame(new FakeOpponent());
            }
        };
        gameThread.start();
    }

    private class InterceptableConsole extends Console {

        int index = 0;

        @Override
        public int ask(String question) {
            await().until(userPlacesAMark());
            return new Integer(myMarks.get(index++));
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
                return myMarks != null && opponentMarks != null;
            }
        };
    }

    private class FakeOpponent extends Opponent {

        public FakeOpponent() {
            this(PLAYER_ONE, new InvincibleStrategies());
        }

        public FakeOpponent(Player player, InvincibleStrategies strategies) {
            super(player, strategies);
        }

        int index = 0;

        @Override
        public int nextCell(Marks marks) {
            await().until(userPlacesAMark());
            return new Integer(opponentMarks.get(index++));
        }
    }

}
