package org.craftedsw.tictactoe.model.board;

import org.craftedsw.tictactoe.model.game.PlayerMark;

import java.util.ArrayList;
import java.util.List;

import static org.craftedsw.tictactoe.model.board.BoardStructure.*;

public class BoardLines {

    Line[] LINES = new Line[] {ROW_1, ROW_2, ROW_3,
                                COLUMN_1, COLUMN_2, COLUMN_3,
                                DIAGONAL_1, DIAGONAL_2};

    public boolean hasWinnerLine(Marks marks) {
        for (Line line : LINES) {
            if (line.isWinner(marks)) {
                return true;
            }
        }
        return false;
    }

    public Line winningLine(PlayerMark playerMark, Marks marks) {
        for (Line line : LINES) {
            if (line.isWinningLine(playerMark, marks)) {
                return line;
            }
        }
        return null;
    }

    public Line loosingLine(PlayerMark opponent, Marks marks) {
        for (Line line : LINES) {
            if (line.isLoosingLine(opponent, marks)) {
                return line;
            }
        }
        return null;
    }

    public List<Line> linesWhereJustOneCornerIsSelectedBy(PlayerMark playerMark, Marks marks) {
        List<Line> linesWithJustOneCornerMarked = new ArrayList<Line>();
        for (Line line : LINES_WITH_CORNERS) {
            if (line.hasSingleCornerMarkForPlayer(playerMark, marks)) {
                linesWithJustOneCornerMarked.add(line);
            }
        }
        return linesWithJustOneCornerMarked;
    }

    public PlayerMark winnerMark(Marks marks) {
        for (Line line : LINES) {
            if (line.isWinner(marks)) {
                return PlayerMark.byMark(marks.markAt(line.firstCell));
            }
        }
        return null;
    }
}
