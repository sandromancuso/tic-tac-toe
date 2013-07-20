package org.craftedsw.tictactoe.model.strategy;

import org.craftedsw.tictactoe.model.board.BoardLines;
import org.craftedsw.tictactoe.model.board.Line;
import org.craftedsw.tictactoe.model.board.Marks;
import org.craftedsw.tictactoe.model.game.PlayerMark;

import static org.craftedsw.tictactoe.model.board.BoardStructure.NO_CELL;

public class BlockStrategy implements Strategy {

    @Override
    public int nextCell(PlayerMark playerMark, Marks marks) {
        Line loosingLine = loosingLineFor(playerMark, marks);
        if (loosingLine != null) {
            return loosingLine.firstEmptyCell(marks);
        }
        return NO_CELL;
    }

    private Line loosingLineFor(PlayerMark playerMark, Marks marks) {
        return new BoardLines().loosingLine(playerMark, marks);
    }
}
