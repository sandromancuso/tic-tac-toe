package org.craftedsw.tictactoe.view;

import org.apache.commons.lang3.tuple.Pair;
import org.junit.Test;

import java.util.Map;

import static org.craftedsw.tictactoe.view.ViewModel.keyValue;
import static org.craftedsw.tictactoe.view.ViewModel.model;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ViewModelShould {

    private static final String PAGE_TITLE_KEY = "page_title";
    private static final String PAGE_TITLE_VALUE = "Tic Tac Toe";

    @Test public void
    should_create_a_key_value_pair() {
        Pair<String, String> pair = keyValue(PAGE_TITLE_KEY, PAGE_TITLE_VALUE);

        assertThat(pair.getLeft(), is(PAGE_TITLE_KEY));
        assertThat(pair.getRight(), is(PAGE_TITLE_VALUE));
    }

    @Test public void
    should_create_a_model_with_values_in_it() {
        Map<String, Object> model = model(keyValue(PAGE_TITLE_KEY, PAGE_TITLE_VALUE));

        assertThat(model.get(PAGE_TITLE_KEY).toString(), is(PAGE_TITLE_VALUE));
    }

}
