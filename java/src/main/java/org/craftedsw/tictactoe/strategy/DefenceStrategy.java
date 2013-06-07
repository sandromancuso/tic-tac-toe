package org.craftedsw.tictactoe.strategy;

import org.craftedsw.tictactoe.*;

import static org.craftedsw.tictactoe.Board.NO_CELL;

public class DefenceStrategy implements Strategy {

    @Override
    public int nextCell(Player player, Marks marks) {
        BoardLines boardLines = new BoardLines();
        Line loosingLine = boardLines.loosingLine(player.opponent(), marks.asArray());
        if (loosingLine != null) {
            return loosingLine.firstEmptyCell(marks.asArray());
        }
        return NO_CELL;
    }
}
