package org.craftedsw.tictactoe;

public class InvencibleOpponent implements Opponent {
    @Override
    public int nextMark(Board board) {
        return -1;
    }
}
