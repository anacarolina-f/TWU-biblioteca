package com.twu.biblioteca;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.stream.Collectors;

public class BibliotecaService {

    private BibliotecaMenu menu = new BibliotecaMenu();
    private BookService bookService = new BookService();
    private Scanner scanner = new Scanner(System.in);
    private int bookId;
    private static final String WELCOME_MSG = "Welcome to Biblioteca. Your on-stop-shop for great book titles in Bangalore";
    private static final String ONLY_NUM = "Only numbers allowed.";
    private static final String QUIT = "Quit.";
    private static final String INVALID = "Invalid option.";

    public BibliotecaService() { }

    public void start() {
        System.out.println(menuStart());

        try {
            int option;
            do {
                option = userInput();
                showMenuOption(option);
            } while (option != 0);
        } catch (InputMismatchException e) {
            System.out.println(ONLY_NUM);
        }
    }

    private void showMenuOption(int option) {
        switch (option) {
            case 1:
                showListBooks();
                break;
            case 2:
                menuCheckoutBook();
                break;
            case 3:
                menuReturnBook();
                break;
            case 0:
                System.out.println(QUIT);
                break;
            default:
                menuInvalidOption();
                break;
        }
    }

    private void showListBooks() {
        System.out.println(showBookList());
        System.out.println(menu.showMainMenu());
    }

    private void menuCheckoutBook() {
        System.out.println(menu.showCheckoutMenu());
        bookId = userInput();
        checkoutBook(bookId);
        System.out.println(menu.showMainMenu());
    }

    private void menuReturnBook() {
        System.out.println(menu.showReturnMenu());
        bookId = userInput();
        returnBook(bookId);
        System.out.println(menu.showMainMenu());
    }

    private int userInput() {
        return scanner.nextInt();
    }

    private void menuInvalidOption() {
        System.out.println(INVALID);
        System.out.println(menu.showMainMenu());
    }

    private String menuStart() {
        return WELCOME_MSG + "\n" + menu.showMainMenu();
    }

    private String showBookList() {
        return bookService.getListAvailableBooks().stream().collect(Collectors.joining());
    }

    private void checkoutBook(int bookID) {
        System.out.println(bookService.checkoutBook(bookID) + "\n");
    }

    private void returnBook(int bookID) {
        System.out.println(bookService.returnBook(bookID) + "\n");
    }
}
