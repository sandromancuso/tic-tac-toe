package org.craftedsw.tictactoe.model.strategy;

import org.craftedsw.tictactoe.model.board.Marks;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;

import static org.craftedsw.tictactoe.model.board.BoardStructure.*;
import static org.craftedsw.tictactoe.model.game.PlayerMark.NOUGHT;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

@RunWith(Parameterized.class)
public class SimpleAttackStrategyShould {

    @Parameterized.Parameters(name = "{index}: mark should be on cell {1} (0 based)")
    public static Iterable<Object[]> marks() {
        return Arrays.asList(new Object[][]{
                {new String[]{"X", " ", " ", " ", "0", " ", " ", "X", " "}, CELL_3},
                {new String[]{" ", "X", " ", " ", "0", " ", " ", " ", "X"}, CELL_3},
                {new String[]{" ", "X", " ", " ", "0", " ", "X", "0", "X"}, CELL_4},
                {new String[]{"X", " ", "0", " ", "0", "X", "X", "X", "0"}, NO_CELL}
        });
    }

    private SimpleAttackStrategy simpleAttackStrategy;

    @Before
    public void initialise() {
        simpleAttackStrategy = new SimpleAttackStrategy();
    }

    private final int cellToBeMarked;
    private final Marks marks;

    public SimpleAttackStrategyShould(String[] marks, int cellToBeMarked) {
        this.marks = new Marks(marks);
        this.cellToBeMarked = cellToBeMarked;
    }

    @Test
    public void
    make_simple_attack() {
        assertThat(simpleAttackStrategy.nextCell(NOUGHT, marks), is(cellToBeMarked));
    }
}
