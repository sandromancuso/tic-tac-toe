package org.craftedsw.tictactoe;

import java.util.Arrays;
import java.util.List;

public class InvencibleOpponent implements Opponent {
    @Override
    public int nextMark(Board board) {
        List<String> marks = Arrays.asList(board.marks());
        return marks.indexOf(" ");
    }
}
