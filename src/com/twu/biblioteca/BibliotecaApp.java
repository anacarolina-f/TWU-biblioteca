package com.twu.biblioteca;

import java.util.InputMismatchException;
import java.util.Scanner;

public class BibliotecaApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        BibliotecaService service = new BibliotecaService();

        System.out.println(service.welcomeMessage());
        System.out.println(service.menu());

        try {
            int option;
            do {
                option = scanner.nextInt();
                System.out.println(service.getMenuOption(option));
            } while (option != 0);


        } catch (InputMismatchException e) {
            System.out.println("Only numbers allowed.");
            e.getMessage();
        }


    }
}
