package org.craftedsw.tictactoe.model.strategy;

import org.craftedsw.tictactoe.model.board.BoardLines;
import org.craftedsw.tictactoe.model.board.Line;
import org.craftedsw.tictactoe.model.board.Marks;
import org.craftedsw.tictactoe.model.game.PlayerMark;

import static org.craftedsw.tictactoe.model.board.BoardStructure.NO_CELL;

public class StraightDefenceStrategy implements Strategy {

    @Override
    public int nextCell(PlayerMark playerMark, Marks marks) {
        int cell = NO_CELL;
        BoardLines boardLines = new BoardLines();
        Line loosingLine = boardLines.loosingLine(playerMark, marks);
        if (loosingLine != null) {
            cell = loosingLine.firstEmptyCell(marks);
        }
        return cell;
    }
}
