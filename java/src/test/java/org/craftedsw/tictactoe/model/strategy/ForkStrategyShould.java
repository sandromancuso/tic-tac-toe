package org.craftedsw.tictactoe.model.strategy;

import org.craftedsw.tictactoe.model.board.Marks;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;

import static org.craftedsw.tictactoe.model.board.BoardStructure.*;
import static org.craftedsw.tictactoe.model.game.PlayerMark.NOUGHT;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class ForkStrategyShould {

    @Parameterized.Parameters(name = "{index}: mark should be at cell {1} (0 based)")
    public static Iterable<Object[]> marks() {
        return Arrays.asList(new Object[][]{
                {new String[]{"X", " ", " ", " ", "0", " ", " ", " ", " "}, CELL_9},
                {new String[]{" ", " ", " ", " ", "0", " ", " ", " ", "X"}, CELL_1},
                {new String[]{" ", " ", "X", " ", "0", " ", " ", " ", " "}, CELL_7},
                {new String[]{" ", " ", " ", " ", "0", " ", "X", " ", " "}, CELL_3},
                {new String[]{"X", " ", " ", " ", "0", " ", " ", " ", "0"}, NO_CELL}
        });
    }

    private ForkStrategy forkStrategy = new ForkStrategy();

    private final int cellToBeMarked;
    private final Marks marks;

    public ForkStrategyShould(String[] marks, int cellToBeMarked) {
        this.marks = new Marks(marks);
        this.cellToBeMarked = cellToBeMarked;
    }

    @Test
    public void
    attempt_to_fork() {
        assertThat(forkStrategy.nextCell(NOUGHT, marks), is(cellToBeMarked));
    }

}
