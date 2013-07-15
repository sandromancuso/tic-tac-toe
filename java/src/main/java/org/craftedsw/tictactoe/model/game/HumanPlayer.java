package org.craftedsw.tictactoe.model.game;

import org.craftedsw.tictactoe.model.board.Marks;
import org.craftedsw.tictactoe.view.Console;

public class HumanPlayer implements Player {

    public static final String ASK_FOR_NEXT_MARK = "Choose an empty cell between 1 and 9  >>> ";

    private Console console;
    private PlayerMark playerMark;

    public HumanPlayer(PlayerMark playerMark, Console console) {
        this.console = console;
        this.playerMark = playerMark;
    }

    @Override
    public void placeMarkOn(Marks marks) {
        try {
            int cell = console.ask(ASK_FOR_NEXT_MARK);
            marks.placeMarkAt(cell - 1, playerMark.mark());
        } catch (Exception e) {
            placeMarkOn(marks);
        }
    }

    @Override
    public PlayerMark mark() {
        return playerMark;
    }
}
