package com.twu.biblioteca;

public class BibliotecaMenu {
    private String mainMenu;
    private String checkoutMenu;
    private String returnMenu;

    public BibliotecaMenu() {
        mainMenu = "Menu of Options: \n" +
                "(type the number of the option) \n" +
                "1 - List of Books \n" +
                "2 - Checkout a book \n" +
                "3 - Return a book\n" +
                "0 - Quit";
        checkoutMenu = "Checkout Menu: " +
                "Type the book ID to checkout the book: ";
        returnMenu = "Return Menu: " +
                "Type the book ID you want to return: ";
    }

    public String showMainMenu() {
        return mainMenu;
    }

    public String showCheckoutMenu() {
        return checkoutMenu;
    }

    public String showReturnMenu() {
        return returnMenu;
    }

}
