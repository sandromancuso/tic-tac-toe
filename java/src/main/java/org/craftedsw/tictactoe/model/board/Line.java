package org.craftedsw.tictactoe.model.board;

import org.craftedsw.tictactoe.model.game.Player;

import static org.apache.commons.lang3.StringUtils.remove;
import static org.apache.commons.lang3.StringUtils.repeat;
import static org.craftedsw.tictactoe.model.board.BoardStructure.EMPTY_CELL;
import static org.craftedsw.tictactoe.model.board.BoardStructure.NO_CELL;

public class Line {

    private final int firstCell;
    private final int secondCell;
    private final int thirdCell;

    public Line(int firstCell, int secondCell, int thirdCell) {
        this.firstCell = firstCell;
        this.secondCell = secondCell;
        this.thirdCell = thirdCell;
    }

    public boolean isWinner(Marks marks) {
        return (marks.at(firstCell) != EMPTY_CELL)
             && marks.at(firstCell).equals(marks.at(secondCell))
             && marks.at(secondCell).equals(marks.at(thirdCell));
    }

    public boolean isWinningLine(Player player, Marks marks) {
        return remove(lineAsString(marks), EMPTY_CELL).equals(repeat(player.mark(), 2));
    }

    public boolean isLoosingLine(Player opponent, Marks marks) {
        return isWinningLine(opponent, marks);
    }

    private String lineAsString(Marks marks) {
        return marks.at(firstCell)
                + marks.at(secondCell)
                + marks.at(thirdCell);
    }

    public int firstEmptyCell(Marks marks) {
        int[] lineCells = new int[] {firstCell, secondCell, thirdCell};
        for (int cell : lineCells) {
            if (marks.at(cell) == EMPTY_CELL) {
                return cell;
            }
        }
        return NO_CELL;
    }

    public boolean hasSingleCornerMarkForPlayer(Player player, Marks marks) {
        return lineAsString(marks).equals("  " + player.mark())
                || lineAsString(marks).equals(player.mark() + "  ");
    }

    public int emptyEdgeCell(Marks marks) {
        return marks.at(firstCell).trim().isEmpty()
                    ? firstCell
                    : marks.at(thirdCell).trim().isEmpty()
                        ? thirdCell
                        : NO_CELL;

    }
}
