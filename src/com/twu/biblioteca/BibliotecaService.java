package com.twu.biblioteca;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.stream.Collectors;

public class BibliotecaService {

    private BibliotecaMenu menu = new BibliotecaMenu();
    private BookService bookService = new BookService();
    private Scanner scanner = new Scanner(System.in);
    private static final String WELCOME_MSG = "Welcome to Biblioteca. Your on-stop-shop for great book titles in Bangalore";
    private static final String ONLY_NUM = "Only numbers allowed.";
    private static final String QUIT = "Quit.";
    private static final String INVALID = "Invalid option.";

    public BibliotecaService() { }

    public void start() {
        System.out.println(welcomeMessage());
        System.out.println(showMainMenu());

        try {
            int option;
            do {
                option = scanner.nextInt();
                showMenuOption(option);
            } while (option != 0);

        } catch (InputMismatchException e) {
            System.out.println(ONLY_NUM);
        }
    }

    private void showMenuOption(int option) {
        int bookID;
        switch (option) {
            case 1:
                System.out.println(showBookList());
                System.out.println(showMainMenu());
                break;
            case 2:
                System.out.println(showMenuCheckout());
                bookID = scanner.nextInt();
                checkoutBook(bookID);
                System.out.println(showMainMenu());
                break;
            case 3:
                System.out.println(showReturnMenu());
                bookID = scanner.nextInt();
                returnBook(bookID);
                System.out.println(showMainMenu());
                break;
            case 0:
                System.out.println(QUIT);
                break;
            default:
                System.out.println(INVALID);
                System.out.println(showMainMenu());
                break;
        }
    }

    private String welcomeMessage() {
        return WELCOME_MSG;
    }

    private String showMainMenu() {
        return menu.showMainMenu();
    }

    private String showBookList() {
        return bookService.getListAvailableBooks().stream().collect(Collectors.joining());
    }

    private String showMenuCheckout() {
        return menu.showCheckoutMenu();
    }

    private void checkoutBook(int bookID) {
        System.out.println(bookService.checkoutBook(bookID) + "\n");
    }

    private String showReturnMenu() {
        return menu.showReturnMenu();
    }

    private void returnBook(int bookID) {
        System.out.println(bookService.returnBook(bookID) + "\n");
    }
}
