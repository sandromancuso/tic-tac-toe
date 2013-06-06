package org.craftedsw.tictactoe;

public class Marks {
    private final String[] marks;

    public Marks(String[] marksArray) {
        this.marks = marksArray;
    }

    public boolean isEmpty() {
        return stringRepresentation().trim().isEmpty();
    }

    private String stringRepresentation() {
        StringBuilder builder = new StringBuilder();
        for (String mark : marks) {
            builder.append(mark);
        }
        return builder.toString();
    }

    public boolean containsSingleMark() {
        return stringRepresentation().trim().length() == 1;
    }

    public boolean hasAnyCornerMarked() {
        return false;
    }
}
