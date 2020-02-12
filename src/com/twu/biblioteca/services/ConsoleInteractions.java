package com.twu.biblioteca.services;

import java.util.Scanner;

public class ConsoleInteractions {
    private Scanner scanner = new Scanner(System.in);

    public void printMessage(String message) {
        System.out.println(message);
    }

    public int userInput() {
        return scanner.nextInt();
    }

    public String userInputLogin() {
        return scanner.next();
    }
}
