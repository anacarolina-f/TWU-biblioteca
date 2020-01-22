package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

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
}
