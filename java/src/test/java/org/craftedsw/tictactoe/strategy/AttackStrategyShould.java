package org.craftedsw.tictactoe.strategy;

import org.craftedsw.tictactoe.Marks;
import org.junit.Before;
import org.junit.Test;

import static org.craftedsw.tictactoe.Board.CELL_1;
import static org.craftedsw.tictactoe.Board.CELL_9;
import static org.craftedsw.tictactoe.Player.PLAYER_ONE;
import static org.craftedsw.tictactoe.Player.PLAYER_TWO;
import static org.craftedsw.tictactoe.builder.MarksBuilder.marks;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class AttackStrategyShould {

    private AttackStrategy attackStrategy;

    @Before
    public void initialise() {
        attackStrategy = new AttackStrategy();
    }

    @Test public void
    should_choose_top_corner_if_board_is_empty() {
        Marks marks = marks().build();

        int cell = attackStrategy.nextCell(PLAYER_ONE, marks);

        assertThat(cell, is(CELL_1));
    }

    @Test public void
    should_choose_opposite_corner_if_there_is_only_one_mark_in_a_corner() {
        Marks marks = new Marks(marks().fromPlayerOneAt(CELL_1).buildAsArray());

        int cell = attackStrategy.nextCell(PLAYER_TWO, marks);

        assertThat(cell, is(CELL_9));
    }
}
