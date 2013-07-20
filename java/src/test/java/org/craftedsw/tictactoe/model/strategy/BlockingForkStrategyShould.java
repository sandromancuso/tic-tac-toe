package org.craftedsw.tictactoe.model.strategy;

import org.craftedsw.tictactoe.model.board.Marks;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;

import static org.craftedsw.tictactoe.model.board.BoardStructure.CELL_2;
import static org.craftedsw.tictactoe.model.board.BoardStructure.NO_CELL;
import static org.craftedsw.tictactoe.model.game.PlayerMark.NOUGHT;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class BlockingForkStrategyShould {

    @Parameterized.Parameters(name = "{index}: mark should be on cell {1} (0 based)")
    public static Iterable<Object[]> marks() {
        return Arrays.asList(new Object[][]{
                {new String[]{"X", " ", " ", " ", "0", " ", " ", " ", "X"}, CELL_2},
                {new String[]{" ", " ", "X", " ", "0", " ", "X", " ", " "}, CELL_2},
                {new String[]{" ", "X", " ", " ", " ", "0", "X", " ", " "}, NO_CELL},
                {new String[]{"X", " ", " ", " ", "0", " ", " ", "X", " "}, NO_CELL}
        });
    }

    private BlockingForkStrategy blockingForkStrategy = new BlockingForkStrategy();

    private final int cellToBeMarked;
    private final Marks marks;

    public BlockingForkStrategyShould(String[] marks, int cellToBeMarked) {
        this.marks = new Marks(marks);
        this.cellToBeMarked = cellToBeMarked;
    }

    @Test
    public void
    block_a_fork() {
        assertThat(blockingForkStrategy.nextCell(NOUGHT, marks), is(cellToBeMarked));
    }

}
