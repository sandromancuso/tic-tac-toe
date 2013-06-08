package org.craftedsw.tictactoe.strategy;

import org.craftedsw.tictactoe.*;

import static org.craftedsw.tictactoe.Board.NO_CELL;

public class WinStrategy implements Strategy {

    private final BoardLines boardLines;

    public WinStrategy() {
        this.boardLines = new BoardLines();
    }

    @Override
    public int nextCell(Player player, Marks marks) {
        int cell = NO_CELL;
        Line winningLine = boardLines.winningLine(player, marks.asArray());
        if (winningLine != null) {
            cell =  winningLine.firstEmptyCell(marks.asArray());
        }
        System.out.println("Win "+ player + " [" + cell + "]");
        return cell;
    }
}
