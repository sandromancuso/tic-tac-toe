package org.craftedsw.tictactoe;

import org.junit.Test;

import static org.craftedsw.tictactoe.Player.PLAYER_ONE;
import static org.craftedsw.tictactoe.Player.PLAYER_TWO;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class PlayerShould {

    @Test public void
    should_return_her_opponent() {
        assertThat(PLAYER_ONE.opponent(), is(PLAYER_TWO));
        assertThat(PLAYER_TWO.opponent(), is(PLAYER_ONE));
    }
}
