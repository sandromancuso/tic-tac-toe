package org.craftedsw.tictactoe.model.strategy;

import org.craftedsw.tictactoe.model.game.PlayerMark;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.craftedsw.tictactoe.model.game.PlayerMark.NOUGHT;

public class GameStrategies implements Iterable<Strategy> {

    private List<Strategy> strategies = new ArrayList<Strategy>();

    public GameStrategies(PlayerMark playerMark) {
        createListOfStrategiesFor(playerMark);
    }

    @Override
    public Iterator<Strategy> iterator() {
        return strategies.iterator();
    }

    public int size() {
        return strategies.size();
    }

    private void createListOfStrategiesFor(PlayerMark playerMark) {
        if (NOUGHT.equals(playerMark)) {
            strategies.add(new CentralCellStrategy());
        }
        strategies.add(new WinStrategy());
        strategies.add(new StraightDefenceStrategy());
        strategies.add(new AttackStrategy());
        strategies.add(new FirstEmptyCellStrategy());
    }

}
