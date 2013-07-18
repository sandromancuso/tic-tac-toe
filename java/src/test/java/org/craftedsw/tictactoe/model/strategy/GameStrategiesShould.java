package org.craftedsw.tictactoe.model.strategy;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static java.util.Arrays.asList;
import static org.craftedsw.tictactoe.model.game.PlayerMark.CROSS;
import static org.craftedsw.tictactoe.model.game.PlayerMark.NOUGHT;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.core.Is.is;

public class GameStrategiesShould {

    private List<Class> expectedCrossStrategies = new ArrayList<Class>(
                                asList(
                                        WinStrategy.class,
                                        StraightDefenceStrategy.class,
                                        CornerAttackStrategy.class,
                                        SimpleAttackStrategy.class,
                                        FirstEmptyCellStrategy.class));

    private List<Class> expectedNoughtStrategies = new ArrayList<Class>(
                                asList(
                                        CentralCellStrategy.class,
                                        WinStrategy.class,
                                        StraightDefenceStrategy.class,
                                        BlockingForkStrategy.class,
                                        CornerAttackStrategy.class,
                                        SimpleAttackStrategy.class,
                                        FirstEmptyCellStrategy.class));

    @Test public void
    contain_strategies_in_a_specific_order_for_CROSS_player() {
        assertStrategiesMatch(crossPlayerStrategies(), expectedCrossStrategies);
    }

    @Test public void
    contain_strategies_in_a_specific_order_for_NOUGHT_player() {
        assertStrategiesMatch(noughtPlayerStrategies(), expectedNoughtStrategies);
    }

    private void assertStrategiesMatch(GameStrategies gameStrategies, List<Class> expectedStrategies) {
        Iterator<Strategy> strategies = gameStrategies.iterator();
        for (int cnt = 0; strategies.hasNext(); cnt++) {
            assertThat(strategies.next(), is(instanceOf(expectedStrategies.get(cnt))));
        }
        assertThat(gameStrategies.size(), is(expectedStrategies.size()));
    }

    private GameStrategies noughtPlayerStrategies() {
        return new GameStrategies(NOUGHT);
    }

    private GameStrategies crossPlayerStrategies() {
        return new GameStrategies(CROSS);
    }

}
