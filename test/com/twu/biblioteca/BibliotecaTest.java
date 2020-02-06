package com.twu.biblioteca;


import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.StringContains.containsString;
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
