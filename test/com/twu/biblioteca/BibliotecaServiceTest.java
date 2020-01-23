package com.twu.biblioteca;


import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class BibliotecaServiceTest {

    private BibliotecaService service;
    private BibliotecaRepository repository;
    private String listOfBooks;
    private List<Book> booksSaved;

    @Before
    public void setUp() {
        service = new BibliotecaService();
        repository = new BibliotecaRepository();
        listOfBooks = service.getListOfBooks();
        booksSaved = repository.getListOfBooks();
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

    @Test
    public void showMenu() {
        String expected = "Menu of Options: \n" +
                "(type the number of the option) \n" +
                "1 - List of Books \n" +
                "0 - Quit";
        assertEquals(expected, service.menu());
    }

    @Test
    public void chooseOptionOneFromMenuShouldShowListOfBooks() {
        int option = 1;
        assertThat(service.getMenuOption(option), is(listOfBooks + "\n" + service.menu()));
    }

    @Test
    public void chooseAnotherOptionShouldShowNotImplemented() {
        String expected = "Please select a valid option!\n" + service.menu();
        int option = 2;
        assertThat(service.getMenuOption(option), is(expected));
    }


}
