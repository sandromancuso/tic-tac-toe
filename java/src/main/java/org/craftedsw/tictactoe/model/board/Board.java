package org.craftedsw.tictactoe.model.board;

import org.craftedsw.tictactoe.model.game.Player;
import org.craftedsw.tictactoe.view.BoardDisplay;

import static org.craftedsw.tictactoe.model.game.Player.PLAYER_ONE;
import static org.craftedsw.tictactoe.model.game.Player.PLAYER_TWO;

public class Board {

    private Marks marks = new Marks(new String[]{" ", " ", " ", " ", " ", " ", " ", " ", " "});
    private BoardLines boardLines = new BoardLines();

    private Player currentPlayer = PLAYER_ONE;

    public String representation() {
        return BoardDisplay.representation(marks);
    }

    public void place(int cellToBeMarked) {
        marks.placeMarkAt(cellToBeMarked, currentPlayer.mark());
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

    public Marks marks() {
        return marks;
    }

    private void switchPlayers() {
        currentPlayer = (currentPlayer == PLAYER_ONE)
                                ? PLAYER_TWO
                                : PLAYER_ONE;
    }

    public boolean isFull() {
        return marks().isFull();
    }
}
