package org.craftedsw.tictactoe.model.strategy;

import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.core.Is.is;

public class InvincibleStrategiesShould {

    private InvincibleStrategies invincibleStrategies = new InvincibleStrategies();

    private Class[] strategies = new Class[] {
            WinStrategy.class,
            DefenceStrategy.class,
            CornerMarkStrategy.class,
            FirstEmptyCellStrategy.class
    };

    @Test public void
    should_contain_strategies_in_a_specific_order() {
        Strategy strategy;
        int strategyIndex = 0;
        Iterator<Strategy> strategiesIterator = invincibleStrategies.iterator();
        while (strategiesIterator.hasNext()) {
            strategy = strategiesIterator.next();
            assertThat(strategy, is(instanceOf(strategies[strategyIndex])));
            strategyIndex++;
        }
        assertThat(strategyIndex, is(strategies.length));
    }

}
