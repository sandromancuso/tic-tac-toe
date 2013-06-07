package org.craftedsw.tictactoe.strategy;

import org.craftedsw.tictactoe.*;

public class WinStrategy implements Strategy {

    private final BoardLines boardLines;

    public WinStrategy() {
        this.boardLines = new BoardLines();
    }

    @Override
    public int nextCell(Player player, Marks marks) {
        Line winningLine = boardLines.winningLine(player, marks.asArray());
        if (winningLine != null) {
            return winningLine.firstEmptyCell(marks.asArray());
        }
        return Board.NO_CELL;
    }
}
