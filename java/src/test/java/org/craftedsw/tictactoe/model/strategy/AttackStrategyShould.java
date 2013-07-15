package org.craftedsw.tictactoe.model.strategy;

import org.craftedsw.tictactoe.model.board.Marks;
import org.hamcrest.core.Is;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;

import static org.craftedsw.tictactoe.model.board.BoardStructure.*;
import static org.craftedsw.tictactoe.model.game.PlayerMark.CROSS;
import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class AttackStrategyShould {

    @Parameterized.Parameters(name = "{index}: Corner mark should be {1}")
    public static Iterable<Object[]> marks() {
        return Arrays.asList(new Object[][]{
                {new String[]{"X", "0", " ", " ", " ", " ", " ", " ", " "}, CELL_9},
                {new String[]{" ", " ", "X", "0", " ", " ", " ", " ", " "}, CELL_7},
                {new String[]{" ", " ", " ", " ", " ", " ", "X", "0", " "}, CELL_3},
                {new String[]{" ", " ", " ", " ", " ", " ", " ", " ", "X"}, CELL_1},
                {new String[]{"0", " ", "X", " ", " ", " ", " ", " ", " "}, CELL_7},
                {new String[]{"X", " ", " ", " ", " ", " ", " ", " ", "0"}, CELL_3},
                {new String[]{" ", " ", "X", " ", " ", " ", "0", " ", " "}, CELL_1},
                {new String[]{"X", "0", "0", " ", " ", "X", " ", " ", "0"}, CELL_7},
                {new String[]{"X", "0", "0", " ", " ", "X", "0", " ", "0"}, NO_CELL}
        });
    }

    private AttackStrategy attackStrategy;

    @Before
    public void initialise() {
        attackStrategy = new AttackStrategy();
    }

    private final int cellToBeMarked;
    private final Marks marks;

    public AttackStrategyShould(String[] marks, int cellToBeMarked) {
        this.marks = new Marks(marks);
        this.cellToBeMarked = cellToBeMarked;
    }

    @Test public void
    should_choose_opposite_corner_if_there_is_only_one_mark_in_a_corner() {
        assertThat(attackStrategy.nextCell(CROSS, marks), Is.is(cellToBeMarked));
    }
}
