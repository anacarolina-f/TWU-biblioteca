package com.twu.biblioteca;


import com.twu.biblioteca.models.Book;
import com.twu.biblioteca.repositories.BookRepository;
import com.twu.biblioteca.services.BibliotecaService;
import com.twu.biblioteca.services.BookService;
import com.twu.biblioteca.services.MenuService;
import org.junit.Before;

import java.util.List;

public class BibliotecaTest {

    private BibliotecaService bibliotecaService;
    private BookService bookService;
    private MenuService menu;
    private BookRepository repository;
    private List<Book> books;

    @Before
    public void setUp() {
        bibliotecaService = new BibliotecaService();
        bookService = new BookService();
        menu = new MenuService();
        repository = new BookRepository();
        books = repository.getListOfBooks();
    }


}
