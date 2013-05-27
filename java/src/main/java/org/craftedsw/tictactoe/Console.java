package org.craftedsw.tictactoe;

import java.util.Scanner;

public class Console {

    private Scanner scanner = new Scanner(System.in);

    public void print(String text) {
        System.out.println(text);
    }

    public int ask(String question) {
        System.out.print(question);
        return scanner.nextInt();
    }
}
