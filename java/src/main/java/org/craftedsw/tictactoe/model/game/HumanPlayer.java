package org.craftedsw.tictactoe.model.game;

import org.craftedsw.tictactoe.model.board.Marks;
import org.craftedsw.tictactoe.view.Console;

public class HumanPlayer {

    public static final String ASK_FOR_NEXT_MARK = "Cell number for your next mark  >>> ";

    private Console console;
    private Player player;

    public HumanPlayer(Console console, Player player) {
        this.console = console;
        this.player = player;
    }

    public void placeMark(Marks marks) {
        int cell = console.ask(ASK_FOR_NEXT_MARK);
        marks.placeMarkAt(cell - 1, player.mark());
    }
}
