package org.craftedsw.tictactoe.model.strategy;

import org.craftedsw.tictactoe.model.board.Marks;
import org.craftedsw.tictactoe.model.game.PlayerMark;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;

import static org.craftedsw.tictactoe.model.board.BoardStructure.*;
import static org.craftedsw.tictactoe.model.game.PlayerMark.CROSS;
import static org.craftedsw.tictactoe.model.game.PlayerMark.NOUGHT;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import static org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class WinStrategyShould {

    @Parameters(name = "{index}: Winning mark should be {1}")
    public static Iterable<Object[]> marks() {
        return Arrays.asList(new Object[][]{
                {new String[]{"X", "X", " ", "0", " ", "0", " ", " ", " "}, CROSS,  CELL_3},
                {new String[]{"0", "0", " ", "X", "X", " ", " ", "X", " "}, NOUGHT, CELL_3},
                {new String[]{"0", "0", " ", "X", " ", "X", " ", " ", " "}, CROSS,  CELL_5},
                {new String[]{" ", " ", "X", "0", " ", "0", "X", "X", " "}, NOUGHT, CELL_5},
                {new String[]{"0", " ", " ", "0", " ", " ", " ", "X", "X"}, CROSS,  CELL_7},
                {new String[]{" ", " ", " ", " ", " ", " ", " ", "0", "0"}, NOUGHT, CELL_7},
                {new String[]{"X", " ", " ", " ", " ", " ", " ", " ", "X"}, CROSS,  CELL_5},
                {new String[]{"0", "X", "X", "X", "0", " ", " ", " ", " "}, NOUGHT, CELL_9},
                {new String[]{" ", "0", " ", " ", "X", " ", "X", "0", " "}, CROSS,  CELL_3},
                {new String[]{" ", " ", "0", "X", "0", " ", " ", "X", "X"}, NOUGHT, CELL_7},
                {new String[]{" ", "0", "0", "X", " ", " ", "X", " ", " "}, CROSS,  CELL_1},
                {new String[]{"0", " ", " ", " ", "X", "X", "0", "X", " "}, NOUGHT, CELL_4},
                {new String[]{"0", "0", " ", "X", "X", " ", "X", "0", "X"}, CROSS,  CELL_6},
                {new String[]{"0", " ", "X", " ", "X", " ", "0", " ", "X"}, NOUGHT, CELL_4}
        });
    }

    private final int cellToBeMarked;
    private final PlayerMark playerMark;
    private final Marks marks;

    public WinStrategyShould(String[] marks, PlayerMark playerMark, int cellToBeMarked) {
        this.marks = new Marks(marks);
        this.playerMark = playerMark;
        this.cellToBeMarked = cellToBeMarked;
    }

    @Test public void
    should_return_the_winning_cell_to_be_marked() {
        WinStrategy markStrategy = new WinStrategy();

        assertThat(markStrategy.nextCell(playerMark, marks), is(cellToBeMarked));
    }

}
