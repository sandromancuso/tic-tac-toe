package org.craftedsw.tictactoe.model.game;

import org.junit.Test;

import static org.craftedsw.tictactoe.model.game.PlayerMark.CROSS;
import static org.craftedsw.tictactoe.model.game.PlayerMark.NOUGHT;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class PlayerShould {

    @Test public void
    return_player_mark_by_its_mark() {
        assertThat(PlayerMark.byMark("X"), is(CROSS));
        assertThat(PlayerMark.byMark("0"), is(NOUGHT));
        assertThat(PlayerMark.byMark("A"), is(nullValue()));
    }

    @Test public void
    should_return_her_opponent() {
        assertThat(CROSS.opponent(), is(NOUGHT));
        assertThat(NOUGHT.opponent(), is(CROSS));
    }

}
