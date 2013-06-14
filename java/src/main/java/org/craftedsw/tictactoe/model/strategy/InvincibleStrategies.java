package org.craftedsw.tictactoe.model.strategy;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class InvincibleStrategies implements Iterable<Strategy> {

    private List<Strategy> strategies = new ArrayList<Strategy>();

    public InvincibleStrategies() {
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
