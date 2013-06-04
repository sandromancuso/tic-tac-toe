package org.craftedsw.tictactoe.strategy;

import org.craftedsw.tictactoe.Player;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;

import static org.craftedsw.tictactoe.Board.*;
import static org.craftedsw.tictactoe.Board.CELL_4;
import static org.craftedsw.tictactoe.Player.PLAYER_ONE;
import static org.craftedsw.tictactoe.Player.PLAYER_TWO;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

@RunWith(Parameterized.class)
public class DefenceStrategyShould {

    @Parameterized.Parameters(name = "{index}: Winning mark should be {1}")
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
                {new String[]{"X", "X", " ", "0", "0", " ", "0", "X", "0"}, PLAYER_ONE, CELL_3}
        });
    }

    private final int cellToBeMarked;
    private final Player opponent;
    private final String[] marks;

    public DefenceStrategyShould(String[] marks, Player player, int cellToBeMarked) {
        this.marks = marks;
        this.opponent = player;
        this.cellToBeMarked = cellToBeMarked;
    }

    @Test
    public void
    should_return_the_winning_cell_to_be_marked() {
        MarkStrategy markStrategy = new MarkStrategy();

        assertThat(markStrategy.defenceMark(opponent, marks), is(cellToBeMarked));
    }


}
