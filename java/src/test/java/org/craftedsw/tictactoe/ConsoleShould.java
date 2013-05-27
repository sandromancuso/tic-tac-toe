package org.craftedsw.tictactoe;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class ConsoleShould {

    private String textPrinted;

    @Test public void
    should_print_text() {
        Console console = new Console();

        console.print("SOME TEXT");

        assertThat(textPrinted, is("SOME TEXT"));
    }

}
