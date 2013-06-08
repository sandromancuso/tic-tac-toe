package org.craftedsw.tictactoe.strategy;

import org.craftedsw.tictactoe.*;

import static org.craftedsw.tictactoe.Board.NO_CELL;

public class DefenceStrategy implements Strategy {

    @Override
    public int nextCell(Player player, Marks marks) {
        int cell = NO_CELL;
        BoardLines boardLines = new BoardLines();
        Line loosingLine = boardLines.loosingLine(player.opponent(), marks.asArray());
        if (loosingLine != null) {
            cell = loosingLine.firstEmptyCell(marks.asArray());
        }
        System.out.println("Defence "+ player + " [" + cell + "]");
        return cell;
    }
}
