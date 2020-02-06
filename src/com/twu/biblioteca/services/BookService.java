package com.twu.biblioteca.services;

import com.twu.biblioteca.repositories.BibliotecaRepository;
import com.twu.biblioteca.models.Book;
import com.twu.biblioteca.exceptions.BookNotFoundException;

import java.util.List;
import java.util.stream.Collectors;

public class BookService {
    private BibliotecaRepository repository = new BibliotecaRepository();

    public BookService() {
    }

    public List<String> getListAvailableBooks() {
        return repository.getListOfBooks().stream()
                .filter(Book::isAvailable)
                .map(Book::toString)
                .collect(Collectors.toList());
    }

    public String checkoutBook(int bookID) {
        List<Book> booksAvailable = repository.getListOfBooks();
        for (Book book : booksAvailable) {
            if (book.getId() == bookID) {
                if (book.isAvailable()) {
                    book.setAvailable(false);
                    return "Thank you! Enjoy the book!";
                }
                else return "Sorry, that book is not available.";
            }
        }
        return new BookNotFoundException("Book not found!").getMessage();
    }

    public String returnBook(int bookID) {
        List<Book> books = repository.getListOfBooks();
        for (Book book : books) {
            if (book.getId() == bookID) {
                if (!book.isAvailable()) {
                    book.setAvailable(true);
                    return "Thank you for returning the book!";
                }
                else return "That is not a valid book to return.";
            }
        }
        return new BookNotFoundException("Book not found!").getMessage();
    }
}
