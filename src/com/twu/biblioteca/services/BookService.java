package com.twu.biblioteca.services;

import com.twu.biblioteca.exceptions.ItemNotFoundException;
import com.twu.biblioteca.models.Book;
import com.twu.biblioteca.models.User;
import com.twu.biblioteca.repositories.BookRepository;

import java.util.List;
import java.util.stream.Collectors;

public class BookService {
    private BookRepository repository = new BookRepository();

    public BookService() {
    }

    public List<String> getListAvailableBooks() {
        return repository.getListOfBooks().stream()
                .filter(Book::isAvailable)
                .map(Book::toString)
                .collect(Collectors.toList());
    }

    public String checkoutBook(User user, int bookID) {
        List<Book> booksAvailable = repository.getListOfBooks();
        for (Book book : booksAvailable) {
            if (book.getId() == bookID) {
                if (book.isAvailable()) {
                    book.setAvailable(false);
                    book.setUser(user);
                    return "Thank you! Enjoy the book!";
                }
                else return "Sorry, that book is not available.";
            }
        }
        return new ItemNotFoundException("Book not found!").getMessage();
    }

    public String returnBook(int bookID) {
        List<Book> books = repository.getListOfBooks();
        for (Book book : books) {
            if (book.getId() == bookID) {
                if (!book.isAvailable()) {
                    book.setAvailable(true);
                    book.setUser(null);
                    return "Thank you for returning the book!";
                }
                else return "That is not a valid book to return.";
            }
        }
        return new ItemNotFoundException("Book not found!").getMessage();
    }

    public List<String> listBooksCheckedOut() {
        return repository.getListOfBooks()
                .stream()
                .filter(book -> !book.isAvailable())
                .map(Book::getUserBook)
                .collect(Collectors.toList());
    }

}
