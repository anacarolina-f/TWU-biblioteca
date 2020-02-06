package com.twu.biblioteca;


import com.twu.biblioteca.models.Book;
import com.twu.biblioteca.repositories.BibliotecaRepository;
import com.twu.biblioteca.services.BibliotecaService;
import com.twu.biblioteca.services.BookService;
import org.junit.Before;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class BibliotecaTest {

    private BibliotecaService bibliotecaService;
    private BookService bookService;
    private BibliotecaMenu menu;
    private BibliotecaRepository repository;
    private List<Book> books;

    @Before
    public void setUp() {
        bibliotecaService = new BibliotecaService();
        bookService = new BookService();
        menu = new BibliotecaMenu();
        repository = new BibliotecaRepository();
        books = repository.getListOfBooks();
    }


}
