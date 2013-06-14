package org.craftedsw.tictactoe.model.strategy;

import org.craftedsw.tictactoe.model.board.Marks;
import org.craftedsw.tictactoe.model.game.Player;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;

import static org.craftedsw.tictactoe.model.board.Board.*;
import static org.craftedsw.tictactoe.model.game.Player.PLAYER_ONE;
import static org.craftedsw.tictactoe.model.game.Player.PLAYER_TWO;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class WinStrategyShould {

    @Parameters(name = "{index}: Winning mark should be {1}")
    public static Iterable<Object[]> marks() {
        return Arrays.asList(new Object[][]{
                {new String[]{"X", "X", " ", "0", " ", "0", " ", " ", " "}, PLAYER_ONE, CELL_3},
                {new String[]{"0", "0", " ", "X", "X", " ", " ", "X", " "}, PLAYER_TWO, CELL_3},
                {new String[]{"0", "0", " ", "X", " ", "X", " ", " ", " "}, PLAYER_ONE, CELL_5},
                {new String[]{" ", " ", "X", "0", " ", "0", "X", "X", " "}, PLAYER_TWO, CELL_5},
                {new String[]{"0", " ", " ", "0", " ", " ", " ", "X", "X"}, PLAYER_ONE, CELL_7},
                {new String[]{" ", " ", " ", " ", " ", " ", " ", "0", "0"}, PLAYER_TWO, CELL_7},
                {new String[]{"X", " ", " ", " ", " ", " ", " ", " ", "X"}, PLAYER_ONE, CELL_5},
                {new String[]{"0", "X", "X", "X", "0", " ", " ", " ", " "}, PLAYER_TWO, CELL_9},
                {new String[]{" ", "0", " ", " ", "X", " ", "X", "0", " "}, PLAYER_ONE, CELL_3},
                {new String[]{" ", " ", "0", "X", "0", " ", " ", "X", "X"}, PLAYER_TWO, CELL_7},
                {new String[]{" ", "0", "0", "X", " ", " ", "X", " ", " "}, PLAYER_ONE, CELL_1},
                {new String[]{"0", " ", " ", " ", "X", "X", "0", "X", " "}, PLAYER_TWO, CELL_4},
                {new String[]{"0", "0", " ", "X", "X", " ", "X", "0", "X"}, PLAYER_ONE, CELL_6},
                {new String[]{"0", " ", "X", " ", "X", " ", "0", " ", "X"}, PLAYER_TWO, CELL_4}
        });
    }

    private final int cellToBeMarked;
    private final Player player;
    private final Marks marks;

    public WinStrategyShould(String[] marks, Player player, int cellToBeMarked) {
        this.marks = new Marks(marks);
        this.player = player;
        this.cellToBeMarked = cellToBeMarked;
    }

    @Test public void
    should_return_the_winning_cell_to_be_marked() {
        WinStrategy markStrategy = new WinStrategy();

        assertThat(markStrategy.nextCell(player, marks), is(cellToBeMarked));
    }

}
