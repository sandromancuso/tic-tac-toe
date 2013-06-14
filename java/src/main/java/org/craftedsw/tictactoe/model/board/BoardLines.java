package org.craftedsw.tictactoe.model.board;

import org.craftedsw.tictactoe.model.game.Player;

import java.util.ArrayList;
import java.util.List;

public class BoardLines {

    private List<Line> boardLines = new ArrayList<Line>();

    public BoardLines() {
        add(BoardStructure.ROW_1, BoardStructure.ROW_2, BoardStructure.ROW_3, BoardStructure.COLUMN_1, BoardStructure.COLUMN_2, BoardStructure.COLUMN_3, BoardStructure.DIAGONAL_1, BoardStructure.DIAGONAL_2);
    }

    private void add(Line... lines) {
        for (Line line : lines) {
            boardLines.add(line);
        }
    }

    public boolean hasWinnerLine(Marks marks) {
        for (Line line : boardLines) {
            if (line.isWinner(marks)) {
                return true;
            }
        }
        return false;
    }


    public Line winningLine(Player player, Marks marks) {
        for (Line line : boardLines) {
            if (line.isWinningLine(player, marks)) {
                return line;
            }
        }
        return null;
    }


    public Line loosingLine(Player opponent, Marks marks) {
        for (Line line : boardLines) {
            if (line.isLoosingLine(opponent, marks)) {
                return line;
            }
        }
        return null;
    }
}
