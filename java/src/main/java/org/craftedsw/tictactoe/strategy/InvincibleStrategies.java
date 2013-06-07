package org.craftedsw.tictactoe.strategy;

import org.craftedsw.tictactoe.Player;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class InvincibleStrategies implements Iterable<Strategy> {

    private List<Strategy> strategies = new ArrayList<Strategy>();

    public InvincibleStrategies(Player player) {
        strategies.add(new WinStrategy());
        strategies.add(new DefenceStrategy());
        strategies.add(new CornerMarkStrategy(player));
        strategies.add(new FirstEmptyCellStrategy(player));
    }

    @Override
    public Iterator<Strategy> iterator() {
        return strategies.iterator();
    }
}
