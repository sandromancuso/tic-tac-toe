package org.craftedsw.tictactoe.strategy;

import org.craftedsw.tictactoe.Marks;
import org.craftedsw.tictactoe.Player;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;

import static org.craftedsw.tictactoe.Board.*;
import static org.craftedsw.tictactoe.Board.CELL_4;
import static org.craftedsw.tictactoe.Board.CELL_6;
import static org.craftedsw.tictactoe.Player.PLAYER_ONE;
import static org.craftedsw.tictactoe.Player.PLAYER_TWO;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

@RunWith(Parameterized.class)
public class CornerStrategyShould {

    @Parameterized.Parameters(name = "{index}: Corner mark should be {1}")
    public static Iterable<Object[]> marks() {
        return Arrays.asList(new Object[][]{
                {new String[]{"X", " ", " ", " ", " ", " ", " ", " ", " "}, PLAYER_TWO, CELL_9},
                {new String[]{" ", " ", "X", " ", " ", " ", " ", " ", " "}, PLAYER_TWO, CELL_7},
                {new String[]{" ", " ", " ", " ", " ", " ", "X", " ", " "}, PLAYER_TWO, CELL_3},
                {new String[]{" ", " ", " ", " ", " ", " ", " ", " ", "X"}, PLAYER_TWO, CELL_1},
                {new String[]{"0", " ", " ", " ", " ", " ", " ", " ", " "}, PLAYER_ONE, CELL_9},
                {new String[]{" ", " ", "0", " ", " ", " ", " ", " ", " "}, PLAYER_ONE, CELL_7},
                {new String[]{" ", " ", " ", " ", " ", " ", "0", " ", " "}, PLAYER_ONE, CELL_3},
                {new String[]{" ", " ", " ", " ", " ", " ", " ", " ", "0"}, PLAYER_ONE, CELL_1}
        });
    }

    private final int cellToBeMarked;
    private final Player player;
    private final Marks marks;

    public CornerStrategyShould(String[] marks, Player player, int cellToBeMarked) {
        this.marks = new Marks(marks);
        this.player = player;
        this.cellToBeMarked = cellToBeMarked;
    }

    @Test
    public void
    should_return_the_winning_cell_to_be_marked() {
        CornerMarkStrategy strategy = new CornerMarkStrategy();

        assertThat(strategy.nextCell(player, marks), is(cellToBeMarked));
    }

}
