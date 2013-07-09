package org.craftedsw.tictactoe.model.game;

import org.craftedsw.tictactoe.model.board.Marks;
import org.craftedsw.tictactoe.view.Console;

public class HumanPlayer implements Player {

    public static final String ASK_FOR_NEXT_MARK = "Cell number for your next mark  >>> ";

    private Console console;
    private PlayerMark playerMark;

    public HumanPlayer(Console console, PlayerMark playerMark) {
        this.console = console;
        this.playerMark = playerMark;
    }

    @Override
    public void placeMark(Marks marks) {
        int cell = console.ask(ASK_FOR_NEXT_MARK);
        marks.placeMarkAt(cell - 1, playerMark.mark());
    }
}
