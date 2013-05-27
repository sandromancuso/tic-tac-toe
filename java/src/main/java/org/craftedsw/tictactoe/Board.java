package org.craftedsw.tictactoe;

import static org.craftedsw.tictactoe.Player.PLAYER_ONE;
import static org.craftedsw.tictactoe.Player.PLAYER_TWO;

public class Board {

    public static final int CELL_1 = 0;
    public static final int CELL_2 = 1;
    public static final int CELL_3 = 2;
    public static final int CELL_4 = 3;
    public static final int CELL_5 = 4;
    public static final int CELL_6 = 5;
    public static final int CELL_7 = 6;
    public static final int CELL_8 = 7;
    public static final int CELL_9 = 8;

    public static final String EMPTY_CELL = " ";

    private String[] marks = new String[]{" ", " ", " ", " ", " ", " ", " ", " ", " "};
    private BoardLines boardLines = new BoardLines();

    private Player currentPlayer = PLAYER_ONE;


    public static final String ASK_FOR_NEXT_MARK = "Cell number for your next mark  >>> ";

    public String representation() {
        return BoardDisplay.representation(marks);
    }

    public void placeMarkOn(int cellToBeMarked) {
        marks[cellToBeMarked] = currentPlayer.mark();
        if (!hasWinner()) {
            switchPlayers();
        }
    }

    public boolean hasWinner() {
        return boardLines.hasWinnerLine(marks);
    }

    public Player winner() {
        return currentPlayer;
    }

    private void switchPlayers() {
        currentPlayer = (currentPlayer == PLAYER_ONE)
                                ? PLAYER_TWO
                                : PLAYER_ONE;
    }

    protected String[] marks() {
        return marks;
    }

}
