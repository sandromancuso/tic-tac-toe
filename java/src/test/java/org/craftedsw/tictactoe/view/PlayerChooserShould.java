package org.craftedsw.tictactoe.view;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.craftedsw.tictactoe.view.PlayerChooser.WHICH_PLAYER_DO_YOU_WANT_TO_BE;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class PlayerChooserShould {

    @Mock private Console console;

    private PlayerChooser playerChooser;

    @Before
    public void initialise() {
        playerChooser = new PlayerChooser(console);
    }

    @Test public void
    ask_user_which_player_she_wants_to_be() {
        when(console.getStringAnswerFor(WHICH_PLAYER_DO_YOU_WANT_TO_BE)).thenReturn("X");

        playerChooser.choose();

        verify(console).getStringAnswerFor(WHICH_PLAYER_DO_YOU_WANT_TO_BE);
    }

    @Test public void
    keep_asking_user_which_player_she_wants_to_be_until_answer_is_X() {
        when(console.getStringAnswerFor(WHICH_PLAYER_DO_YOU_WANT_TO_BE)).thenReturn("a", "b", "X");

        PlayerChoice playerChoice = playerChooser.choose();

        verify(console, times(3)).getStringAnswerFor(WHICH_PLAYER_DO_YOU_WANT_TO_BE);
        assertThat(playerChoice, is(notNullValue()));
    }

}
