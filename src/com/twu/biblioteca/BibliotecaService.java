package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BibliotecaService {

    BibliotecaRepository repository;

    private String welcomeMessage = "Welcome to Biblioteca. Your on-stop-shop for great book titles in Bangalore";

    public String welcomeMessage() {
        return welcomeMessage;
    }

    public String getListOfBooks() {
        List<Book> bookList = repository.getListOfBooks();
        String booksColumn = "";

        for (Book book : bookList) {
            booksColumn = book.toString() + "\n" + booksColumn;
        }
        return booksColumn;
    }

    public String menu() {
        return "Menu of Options: \n" +
                "(type the number of the option) \n" +
                "1 - List of Books \n" +
                "0 - Quit";
    }

    public String getMenuOption(int option) {
        if (option == 1) {
            return getListOfBooks() + "\n" + menu();
        }
        else if (option == 0) {
            return "Quit";
        }
        else return "Please select a valid option!" + "\n" + menu();
    }

    public String getListOfAvailableBooks() {
        List<Book> bookList = repository.getListOfBooks();
        String booksColumn = "";

        for (Book book : bookList) {
            booksColumn = book.toString() + "\n" + booksColumn;
        }
        return booksColumn;
    }
}
