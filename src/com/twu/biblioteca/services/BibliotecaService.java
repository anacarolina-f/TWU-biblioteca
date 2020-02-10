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
    private Scanner scanner = new Scanner(System.in);
    private int itemId;
    private static final String WELCOME_MSG = "Welcome to Biblioteca. Your on-stop-shop for great book titles in Bangalore";
    private static final String ONLY_NUM = "Only numbers allowed.";
    private static final String QUIT = "Quit.";
    private static final String INVALID = "Invalid option.";
    private static final String INVALID_USER = "Invalid user, please try again";
    private static final String LOGIN_USER = "Insert your userId: ";

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
                System.out.println(QUIT);
                break;
            default:
                menuInvalidOption();
                break;
        }
    }

    private int userInput() {
        return scanner.nextInt();
    }

    private String userLogin() {
        return scanner.next();
    }

    private void menuLibrarian() {
        User verified = login();
        if (verified.getUserType().equals(UserType.LIBRARIAN)) {
            System.out.println(menu.showLibrarianMenu() + "\n");
            int option = userInput();
            if (option == 1) {
                System.out.println(showListBooksChecked() + "\n");
            }
        } else {
            System.out.println(INVALID_USER);
        }
        System.out.println(menu.showMainMenu());
    }

    private List<String> showListBooksChecked() {
        return bookService.listBooksCheckedOut();
    }

    private User login() {
        System.out.println(LOGIN_USER);
        String userId = userLogin();
        System.out.println("Insert your password: ");
        String userPassword = userLogin();
        User user = loginService.userLogin(userId, userPassword);
        if (user != null) {
            System.out.println("Hello " + user.getName());
            return user;
        }
        return null;
    }

    private void showListMovies() {
        System.out.println(showMoviesList());
        System.out.println(menu.showMainMenu());
    }

    private void showListBooks() {
        System.out.println(showBookList());
        System.out.println(menu.showMainMenu());
    }

    private void menuCheckout(int option) {
        User verified = login();
        if (verified != null) {
            System.out.println(menu.showCheckoutMenu(option));
            itemId = userInput();
            checkoutItem(verified, option, itemId);
            System.out.println(menu.showMainMenu());
        } else {
            System.out.println(INVALID_USER);
            login();
        }
    }

    private void menuReturnBook() {
        User verified = login();
        if (verified != null) {
            System.out.println(menu.showReturnMenu());
            itemId = userInput();
            returnBook(itemId);
            System.out.println(menu.showMainMenu());
        } else {
            System.out.println(INVALID_USER);
            login();
        }
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

    private String showMoviesList() {
        return movieService.getListAvailableMovies().stream().collect(Collectors.joining());
    }

    private void checkoutItem(User user, int option, int itemId) {
        if (option == 2) {
            System.out.println(bookService.checkoutBook(user, itemId) + "\n");
        } else if (option == 5) {
            System.out.println(movieService.checkoutMovie(itemId));
        }
    }

    private void returnBook(int bookID) {
        System.out.println(bookService.returnBook(bookID) + "\n");
    }

    private void showUserInformation() {
        User user = login();
        System.out.println(user.toString());
        System.out.println(menu.showMainMenu());
    }
}
