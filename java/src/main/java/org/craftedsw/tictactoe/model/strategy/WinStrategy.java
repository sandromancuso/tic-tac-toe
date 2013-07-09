package org.craftedsw.tictactoe.model.strategy;

import org.craftedsw.tictactoe.model.board.BoardLines;
import org.craftedsw.tictactoe.model.board.Line;
import org.craftedsw.tictactoe.model.board.Marks;
import org.craftedsw.tictactoe.model.game.PlayerMark;

import static org.craftedsw.tictactoe.model.board.BoardStructure.NO_CELL;

public class WinStrategy implements Strategy {

    private final BoardLines boardLines;

    public WinStrategy() {
        this.boardLines = new BoardLines();
    }

    @Override
    public int nextCell(PlayerMark playerMark, Marks marks) {
        int cell = NO_CELL;
        Line winningLine = boardLines.winningLine(playerMark, marks);
        if (winningLine != null) {
            cell =  winningLine.firstEmptyCell(marks);
        }
        return cell;
    }
}
