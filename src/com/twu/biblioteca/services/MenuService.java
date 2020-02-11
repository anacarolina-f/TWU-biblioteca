package com.twu.biblioteca.services;

public class MenuService {
    private String mainMenu;
    private String checkoutBookMenu;
    private String checkoutMovieMenu;
    private String returnMenu;
    private String librarianMenu;

    public MenuService() {
        mainMenu = "Menu of Biblioteca: \n" +
                "(type the number of the option) \n" +
                "1 - List of Books \n" +
                "2 - Checkout a book \n" +
                "3 - Return a book \n" +
                "4 - List of Movies \n" +
                "5 - Checkout a Movie \n" +
                "6 - Librarian Menu \n" +
                "7 - User Information \n" +
                "0 - Quit";
        checkoutBookMenu = "Checkout Menu: \n" +
                "Type the book ID to checkout the book: ";
        returnMenu = "Return Menu: \n" +
                "Type the book ID you want to return: ";
        checkoutMovieMenu = "Checkout Menu: \n" +
                "Type the movie ID to checkout the movie: ";
        librarianMenu = "(type the number of the option) \n" +
                "1 - User with books checked out:";
    }

    public String showMainMenu() {
        return mainMenu;
    }

    public String showCheckoutMenu(int option) {
        if (option == 2) {
            return checkoutBookMenu;
        } else return checkoutMovieMenu;
    }

    public String showReturnMenu() {
        return returnMenu;
    }

    public String showLibrarianMenu() {
        return librarianMenu;
    }

}
