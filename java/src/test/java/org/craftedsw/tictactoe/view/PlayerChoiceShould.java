package org.craftedsw.tictactoe.view;

import org.craftedsw.tictactoe.model.game.HumanPlayer;
import org.craftedsw.tictactoe.model.game.MachinePlayer;
import org.craftedsw.tictactoe.model.game.Player;
import org.craftedsw.tictactoe.model.game.PlayerMark;
import org.junit.Test;

import static org.craftedsw.tictactoe.model.game.PlayerMark.CROSS;
import static org.craftedsw.tictactoe.model.game.PlayerMark.NOUGHT;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsInstanceOf.instanceOf;
import static org.junit.Assert.*;

public class PlayerChoiceShould {

    private Console console = new Console();

    @Test public void
    create_human_player_as_cross_player() {
        PlayerChoice playerChoice = new PlayerChoice(CROSS, console);

        Player crossPlayer = playerChoice.crossPlayer();

        assertThat(crossPlayer, is(instanceOf(HumanPlayer.class)));
        assertThat(crossPlayer.mark(), is(CROSS));
    }

    @Test public void
    create_machine_player_as_nought_player() {
        PlayerChoice playerChoice = new PlayerChoice(CROSS, console);

        Player crossPlayer = playerChoice.noughtPlayer();

        assertThat(crossPlayer, is(instanceOf(MachinePlayer.class)));
        assertThat(crossPlayer.mark(), is(NOUGHT));
    }

    @Test public void
    create_human_player_as_nought_player() {
        PlayerChoice playerChoice = new PlayerChoice(NOUGHT, console);

        Player crossPlayer = playerChoice.noughtPlayer();

        assertThat(crossPlayer, is(instanceOf(HumanPlayer.class)));
        assertThat(crossPlayer.mark(), is(NOUGHT));
    }

    @Test public void
    create_machine_player_as_cross_player() {
        PlayerChoice playerChoice = new PlayerChoice(NOUGHT, console);

        Player crossPlayer = playerChoice.crossPlayer();

        assertThat(crossPlayer, is(instanceOf(MachinePlayer.class)));
        assertThat(crossPlayer.mark(), is(CROSS));
    }

}
