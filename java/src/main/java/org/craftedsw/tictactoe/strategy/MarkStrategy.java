package org.craftedsw.tictactoe.strategy;

import org.craftedsw.tictactoe.BoardLines;
import org.craftedsw.tictactoe.Line;
import org.craftedsw.tictactoe.Player;

public class MarkStrategy {

    public static final int NONE = -1;
    private BoardLines boardLines = new BoardLines();

//    public int winMark(Player player, String[] marks) {
//        Line winningLine = boardLines.winningLine(player, marks);
//        if (winningLine != null) {
//            return winningLine.firstEmptyCell(marks);
//        }
//        return NONE;
//    }

    public int defenceMark(Player opponent, String[] marks) {
        Line loosingLine = boardLines.loosingLine(opponent, marks);
        if (loosingLine != null) {
            return loosingLine.firstEmptyCell(marks);
        }
        return NONE;
    }

}
