package com.twu.biblioteca;


import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class BibliotecaServiceTest {

    private BibliotecaService service;
    private BibliotecaRepository repository;

    private List<Book> books;


    @Before
    public void setUp() {
        service = new BibliotecaService();
        books = new ArrayList<Book>();
        books.add(new Book("Alexander and the Terrible", "Judith Viorst",  "1972"));
        books.add(new Book("Amelia Bedelia", "Peggy Parish", "1963"));
        books.add(new Book("Bark, George", "Jules Feiffer", "1999"));
        books.add(new Book("Because of Winn-Dixie", "Kate DiCamillo", "2000"));
        books.add(new Book("Bridge to Terabithia",  "Katherine Paterson", "1977"));
        books.add(new Book("Curious George", "H.A. Rey", "1941"));
        books.add(new Book("Freight Train", "Donald Crews", "1978"));
    }

    @Test
    public void welcomeMessageWhenStarts() {
        String expected = "Welcome to Biblioteca. Your on-stop-shop for great book titles in Bangalore";
        assertEquals(expected, service.welcomeMessage());
    }

    @Test
    public void listOfBooksContainsBook() {
        String expected = "Title: Freight Train -- Author: 'Donald Crews -- Year Published: '1978.";
        assertTrue(service.getListOfBooks().contains(expected));
    }
}
