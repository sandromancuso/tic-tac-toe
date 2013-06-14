package org.craftedsw.tictactoe.model.strategy;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GameStrategies implements Iterable<Strategy> {

    private List<Strategy> strategies = new ArrayList<Strategy>();

    public GameStrategies() {
        strategies.add(new WinStrategy());
        strategies.add(new DefenceStrategy());
        strategies.add(new CornerMarkStrategy());
        strategies.add(new FirstEmptyCellStrategy());
    }

    @Override
    public Iterator<Strategy> iterator() {
        return strategies.iterator();
    }
}
