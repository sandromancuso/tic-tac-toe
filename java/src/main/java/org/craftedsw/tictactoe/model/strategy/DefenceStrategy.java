package org.craftedsw.tictactoe.model.strategy;

import org.craftedsw.tictactoe.model.board.BoardLines;
import org.craftedsw.tictactoe.model.board.Line;
import org.craftedsw.tictactoe.model.board.Marks;
import org.craftedsw.tictactoe.model.game.Player;

import static org.craftedsw.tictactoe.model.board.Board.NO_CELL;

public class DefenceStrategy implements Strategy {

    @Override
    public int nextCell(Player player, Marks marks) {
        int cell = NO_CELL;
        BoardLines boardLines = new BoardLines();
        Line loosingLine = boardLines.loosingLine(player.opponent(), marks);
        if (loosingLine != null) {
            cell = loosingLine.firstEmptyCell(marks);
        }
        System.out.println("Defence "+ player + " [" + cell + "]");
        return cell;
    }
}
