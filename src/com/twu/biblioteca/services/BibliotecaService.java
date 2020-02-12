package com.twu.biblioteca.services;

import com.twu.biblioteca.enums.UserType;
import com.twu.biblioteca.models.User;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class BibliotecaService {

    private MenuService menu = new MenuService();
    private BookService bookService = new BookService();
    private MovieService movieService = new MovieService();
    private LoginService loginService = new LoginService();
    private ConsoleInteractions console = new ConsoleInteractions();
    private int itemId;
    private static final String WELCOME_MSG = "Welcome to Biblioteca. Your on-stop-shop for great book titles in Bangalore";
    private static final String ONLY_NUM = "Only numbers allowed.";
    private static final String QUIT = "Quit.";
    private static final String INVALID = "Invalid option.";
    private static final String INVALID_USER = "Invalid user, please try again";
    private static final String LOGIN_USER = "Insert your userId: ";
    private static final String LOGIN_PASS = "Insert your password: ";
    private static final String HELLO = "Hello ";

    public BibliotecaService() { }

    public void start() {
        menuStart();
        try {
            int option;
            do {
                option = console.userInput();
                showMenuOption(option);
            } while (option != 0);
        } catch (InputMismatchException e) {
            console.printMessage(ONLY_NUM);
        }
    }

    private void showMenuOption(int option) {
        switch (option) {
            case 1:
                showListBooks();
                break;
            case 2:
                menuCheckout(2);
                break;
            case 3:
                menuReturnBook();
                break;
            case 4:
                showListMovies();
                break;
            case 5:
                menuCheckout(5);
                break;
            case 6:
                menuLibrarian();
                break;
            case 7:
                showUserInformation();
                break;
            case 0:
                console.printMessage(QUIT);
                break;
            default:
                menuInvalidOption();
                break;
        }
    }

    private void menuStart() {
        console.printMessage(WELCOME_MSG + "\n" + menu.showMainMenu());
    }

    private void showListBooks() {
        console.printMessage(showBookList());
        console.printMessage(menu.showMainMenu());
    }

    private void showListMovies() {
        console.printMessage(showMoviesList());
        console.printMessage(menu.showMainMenu());
    }

    private void menuCheckout(int option) {
        User verified = login();
        if (verified != null) {
            console.printMessage(menu.showCheckoutMenu(option));
            itemId = console.userInput();
            checkoutItem(verified, option, itemId);

            console.printMessage(menu.showMainMenu());
        } else {
            console.printMessage(INVALID_USER);
            login();
        }
    }

    private void menuLibrarian() {
        User verified = login();
        if (verified.getUserType().equals(UserType.LIBRARIAN)) {
            console.printMessage(menu.showLibrarianMenu() + "\n");
            int option = console.userInput();
            if (option == 1) {
                console.printMessage(showListBooksChecked() + "\n");
            }
        } else {
            console.printMessage(INVALID_USER);
        }
        console.printMessage(menu.showMainMenu());
    }

    private void menuInvalidOption() {
        console.printMessage(INVALID);
        console.printMessage(menu.showMainMenu());
    }

    private void checkoutItem(User user, int option, int itemId) {
        if (option == 2) {
            console.printMessage(bookService.checkoutBook(user, itemId) + "\n");
        } else if (option == 5) {
            console.printMessage(movieService.checkoutMovie(itemId));
        }
    }

    private void menuReturnBook() {
        User verified = login();
        if (verified != null) {
            console.printMessage(menu.showReturnMenu());
            itemId = console.userInput();
            returnBook(itemId);
            console.printMessage(menu.showMainMenu());
        } else {
            console.printMessage(INVALID_USER);
            login();
        }
    }

    private void showUserInformation() {
        User user = login();
        console.printMessage(user.toString());
        console.printMessage(menu.showMainMenu());
    }

    private List<String> showListBooksChecked() {
        return bookService.listBooksCheckedOut();
    }

    private User login() {
        console.printMessage(LOGIN_USER);
        String userId = console.userInputLogin();
        console.printMessage(LOGIN_PASS);
        String userPassword = console.userInputLogin();
        User user = loginService.userLogin(userId, userPassword);
        if (user != null) {
            console.printMessage(HELLO + user.getName());
            return user;
        }
        return null;
    }

    private String showBookList() {
        return bookService.getListAvailableBooks().stream().collect(Collectors.joining());
    }

    private String showMoviesList() {
        return movieService.getListAvailableMovies().stream().collect(Collectors.joining());
    }

    private void returnBook(int bookID) {
        console.printMessage(bookService.returnBook(bookID) + "\n");
    }
}
