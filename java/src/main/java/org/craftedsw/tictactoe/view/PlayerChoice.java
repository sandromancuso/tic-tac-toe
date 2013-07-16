package org.craftedsw.tictactoe.view;

import org.craftedsw.tictactoe.model.game.HumanPlayer;
import org.craftedsw.tictactoe.model.game.MachinePlayer;
import org.craftedsw.tictactoe.model.game.Player;
import org.craftedsw.tictactoe.model.game.PlayerMark;
import org.craftedsw.tictactoe.model.strategy.GameStrategies;

import static org.craftedsw.tictactoe.model.game.PlayerMark.CROSS;
import static org.craftedsw.tictactoe.model.game.PlayerMark.NOUGHT;

public class PlayerChoice {

    private final PlayerMark humanPlayerMark;
    private final Console console;

    public PlayerChoice(PlayerMark humanPlayerMark, Console console) {
        this.humanPlayerMark = humanPlayerMark;
        this.console = console;
    }

    public Player crossPlayer() {
        return CROSS.equals(humanPlayerMark)
                        ? createHumanPlayer()
                        : createMachinePlayer();
    }

    public Player noughtPlayer() {
        return NOUGHT.equals(humanPlayerMark)
                        ? createHumanPlayer()
                        : createMachinePlayer();
    }

    private Player createMachinePlayer() {
        PlayerMark machineMark = humanPlayerMark.opponent();
        return new MachinePlayer(machineMark, new GameStrategies(machineMark));
    }

    private Player createHumanPlayer() {
        return new HumanPlayer(humanPlayerMark, console);
    }

}
