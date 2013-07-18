package org.craftedsw.tictactoe.model.strategy;

import org.craftedsw.tictactoe.model.board.BoardLines;
import org.craftedsw.tictactoe.model.board.Line;
import org.craftedsw.tictactoe.model.board.Marks;
import org.craftedsw.tictactoe.model.game.PlayerMark;

import static org.craftedsw.tictactoe.model.board.BoardStructure.NO_CELL;

public class WinStrategy implements Strategy {

    @Override
    public int nextCell(PlayerMark playerMark, Marks marks) {
        Line winningLine = winningLineFor(playerMark, marks);
        if (winningLine != null) {
            return  winningLine.firstEmptyCell(marks);
        }
        return NO_CELL;
    }

    private Line winningLineFor(PlayerMark playerMark, Marks marks) {
        return new BoardLines().winningLine(playerMark, marks);
    }
}
