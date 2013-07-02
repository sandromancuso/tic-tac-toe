package org.craftedsw.tictactoe.model.board;

import org.craftedsw.tictactoe.model.game.Player;

import java.util.ArrayList;
import java.util.List;

import static org.craftedsw.tictactoe.model.board.BoardStructure.*;

public class BoardLines {

    public boolean hasWinnerLine(Marks marks) {
        for (Line line : LINES) {
            if (line.isWinner(marks)) {
                return true;
            }
        }
        return false;
    }

    public Line winningLine(Player player, Marks marks) {
        for (Line line : LINES) {
            if (line.isWinningLine(player, marks)) {
                return line;
            }
        }
        return null;
    }

    public Line loosingLine(Player opponent, Marks marks) {
        for (Line line : LINES) {
            if (line.isLoosingLine(opponent, marks)) {
                return line;
            }
        }
        return null;
    }

    // NEEDS UNIT TEST... JUST SPIKING TO SEE IF IT MAKES SENSE
    public List<Line> linesWhereJustOneCornerIsSelectedBy(Player player, Marks marks) {
        List<Line> linesWithJustOneCornerMarked = new ArrayList<Line>();
        for (Line line : LINES_WITH_CORNERS) {
            if (line.hasSingleCornerMarkForPlayer(player, marks)) {
                linesWithJustOneCornerMarked.add(line);
            }
        }
        return linesWithJustOneCornerMarked;
    }
}
