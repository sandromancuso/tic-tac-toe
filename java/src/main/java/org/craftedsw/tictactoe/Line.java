package org.craftedsw.tictactoe;

import static org.apache.commons.lang3.StringUtils.remove;
import static org.apache.commons.lang3.StringUtils.repeat;
import static org.craftedsw.tictactoe.Board.EMPTY_CELL;

public class Line {

    private final int firstCell;
    private final int secondCell;
    private final int thirdCell;

    private int cells[] = new int[3];

    public Line(int firstCell, int secondCell, int thirdCell) {
        this.firstCell = firstCell;
        this.secondCell = secondCell;
        this.thirdCell = thirdCell;

        cells[0] = firstCell;
        cells[1] = secondCell;
        cells[2] = thirdCell;
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
        return Board.NO_CELL;
    }

}
