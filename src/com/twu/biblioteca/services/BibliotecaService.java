package com.twu.biblioteca.services;

import com.twu.biblioteca.BibliotecaMenu;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.stream.Collectors;

public class BibliotecaService {

    private BibliotecaMenu menu = new BibliotecaMenu();
    private BookService bookService = new BookService();
    private Scanner scanner = new Scanner(System.in);

    public BibliotecaService() { }

    public void start() {
        System.out.println(welcomeMessage());
        System.out.println(showMainMenu());

        try {
            int option;

            do {
                option = scanner.nextInt();
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
                        System.out.println("Quit.");
                        break;
                    default:
                        System.out.println("Invalid option.");
                        System.out.println(showMainMenu());
                        break;
                }
            } while (option != 0);

        } catch (InputMismatchException e) {
            System.out.println("Only numbers allowed.");
        }
    }

    public String welcomeMessage() {
        return "Welcome to Biblioteca. Your on-stop-shop for great book titles in Bangalore";
    }

    public String showMainMenu() {
        return menu.showMainMenu();
    }

    public String showBookList() {
        return bookService.getListAvailableBooks().stream().collect(Collectors.joining());
    }

    public String showMenuCheckout() {
        return menu.showCheckoutMenu();
    }

    public void checkoutBook(int bookID) {
        System.out.println(bookService.checkoutBook(bookID) + "\n");
    }

    public String showReturnMenu() {
        return menu.showReturnMenu();
    }

    public void returnBook(int bookID) {
        System.out.println(bookService.returnBook(bookID) + "\n");
    }
}
