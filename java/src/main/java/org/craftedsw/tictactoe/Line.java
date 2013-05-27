package org.craftedsw.tictactoe;

class Line {

    private final int firstCell;
    private final int secondCell;
    private final int thirdCell;

    public Line(int firstCell, int secondCell, int thirdCell) {
        this.firstCell = firstCell;
        this.secondCell = secondCell;
        this.thirdCell = thirdCell;
    }

    public boolean isWinner(String[] marks) {
        return (marks[firstCell] != Board.EMPTY_CELL)
             && marks[firstCell].equals(marks[secondCell])
             && marks[secondCell].equals(marks[thirdCell]);
    }

}
