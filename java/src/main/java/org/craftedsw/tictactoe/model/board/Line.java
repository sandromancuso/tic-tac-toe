package org.craftedsw.tictactoe.model.board;

import org.craftedsw.tictactoe.model.game.PlayerMark;

import static org.apache.commons.lang3.StringUtils.remove;
import static org.apache.commons.lang3.StringUtils.repeat;
import static org.craftedsw.tictactoe.model.board.BoardStructure.EMPTY_CELL;
import static org.craftedsw.tictactoe.model.board.BoardStructure.NO_CELL;

public class Line {

    public static final String DOUBLE_EMPTY_CELLS = "  ";
    public final int firstCell;
    public final int secondCell;
    public final int thirdCell;

    public Line(int firstCell, int secondCell, int thirdCell) {
        this.firstCell = firstCell;
        this.secondCell = secondCell;
        this.thirdCell = thirdCell;
    }

    public boolean isWinner(Marks marks) {
        return (marks.markAt(firstCell) != EMPTY_CELL)
             && marks.markAt(firstCell).equals(marks.markAt(secondCell))
             && marks.markAt(secondCell).equals(marks.markAt(thirdCell));
    }

    public boolean isWinningLine(PlayerMark playerMark, Marks marks) {
        return remove(lineAsString(marks), EMPTY_CELL).equals(repeat(playerMark.mark(), 2));
    }

    public boolean isLoosingLine(PlayerMark opponent, Marks marks) {
        return isWinningLine(opponent, marks);
    }

    public int firstEmptyCell(Marks marks) {
      int[] lineCells = new int[] {firstCell, secondCell, thirdCell};
        for (int cell : lineCells) {
            if (marks.markAt(cell) == EMPTY_CELL) {
                return cell;
            }
        }
        return NO_CELL;
    }

    public boolean hasSingleCornerMarkForPlayer(PlayerMark playerMark, Marks marks) {
        return lineAsString(marks).equals(DOUBLE_EMPTY_CELLS + playerMark.mark())
                || lineAsString(marks).equals(playerMark.mark() + DOUBLE_EMPTY_CELLS);
    }

    public int emptyEdgeCell(Marks marks) {
        return marks.isEmptyAt(firstCell)
                    ? firstCell
                    : marks.isEmptyAt(thirdCell)
                        ? thirdCell
                        : NO_CELL;

    }

    public boolean hasSingleMark(PlayerMark playerMark, Marks marks) {
        return playerMark.mark().equals(lineAsString(marks).trim());
    }

    private String lineAsString(Marks marks) {
        return marks.markAt(firstCell)
                + marks.markAt(secondCell)
                + marks.markAt(thirdCell);
    }

    public int numberOfMakedCells(Marks marks) {
        return lineAsString(marks).replace(" ", "").length();
    }
}
